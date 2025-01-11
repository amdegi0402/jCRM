

package amsys_web;

import amsys_common.BusinessException;
import amsys_common.SystemException;
import amsys_entity.Customer;
import amsys_logic.CustomerDeleteLogic;
import jakarta.servlet.http.HttpServletRequest;


public class CustomerDeleteFindAction implements ActionIF{
	public String execute(HttpServletRequest request) {
		// 遷移先ページ名の設定
		String page = "V203_01CustomerDeleteView.jsp";
		Customer customer = null;
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
			CustomerDeleteLogic logic = new CustomerDeleteLogic();
			customer = logic.findCustomer(custCode);
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
