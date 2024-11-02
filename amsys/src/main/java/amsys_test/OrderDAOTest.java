/**
 * OrderDAOTest.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package amsys_test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import amsys_dao.ConnectionManager;
import amsys_dao.OrderDAO;
import amsys_entity.OrderTotalByCustomer;

/**
 *
 * @author FLM
 * @version 1.0.0
 */
public class OrderDAOTest {
	public static void main(String[] args) {
        Connection con = null;

        try {

            // データベース接続の確立
            con = ConnectionManager.getConnection();

            // テスト対象のメソッドを呼び出し
            OrderDAO testClass = new OrderDAO(con); // 実際のクラス名に置き換えてください
            ArrayList<OrderTotalByCustomer> result = testClass.createOrderTotalListByCustomer("2022", "03");

            // 結果の表示
            for (OrderTotalByCustomer customer : result) {
                System.out.println("Customer Code: " + customer.getCustCode());
                System.out.println("Customer Name: " + customer.getCustName());
                System.out.println("Total Price: " + customer.getTotalPrice());
                System.out.println("-----");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // データベース接続のクローズ
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
