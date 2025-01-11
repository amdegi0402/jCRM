

package amsys_logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import amsys_common.BusinessException;
import amsys_common.SystemException;
import amsys_dao.ConnectionManager;
import amsys_dao.CustomerDAO;
import amsys_dao.OrderDAO;
import amsys_entity.Customer;
import amsys_entity.OrderTotalByCustomer;


public class MonthlyOrderTotalLogic {
	//総計を格納する変数
	private int sumTotal = 0;

	public ArrayList<OrderTotalByCustomer> total(String year, String month)
			throws BusinessException, SystemException {
		Connection con = null;
		ArrayList<OrderTotalByCustomer> orderList;

		try {

			// コネクションを取得
			con = ConnectionManager.getConnection();
			// dao生成
			OrderDAO dao = new OrderDAO(con);
			//monthの値を2桁になるように整形
			month = String.format(month, "%02");
			// createOrderTotalListByCustomerメソッドを呼び出し結果を受け取る
			orderList = dao.createOrderTotalListByCustomer(year, month);
			// 結果がnullであれば業務エラーを発生させる
			if (orderList.isEmpty()) {
				throw new BusinessException("得意先が見つかりません。");
			}
			//総計を求める
			for(OrderTotalByCustomer o : orderList) {
				sumTotal += o.getTotalPrice();
			}

		} catch (SQLException e) {
			throw new SystemException("システムエラーが発生しました。/サービス管理者にお問い合わせください。");
		}
		return orderList;

	}
	/**
	 * sumTotalのGetter
	 * @return sumTotal
	 */
	public int getSumTotal() {
		return sumTotal;
	}
	/**
	 * sumTotalのSetter
	 * @param sumTotal
	 */
	public void setSumTotal(int sumTotal) {
		this.sumTotal = sumTotal;
	}


}
