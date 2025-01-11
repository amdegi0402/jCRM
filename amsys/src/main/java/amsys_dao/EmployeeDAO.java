/**
 * EmployeeDAO.java
 *
 *
 */

package amsys_dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import amsys_entity.Employee;


public class EmployeeDAO implements Serializable{
	private Connection con;

	public EmployeeDAO(Connection con) {
		this.con = con;
	}

	public Employee findEmployee(String employeeNo, String password)
			throws SQLException {
		// DBから従業員情報を参照するSQL文
		String sql = "SELECT employee_no,employee_name,password FROM employee WHERE employee_no=? AND password=?";
		// SQL文を格納しDBに伝える役割
		PreparedStatement stmt = null;
		// 参照結果の値をを格納する役割
		ResultSet res = null;
		// エンティティオブジェクト
		Employee employee = null;

		try {
			// sqlを格納
			stmt = con.prepareStatement(sql);
			// 引数で受け取ったemployeeNoとpasswordをsql文に記述
			stmt.setString(1, employeeNo);
			stmt.setString(2, password);
			// DBにアクセス結果を受け取る
			res = stmt.executeQuery();
			// 結果から値を取り出しエンティティに値をセット
			if (res.next()) {
				employee = new Employee(res.getString("employee_no"),
						res.getString("employee_name"),
						res.getString("password"));
			}
		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return employee;

	}

}
