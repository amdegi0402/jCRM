/**
 * CustomerDeleteLogic.java
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
public class CustomerDeleteLogic {


	public Customer findCustomer(String custCode) throws BusinessException, SystemException {
		Connection con = null;
		Customer customer = null;

		try {
			//コネクションを取得
			con = ConnectionManager.getConnection();
			//dao生成
			CustomerDAO dao = new CustomerDAO(con);
			//findCusotmerメソッドを呼び出し結果を受け取る
			customer = dao.findCustomer(custCode);
			//結果がnullであれば業務エラーを発生させる
			if(customer == null) {
				throw new BusinessException("得意先が見つかりません。");
			}

		}catch(SQLException e) {
			throw new SystemException("システムエラーが発生しました。/サービス管理者にお問い合わせください。");
		}
		return customer;

	}
	public Customer deleteCustomer(Customer customer)
			throws BusinessException, SystemException {
		Connection con = null;
		boolean result = false;

		try {

			// コネクションを取得
			con = ConnectionManager.getConnection();
			// autocommitを解除
			con.setAutoCommit(false);
			// dao生成
			CustomerDAO dao = new CustomerDAO(con);
			//得意先情報を検索
			customer = dao.findCustomer(customer.getCustCode());
			// deleteCustomerメソッドを呼び出しDBの得意先データを削除
			 result = dao.deleteCustomer(customer);
			//削除結果がfalseであれば削除失敗のため業務エラーを発生させる
			if (result == false) {
				con.rollback();
				throw new BusinessException("得意先の削除に失敗しました。");
			}
			con.commit();

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SystemException("システムエラーが発生しました。サービス管理者にお問い合わせください。");
		}
		return customer;

	}
}
