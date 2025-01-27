

package amsys_logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import amsys_common.BusinessException;
import amsys_common.SystemException;
import amsys_dao.ConnectionManager;
import amsys_dao.CustomerDAO;
import amsys_entity.Customer;


public class CustomerListLogic {

	public ArrayList<Customer> findAllCustomer()
			throws BusinessException, SystemException {
		Connection con = null;
		ArrayList<Customer> customerList = new ArrayList<>();

		try {
			// コネクションを取得
			con = ConnectionManager.getConnection();
			// dao生成
			CustomerDAO dao = new CustomerDAO(con);
			// findCusotmerメソッドを呼び出し結果を受け取る
			customerList = dao.findAllCustomer();
			// 結果がnullであれば業務エラーを発生させる
			if (customerList.isEmpty()) {
				throw new BusinessException("得意先が見つかりません。");
			}

		} catch (SQLException e) {
			throw new SystemException("システムエラーが発生しました。/サービス管理者にお問い合わせください。");
		}
		return customerList;

	}

}
