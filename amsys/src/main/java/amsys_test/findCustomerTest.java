

package amsys_test;

import java.sql.Connection;
import java.sql.SQLException;

import amsys_dao.ConnectionManager;
import amsys_dao.CustomerDAO;
import amsys_entity.Customer;


public class findCustomerTest {

	public static void main(String[] args) {
		Connection con = null;
		try {
			// データベース接続の設定（適切なURL、ユーザー名、パスワードを設定してください）
			con = ConnectionManager.getConnection();
			// テスト対象のCustomerDAOのインスタンスを作成
			CustomerDAO dao = new CustomerDAO(con);

			// 存在する顧客コードでのテスト
			Customer customer = dao.findCustomer("KA0002");
			if (customer != null) {
				System.out.println(
						"Customer found: " + customer.getCustName());
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
