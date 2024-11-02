/**
 * deleteCustomerTest.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package amsys_test;

import java.sql.Connection;
import java.sql.SQLException;

import amsys_dao.ConnectionManager;
import amsys_dao.CustomerDAO;
import amsys_entity.Customer;

/**
 *
 * @author FLM
 * @version 1.0.0
 */
public class deleteCustomerTest {
	public static void main(String[] args) {

		Connection con = null;

		try {
			// データベース接続
			con = ConnectionManager.getConnection();
			CustomerDAO dao = new CustomerDAO(con);

			// テストケース1: 削除対象の顧客が存在する場合
			Customer customer1 = new Customer();
			customer1.setCustCode("KA0002");
			boolean result1 = dao.deleteCustomer(customer1);
			System.out.println(
					"Test Case 1: " + (result1 ? "Passed" : "Failed"));

			// テストケース2: 削除対象の顧客が既に削除されている場合
			Customer customer2 = new Customer();
			customer2.setCustCode("KA0001");
			boolean result2 = dao.deleteCustomer(customer2);
			System.out.println(
					"Test Case 2: " + (result2 ? "Passed" : "Failed"));

			// テストケース3: 削除対象の顧客が存在しない場合
			Customer customer3 = new Customer();
			customer2.setCustCode("KA0000");
			boolean result3 = dao.deleteCustomer(customer3);
			System.out.println(
					"Test Case 3: " + (result3 ? "Passed" : "Failed"));

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
