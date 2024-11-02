/**
 * OrderDAO.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package amsys_dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import amsys_entity.OrderTotalByCustomer;
import amsys_entity.OrderTotalByItem;

/**
 *
 * @author FLM
 * @version 1.0.0
 */
public class OrderDAO implements Serializable{
	private Connection con;

	public OrderDAO(Connection con) {
		this.con = con;
	}

	public ArrayList<OrderTotalByCustomer> createOrderTotalListByCustomer(String year, String month) throws SQLException {

		ArrayList<OrderTotalByCustomer> orderTotalCustomer = new ArrayList<>();
		String sql = "SELECT o.customer_code, c.customer_name, SUM(o.total_price) FROM orders AS o INNER JOIN customer AS c ON o.customer_code = c.customer_code WHERE o.order_date LIKE ? GROUP BY o.customer_code, c.customer_name";
		PreparedStatement  stmt = null;
		ResultSet res = null;

		try {
			stmt = con.prepareStatement(sql);
			 // 年と月を結合して1つのパラメータとしてセットする(%はワイルドカードの意味をもちLIKE句に渡されます）
	        stmt.setString(1, year + "-" + month + "%");
			res = stmt.executeQuery();

			//得意先コード、名前、金額を取得しエンティティにセット
			while(res.next()) {
				OrderTotalByCustomer otCustomer = new OrderTotalByCustomer(
						res.getString("customer_code"),
						res.getString("customer_name"),
						res.getInt("sum(o.total_price)"));
				orderTotalCustomer.add(otCustomer);
			}
		}finally {
			if(stmt != null) stmt.close();
			if(res != null) res.close();
		}
		return orderTotalCustomer;

	}

	public ArrayList<OrderTotalByCustomer> createOrderTotalListByCustomer(String year) throws SQLException {

		ArrayList<OrderTotalByCustomer> orderTotalCustomer = new ArrayList<>();
		String sql = "SELECT o.customer_code, c.customer_name, SUM(o.total_price) FROM orders AS o INNER JOIN customer AS c ON o.customer_code = c.customer_code WHERE o.order_date LIKE ? GROUP BY o.customer_code, c.customer_name";
		PreparedStatement  stmt = null;
		ResultSet res = null;

		try {
			stmt = con.prepareStatement(sql);
			 // 年をパラメータとしてセットする(%はワイルドカードの意味をもちLIKE句に渡されます）
	        stmt.setString(1, year + "%");
			res = stmt.executeQuery();

			//得意先コード、名前、金額を取得しエンティティにセット
			while(res.next()) {
				OrderTotalByCustomer otCustomer = new OrderTotalByCustomer(
						res.getString("customer_code"),
						res.getString("customer_name"),
						res.getInt("sum(o.total_price)"));
				orderTotalCustomer.add(otCustomer);
			}
		}finally {
			if(stmt != null) stmt.close();
			if(res != null) res.close();
		}
		return orderTotalCustomer;

	}

	public ArrayList<OrderTotalByItem> createOrderTotalListByItem(String custCode) throws SQLException {

		ArrayList<OrderTotalByItem> orderTotalItem = new ArrayList<>();
		String sql = "SELECT i.item_code, i.item_name, i.price, SUM(o.order_num) AS total_quantity, SUM(o.order_price) AS total_price FROM item AS i INNER JOIN order_details AS o ON i.item_code = o.item_code"
				+ " INNER JOIN orders ON o.order_no = orders.order_no WHERE orders.customer_code = ? GROUP BY i.item_code, i.item_name, i.price";
		PreparedStatement  stmt = null;
		ResultSet res = null;

		try {
			stmt = con.prepareStatement(sql);
	        stmt.setString(1, custCode);
			res = stmt.executeQuery();

			//商品コード、商品名、注文数、単価、合計を取得しエンティティにセット
			while(res.next()) {
				OrderTotalByItem item = new OrderTotalByItem(
						res.getString("item_code"),
						res.getString("item_name"),
						res.getInt("total_quantity"),
						res.getInt("price"),
						res.getInt("total_price"));
				orderTotalItem.add(item);
			}
		}finally {
			if(stmt != null) stmt.close();
			if(res != null) res.close();
		}
		return orderTotalItem;

	}
}
