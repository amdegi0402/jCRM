/**
 * LoginAction.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package amsys_web;

import amsys_common.BusinessException;
import amsys_common.SystemException;
import amsys_entity.Customer;
import amsys_logic.CustomerFindLogic;
import jakarta.servlet.http.HttpServletRequest;



/**
 *
 * @author FLM
 * @version 1.0.0
 */
public class CustomerFindAction implements ActionIF{

	public String execute(HttpServletRequest request) {
		// 遷移先ページ名の設定
		String page = "V201_02CustomerSearchResultView.jsp";
		try {
			// パラメータの取得
			String custCode = request.getParameter("custCode");

			// パラメータ未送信または未入力の場合
			// BusinessExceptionをスローする
			// エラーメッセージリストの生成
			if (custCode == null || custCode.equals("")) {
				throw new BusinessException("得意先コードが入力されていません。");
			}

			// 業務Logic呼び出し
			CustomerFindLogic logic = new CustomerFindLogic();
			Customer customer = logic.findCustomer(custCode);
			System.out.println("(Action)custoemr" + customer);
			request.setAttribute("customer", customer);

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
