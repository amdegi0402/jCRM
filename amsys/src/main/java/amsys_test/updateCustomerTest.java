

package amsys_test;

import java.sql.Connection;
import java.sql.SQLException;

import amsys_dao.ConnectionManager;
import amsys_dao.CustomerDAO;
import amsys_entity.Customer;


public class updateCustomerTest {
	 public static void main(String[] args) {
	        // テスト用のCustomerオブジェクトを作成
	        Customer customer = new Customer();
	        customer.setCustCode("KA0020");
	        customer.setCustName("Test Name");
	        customer.setTelNo("123-4567");
	        customer.setPostalCode("123-4567");
	        customer.setAddress("Test Address");
	        customer.setDiscountRate(10);

	        // テスト用のデータベース接続を作成
	        Connection con = null;
	        try {
	            // ここでは、適切なJDBC URL, ユーザー名, パスワードを指定する必要があります
	            con = ConnectionManager.getConnection();

	            // テスト対象メソッドを呼び出す
	            CustomerDAO customerDAO = new CustomerDAO(con);
	            boolean result = customerDAO.updateCustomer(customer);

	            // 結果を確認
	            if (result) {
	                System.out.println("updateCustomer: 成功");
	            } else {
	                System.out.println("updateCustomer: 失敗");
	            }

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
