/**
 * CustomerNumberingDAO.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package amsys_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author FLM
 * @version 1.0.0
 */
public class CustomerNumberingDAO {
	private Connection con;

	public CustomerNumberingDAO(Connection con){
		this.con = con;
	}

	//採番テーブルから最新の採番ナンバーを取得するメソッド
	public int findCustomerCode() throws SQLException {
		//採番を取得するSQL　for updateを行うこと排他ロックを行い確認中に更新が行われるのを防ぐ
		String sql = "SELECT customer_code FROM customer_numbering for update;";
		PreparedStatement stmt = null;
		ResultSet res = null;
		int number = 0;

		try {
			stmt = con.prepareStatement(sql);
			res = stmt.executeQuery();
			if(res.next()) {
				//取得した値から採番ナンバーを変数に格納
				number = res.getInt("customer_code");
			}
		}finally {
			if(res != null) {
				res.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		}
		return number;
	}
	//登録作業後、採番テーブルの値を更新するメソッド
	public boolean updateCustomerCode() throws SQLException {
		String sql = "UPDATE customer_numbering  SET customer_code = customer_code + 1";
		PreparedStatement stmt = null;
		boolean result = false;
		try {
			stmt = con.prepareStatement(sql);
			int count = stmt.executeUpdate();
			//結果が1の場合更新成功なのでresultをtrueに変更
			if(count == 1) {
				result = true;
			}
		}finally {
			if(stmt != null) {
				stmt.close();
			}
		}
		return result;
	}
}
