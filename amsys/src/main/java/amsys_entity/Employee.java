/**
 * Employee.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package amsys_entity;

import java.io.Serializable;

/**
 *
 * @author FLM
 * @version 1.0.0
 */
public class Employee implements Serializable{
	private String employeeNo;
	private String employeeName;
	private String password;

	/**
	 *
	 */
	public Employee() {
		super();
	}

	/**
	 * @param employeeNo
	 * @param employeeName
	 * @param password
	 */
	public Employee(String employeeNo, String employeeName, String password) {
		super();
		this.employeeNo = employeeNo;
		this.employeeName = employeeName;
		this.password = password;
	}

	/**
	 * employeeNoのGetter
	 * @return employeeNo
	 */
	public String getEmployeeNo() {
		return employeeNo;
	}

	/**
	 * employeeNoのSetter
	 * @param employeeNo
	 */
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	/**
	 * employeeNameのGetter
	 * @return employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * employeeNameのSetter
	 * @param employeeName
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * passwordのGetter
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * passwordのSetter
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
