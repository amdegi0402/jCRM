/**
 * LoginLogic.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package amsys_logic;

import java.sql.Connection;
import java.sql.SQLException;

import amsys_common.BusinessException;
import amsys_common.SystemException;
import amsys_dao.ConnectionManager;
import amsys_dao.EmployeeDAO;
import amsys_entity.Employee;

/**
 *
 * @author FLM
 * @version 1.0.0
 */
public class LoginLogic {
	public Employee login(String employeeNo, String password) throws BusinessException, SystemException {
		Connection con = null;
		Employee employee = null;

		try {
			con = ConnectionManager.getConnection();
			//EmployeeDAOオブジェクト生成
			EmployeeDAO empDAO = new EmployeeDAO(con);
			//メソッドに引数を渡し参照結果を受け取る
			employee = empDAO.findEmployee(employeeNo, password);
			if(employee == null) {
				throw new BusinessException("登録された従業員が見つかりませんでした。");
			}
		}catch(SQLException e) {
			throw new SystemException("システムエラーが発生しました。/サービス管理者にお問い合わせください。");
		}

		return employee;

	}
}
