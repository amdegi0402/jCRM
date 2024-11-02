/**
 * CustomerDAO.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package amsys_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import amsys_entity.Customer;

/**
 *
 * @author FLM
 * @version 1.0.0
 */
public class CustomerDAO {
	private Connection con = null;

	public CustomerDAO(Connection con) {
		this.con = con;
	}

	public Customer findCustomer(String custCode) throws SQLException {
		String sql
				= "SELECT customer_code, customer_name, customer_telno, customer_postalcode, customer_address, discount_rate FROM customer WHERE customer_code=? AND delete_flag=false";
		Customer customer = null;
		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			// DBへ渡すSQLを格納
			stmt = con.prepareStatement(sql);
			// 引数で受け取ったcustCodeをSQL文に挿入
			stmt.setString(1, custCode);
			// DBへアクセスして結果の値を受け取る
			res = stmt.executeQuery();
			// 結果に値があればエンティティオブジェクトに情報をセット
			if (res.next()) {
				customer = new Customer(res.getString("customer_code"),
						res.getString("customer_name"),
						res.getString("customer_telno"),
						res.getString("customer_postalcode"),
						res.getString("customer_address"),
						res.getInt("discount_rate"));
			}
		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return customer;
	}

	// 登録
	public Customer insertCustomer(Customer customer) throws SQLException {
		String sql = "INSERT INTO customer VALUES(?, ?, ?, ?, ?, ?, 0)";
		PreparedStatement stmt = null;

		try {
			// DBへ渡すSQLを格納
			stmt = con.prepareStatement(sql);
			// 引数で受け取ったcustCodeをSQL文に挿入
			stmt.setString(1, customer.getCustCode());
			stmt.setString(2, customer.getCustName());
			stmt.setString(3, customer.getTelNo());
			stmt.setString(4, customer.getPostalCode());
			stmt.setString(5, customer.getAddress());
			stmt.setInt(6, customer.getDiscountRate());
			// DBへアクセスして結果の値を受け取る
			stmt.executeUpdate();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return customer;
	}

	// 削除
	public boolean deleteCustomer(Customer customer) throws SQLException {
		String sql
				= "UPDATE customer SET delete_flag=true WHERE customer_code=? AND delete_flag = false";
		PreparedStatement stmt = null;
		boolean result = false;
		try {
			// DBへ渡すSQLを格納
			stmt = con.prepareStatement(sql);
			// 引数で受け取ったcustCodeをSQL文に挿入
			stmt.setString(1, customer.getCustCode());
			// DBへアクセスして結果の値を受け取る
			int count = stmt.executeUpdate();
			// 結果が1であれば更新成功と判断できるためresultをtrueに変更
			if (count == 1) {
				result = true;
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return result;
	}

	// 更新
	public boolean updateCustomer(Customer customer) throws SQLException {
		String sql
				= "update customer set customer_name=?,customer_telno=?,customer_postalcode=?,customer_address=?,discount_rate=? where customer_code=? ";
		boolean result = false;
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, customer.getCustName());
			stmt.setString(2, customer.getTelNo());
			stmt.setString(3, customer.getPostalCode());
			stmt.setString(4, customer.getAddress());
			stmt.setInt(5, customer.getDiscountRate());
			stmt.setString(6, customer.getCustCode());

			int count = stmt.executeUpdate();
			if (count == 1) {
				result = true;
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return result;

	}

	// 一覧表示
	public ArrayList<Customer> findAllCustomer() throws SQLException {
		String sql
				= "SELECT customer_code, customer_name, customer_telno, customer_postalcode, customer_address, discount_rate FROM customer WHERE delete_flag=false";
		PreparedStatement stmt = null;
		ResultSet res = null;
		ArrayList<Customer> customerList = new ArrayList<>();

		try {
			// DBへ渡すSQLを格納
			stmt = con.prepareStatement(sql);
			// DBへアクセスして結果の値を受け取る
			res = stmt.executeQuery();
			// 結果に値があればエンティティオブジェクトに情報をセット
			while (res.next()) {
				Customer customer = new Customer(res.getString("customer_code"),
						res.getString("customer_name"),
						res.getString("customer_telno"),
						res.getString("customer_postalcode"),
						res.getString("customer_address"),
						res.getInt("discount_rate"));
				customerList.add(customer);
			}
		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return customerList;
	}

	// 顧客を検索 削除フラグを無視
	public Customer findCustomerIgnoreDeleteFlag(String custCode) throws SQLException {
		String sql
		= "SELECT customer_code, customer_name, customer_telno, customer_postalcode, customer_address, discount_rate FROM customer WHERE customer_code=? AND delete_flag=false";
		Customer customer = null;
		PreparedStatement stmt = null;
		ResultSet res = null;

		try {
			// DBへ渡すSQLを格納
			stmt = con.prepareStatement(sql);
			// 引数で受け取ったcustCodeをSQL文に挿入
			stmt.setString(1, custCode);
			// DBへアクセスして結果の値を受け取る
			res = stmt.executeQuery();
			// 結果に値があればエンティティオブジェクトに情報をセット
			if (res.next()) {
				customer = new Customer(res.getString("customer_code"),
						res.getString("customer_name"),
						res.getString("customer_telno"),
						res.getString("customer_postalcode"),
						res.getString("customer_address"),
						res.getInt("discount_rate"));
			}
		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return customer;
	}
}
