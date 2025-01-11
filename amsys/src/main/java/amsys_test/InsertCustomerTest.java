

package amsys_test;


import java.sql.Connection;

import java.sql.SQLException;

import amsys_dao.ConnectionManager;
import amsys_dao.CustomerDAO;
import amsys_entity.Customer;

public class InsertCustomerTest {
	public static void main(String[] args) {
		Connection con = null;
		CustomerDAO dao = null;

		try {
			// データベース接続
			con = ConnectionManager.getConnection();
			dao = new CustomerDAO(con);

			// テスト用のCustomerオブジェクトを作成
			Customer customer = new Customer();
			customer.setCustCode("KA0018");
			customer.setCustName("John Doe");
			customer.setTelNo("012-345-6789");
			customer.setPostalCode("123-4567");
			customer.setAddress("123 Main St, Anytown, AN");
			customer.setDiscountRate(10);

			// テスト insertCustomer メソッド
			Customer insertedCustomer = dao.insertCustomer(customer);
			if (insertedCustomer != null) {
				System.out.println("Customer inserted successfully:");
				System.out.println("Code: " + insertedCustomer.getCustCode());
				System.out.println("Name: " + insertedCustomer.getCustName());
			} else {
				System.out.println("Customer insertion failed.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
