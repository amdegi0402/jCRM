/**
 * CustomerFindLogic.java
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
import amsys_entity.Customer;

/**
 *
 * @author FLM
 * @version 1.0.0
 */
public class CustomerFindLogic {

	public Customer findCustomer(String custCode)
			throws BusinessException, SystemException {
		Connection con = null;
		Customer customer = null;

		try {
			// コネクションを取得
			con = ConnectionManager.getConnection();
			// dao生成
			CustomerDAO dao = new CustomerDAO(con);
			// findCusotmerメソッドを呼び出し結果を受け取る
			customer = dao.findCustomer(custCode);
			// 結果がnullであれば業務エラーを発生させる
			if (customer == null) {
				throw new BusinessException("得意先が見つかりません。");
			}

		} catch (SQLException e) {
			throw new SystemException("システムエラーが発生しました。/サービス管理者にお問い合わせください。");
		}
		return customer;

	}

}
