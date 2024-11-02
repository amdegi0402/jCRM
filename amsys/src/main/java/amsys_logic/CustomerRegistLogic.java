/**
 * CustomerRegistLogic.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package amsys_logic;

import java.sql.Connection;
import java.sql.SQLException;
import amsys_common.BusinessException;
import amsys_common.SystemException;
import amsys_dao.ConnectionManager;
import amsys_dao.CustomerDAO;
import amsys_dao.CustomerNumberingDAO;
import amsys_entity.Customer;

/**
 *
 * @author FLM
 * @version 1.0.0
 */
public class CustomerRegistLogic {
	public Customer registCustomer(Customer customer)
			throws BusinessException, SystemException {
		Connection con = null;
		boolean result = false;

		try {

			// コネクションを取得
			con = ConnectionManager.getConnection();
			// autocommitを解除
			con.setAutoCommit(false);
			// dao生成
			CustomerNumberingDAO numDAO = new CustomerNumberingDAO(con);
			CustomerDAO dao = new CustomerDAO(con);
			// findCustomerCodeメソッドを呼び出し採番テーブルから最新のナンバーを取得
			int latestCustomerCode = numDAO.findCustomerCode();
			// 取得した採番をもとにエンティティオブジェクトにcustomerCodeを登録
			String customerCode
					= "KA" + String.format("%04d", latestCustomerCode + 1);
			customer.setCustCode(customerCode);
			// エンティティオブジェクトの情報をDBに登録する
			customer = dao.insertCustomer(customer);
			// 採番テーブルのナンバーを更新する
			result = numDAO.updateCustomerCode();
			if (result == false) {
				con.rollback();
				throw new BusinessException("得意先の登録に失敗しました。");
			}
			con.commit();

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SystemException("システムエラーが発生しました。/nサービス管理者にお問い合わせください。");
		}
		return customer;

	}

}
