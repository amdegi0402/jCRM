/**
 * CustomerDeleteAction.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package amsys_web;

import java.util.ArrayList;

import amsys_common.BusinessException;
import amsys_common.SystemException;
import amsys_entity.Customer;
import amsys_logic.CustomerChangeLogic;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author FLM
 * @version 1.0.0
 */
public class CustomerChangeExecuteAction implements ActionIF {
	public String execute(HttpServletRequest request) {
		// 遷移先ページ名の設定
		String page = "V204_02CustomerChangeResultView.jsp";
		Customer customer = null;
		ArrayList<String> errorMessageList = new ArrayList<>();

		try {
			// パラメータの取得
			String custCode = request.getParameter("custCode");
			String custName = request.getParameter("custName");
			String telNo = request.getParameter("telNo");
			String postalCode = request.getParameter("postalCode");
			String address = request.getParameter("address");
			String discountRate = request.getParameter("discountRate");
			// 入力チェック
			if (custCode == null || custCode.equals("")) {
				errorMessageList.add("得意先コードが入力されていません。");
			}
			if (custName == null || custName.equals("")) {
				errorMessageList.add("得意先名が入力されていません。");
			}
			if (telNo == null || telNo.equals("")) {
				errorMessageList.add("電話番号が入力されていません。");
			}
			if (postalCode == null || postalCode.equals("")) {
				errorMessageList.add("郵便番号が入力されていません。");
			}
			if (address == null || address.equals("")) {
				errorMessageList.add("住所が入力されていません。");
			}
			if (discountRate == null || discountRate.equals("")) {
				errorMessageList.add("割引率が入力されていません。");
			}
			if (!errorMessageList.isEmpty()) {
				throw new BusinessException(errorMessageList);
			}

			// 得意先情報をセット
			customer = new Customer(custCode, custName, telNo, postalCode,
					address, Integer.parseInt(discountRate));
			// 業務Logic呼び出し
			CustomerChangeLogic logic = new CustomerChangeLogic();
			customer = logic.changeCustomer(customer);
			request.setAttribute("customer", customer);

		} catch (BusinessException e) {
			// 業務エラー発生時
			// エラーメッセージ、エラーメッセージリストをリクエストスコープに格納
			request.setAttribute("errorMessage", e.getMessage());
			// 遷移先ページ名の設定
			page = "V204_02CustomerChangeResultView.jsp";
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
