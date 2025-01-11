
package amsys_logic;

import java.sql.Connection;
import java.sql.SQLException;

import amsys_common.BusinessException;
import amsys_common.SystemException;
import amsys_dao.ConnectionManager;
import amsys_dao.CustomerDAO;
import amsys_entity.Customer;


public class CustomerChangeLogic {
	public Customer findCustomer(String custCode)
			throws BusinessException, SystemException {
		Connection con = null;
		Customer customer = null;
		try {
			// コネクションを取得
			con = ConnectionManager.getConnection();
			// dao生成
			CustomerDAO dao = new CustomerDAO(con);
			// 得意先検索
			customer = dao.findCustomer(custCode);
			//得意先が見つからなければ業務エラーを返す
			if (customer == null) {
				throw new BusinessException("得意先が見つかりません。");
			}
		} catch (SQLException e) {
			throw new SystemException("システムエラーが発生しました。/nサービス管理者にお問い合わせください。");
		}
		return customer;

	}
	public Customer changeCustomer(Customer customer)
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
			// 得意先検索
			result = dao.updateCustomer(customer);
			//得意先が見つからなければ業務エラーを返す
			if (result == false) {
				throw new BusinessException("得意先情報の更新に失敗しました。");
			}
			con.commit();
		} catch (SQLException e) {
			try {
				con.rollback();
				throw new SystemException("システムエラーが発生しました。サービス管理者にお問い合わせください。");
			}catch(SQLException e2) {
				e2.getStackTrace();
			}
			throw new SystemException("システムエラーが発生しました。サービス管理者にお問い合わせください。");
		}
		return customer;

	}
}
