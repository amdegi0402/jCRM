/**
 * customerNumberingDAOTest.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package amsys_test;

/**
 *
 * @author FLM
 * @version 1.0.0
 */
import java.sql.Connection;
import java.sql.SQLException;
import amsys_dao.ConnectionManager;
import amsys_dao.CustomerNumberingDAO;

public class CustomerNumberingDAOTest {
    public static void main(String[] args) {
        Connection con = null;
        CustomerNumberingDAO dao = null;

        try {
            // データベース接続
            con = ConnectionManager.getConnection();
            dao = new CustomerNumberingDAO(con);

            // テスト findCustomerCode メソッド
            int currentCode = dao.findCustomerCode();
            System.out.println("Current Customer Code: " + currentCode);

            // テスト updateCustomerCode メソッド
            boolean isUpdated = dao.updateCustomerCode();
            System.out.println("Update Success: " + isUpdated);

            // 再度 findCustomerCode メソッドで確認
            int newCode = dao.findCustomerCode();
            System.out.println("New Customer Code: " + newCode);

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
