

package amsys_logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import amsys_common.BusinessException;
import amsys_common.SystemException;
import amsys_dao.ConnectionManager;
import amsys_dao.CustomerDAO;
import amsys_dao.OrderDAO;
import amsys_entity.Customer;
import amsys_entity.OrderTotalByItem;


public class OrderTotalByItemLogic {
	//総計を格納する変数
	private int sumTotal = 0;
	private Customer customer = null;


	public ArrayList<OrderTotalByItem> total(String custCode)
			throws BusinessException, SystemException {
		Connection con = null;

		ArrayList<OrderTotalByItem> orderList;

		try {

			// コネクションを取得
			con = ConnectionManager.getConnection();
			//customerDao生成
			CustomerDAO custDao = new CustomerDAO(con);
			//findCustomer顧客情報取得
			customer = custDao.findCustomerIgnoreDeleteFlag(custCode);
			System.out.println("customer(logic): " + customer);
			// dao生成
			OrderDAO ordDao = new OrderDAO(con);

			// createOrderTotalListByCustomerメソッドを呼び出し結果を受け取る
			orderList = ordDao.createOrderTotalListByItem(custCode);
			// 結果がnullであれば業務エラーを発生させる
			if (customer == null) {
				throw new BusinessException("得意先が見つかりません。");
			}
			//総計を求める
			for(OrderTotalByItem o : orderList) {
				sumTotal += o.getTotalPrice();
			}

		} catch (SQLException e) {
			throw new SystemException("システムエラーが発生しました。サービス管理者にお問い合わせください。");
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

	public Customer getCustomer() {
		return customer;
	}

}
