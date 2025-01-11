
package amsys_test;

import java.sql.Connection;
import java.sql.SQLException;

import amsys_dao.ConnectionManager;
import amsys_dao.EmployeeDAO;
import amsys_entity.Employee;


public class EmployeeDAOTest {

	public static void main(String[] args) throws SQLException {

		Connection con = ConnectionManager.getConnection();
		try {

			// EmployeeDAOのインスタンスを作成
			EmployeeDAO employeeDAO = new EmployeeDAO(con);

			// テストケース1: 存在する従業員を検索
			testFindExistingEmployee(employeeDAO);

			// テストケース2: 存在しない従業員を検索
			testFindNonExistingEmployee(employeeDAO);

		} finally {
			// 接続を閉じる
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void testFindExistingEmployee(EmployeeDAO employeeDAO) {
		try {
			// 実際のデータベースに存在する従業員番号とパスワードを使用してください
			Employee employee = employeeDAO.findEmployee("H20001", "zy0001");
			if (employee != null) {
				System.out.println("テストケース1: 成功 - 従業員が見つかりました");
				System.out.println("従業員番号: " + employee.getEmployeeNo());
				System.out.println("従業員名: " + employee.getEmployeeName());
			} else {
				System.out.println("テストケース1: 失敗 - 従業員が見つかりませんでした");
			}
		} catch (SQLException e) {
			System.out.println("テストケース1: エラー - " + e.getMessage());
		}
	}

	private static void testFindNonExistingEmployee(EmployeeDAO employeeDAO) {
		try {
			// 存在しない従業員番号とパスワードを使用
			Employee employee
					= employeeDAO.findEmployee("E999", "wrongpassword");
			if (employee == null) {
				System.out.println("テストケース2: 成功 - 存在しない従業員は見つかりませんでした");
			} else {
				System.out.println("テストケース2: 失敗 - 存在しない従業員が見つかりました");
			}
		} catch (SQLException e) {
			System.out.println("テストケース2: エラー - " + e.getMessage());
		}
	}
}
