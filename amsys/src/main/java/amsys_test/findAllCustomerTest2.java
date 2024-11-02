/**
 * findCustomerTest.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package amsys_test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import amsys_dao.ConnectionManager;
import amsys_dao.CustomerDAO;
import amsys_entity.Customer;

/**
 *
 * @author FLM
 * @version 1.0.0
 */
public class findAllCustomerTest2 {

	public static void main(String[] args) {
		Connection con = null;
		ArrayList<Customer> customerList = new ArrayList<>();
		try {
			// データベース接続の設定（適切なURL、ユーザー名、パスワードを設定してください）
			con = ConnectionManager.getConnection();
			// テスト対象のCustomerDAOのインスタンスを作成
			CustomerDAO dao = new CustomerDAO(con);

			// 存在する顧客コードでのテスト
			customerList = dao.findAllCustomer();
			if (!customerList.isEmpty()) {
				for(Customer customer : customerList) {
					System.out.println();
					System.out.println("Customer found: " + customer.getCustCode());
					System.out.println("Customer found: " + customer.getCustName());
					System.out.println("Customer found: " + customer.getTelNo());
					System.out.println("Customer found: " + customer.getPostalCode());
					System.out.println("Customer found: " + customer.getAddress());
					System.out.println("Customer found: " + customer.getDiscountRate());
				}

			} else {
				System.out.println("Customer not found.");
			}

			// 存在しない顧客コードでのテスト
			Customer nonExistentCustomer = dao.findCustomer("99999");
			if (nonExistentCustomer == null) {
				System.out.println("Customer not found as expected.");
			} else {
				System.out.println("Unexpected customer found: "
						+ nonExistentCustomer.getCustName());
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
