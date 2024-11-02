/**
 * LoginAction.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package amsys_web;

import java.util.ArrayList;

import amsys_common.BusinessException;
import amsys_common.SystemException;
import amsys_entity.Customer;
import amsys_logic.CustomerFindLogic;
import amsys_logic.CustomerListLogic;
import jakarta.servlet.http.HttpServletRequest;



/**
 *
 * @author FLM
 * @version 1.0.0
 */
public class CustomerListAction implements ActionIF{

	public String execute(HttpServletRequest request) {
		// 遷移先ページ名の設定
		String page = "V205_01CustomerListView.jsp";
		ArrayList<Customer> customerList = new ArrayList<>();
		try {

			// 業務Logic呼び出し
			CustomerListLogic logic = new CustomerListLogic();
			customerList = logic.findAllCustomer();
			request.setAttribute("customerList", customerList);

		} catch (BusinessException e) {
			// 業務エラー発生時
			// エラーメッセージ、エラーメッセージリストをリクエストスコープに格納
			request.setAttribute("errorMessage", e.getMessage());
			// 遷移先ページ名の設定
			page = "V201_01CustomerSearchView.jsp";
		} catch (SystemException e) {
			// システムエラー発生時
			// エラーメッセージをリクエストスコープに格納
			request.setAttribute("errorMessage", e.getMessage());
			// 遷移先ページ名の設定
			page = "V901_01SystemErrorPage.jsp";
		}
		return page;
	}

}
