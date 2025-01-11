

package amsys_test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import amsys_dao.ConnectionManager;
import amsys_dao.OrderDAO;
import amsys_entity.OrderTotalByCustomer;
import amsys_entity.OrderTotalByItem;


public class OrderDAOTest3 {
	public static void main(String[] args) {
        Connection con = null;

        try {

            // データベース接続の確立
            con = ConnectionManager.getConnection();

            // テスト対象のメソッドを呼び出し
            OrderDAO testClass = new OrderDAO(con); // 実際のクラス名に置き換えてください
            ArrayList<OrderTotalByItem> result = testClass.createOrderTotalListByItem("KA0001");

            // 結果の表示
            for (OrderTotalByItem item : result) {
                System.out.println("Item Code: " + item.getItemCode());
                System.out.println("Item Name: " + item.getItemName());
                System.out.println("Total Amount: " + item.getTotalAmount());
                System.out.println("Price: " + item.getPrice());
                System.out.println("Total Price: " + item.getTotalPrice());
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
