/**
 * CustomerRegistAction.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package amsys_web;

import java.util.ArrayList;

import amsys_common.BusinessException;
import amsys_common.SystemException;
import amsys_entity.Customer;
import amsys_logic.CustomerRegistLogic;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author FLM
 * @version 1.0.0
 */
public class CustomerRegistAction implements ActionIF{
	public String execute(HttpServletRequest request) {
		// 遷移先ページ名の設定
		String page = "V202_02CustomerRegistResultView.jsp";
		ArrayList<String> errorMessageList = new ArrayList<>();
		Customer customer = null;
		try {
			// パラメータの取得
			String custName = request.getParameter("custName");
			String telNo = request.getParameter("telNo");
			String postalCode = request.getParameter("postalCode");
			String address = request.getParameter("address");
			String discountRate = request.getParameter("discountRate");

			// パラメータ未送信または未入力の場合
			// BusinessExceptionをスローする
			// エラーメッセージリストの生成
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
			if(!errorMessageList.isEmpty()) {
				throw new BusinessException(errorMessageList);
			}

			//エンティティオブジェクト生成
			customer = new Customer();
			//エンティティに情報をセット
			customer.setCustName(custName);
			customer.setTelNo(telNo);
			customer.setPostalCode(postalCode);
			customer.setAddress(address);
			customer.setDiscountRate(Integer.parseInt(discountRate));

			// 業務Logic呼び出し
			CustomerRegistLogic logic = new CustomerRegistLogic();
			customer = logic.registCustomer(customer);
			request.setAttribute("customer", customer);

		} catch (BusinessException e) {
			// 業務エラー発生時
			// エラーメッセージ、エラーメッセージリストをリクエストスコープに格納
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessageList", e.getMessageList());
			// 遷移先ページ名の設定
			page = "V202_01CustomerRegistView.jsp";
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
