

package amsys_web;

import java.util.ArrayList;

import amsys_common.BusinessException;
import amsys_common.SystemException;
import amsys_entity.Customer;
import amsys_entity.OrderTotalByItem;
import amsys_logic.OrderTotalByItemLogic;
import jakarta.servlet.http.HttpServletRequest;

public class OrderTotalByItemAction implements ActionIF{

	public String execute(HttpServletRequest request) {
		// 遷移先ページ名の設定
		String page = "V303_01OrderTotalByItemView.jsp";

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
			OrderTotalByItemLogic logic = new OrderTotalByItemLogic();
			//データが格納されたエンティティリストを格納
			ArrayList<OrderTotalByItem> orderList = logic.total(custCode);
			//ロジックで計算している総計を取得
			int sumTotal = logic.getSumTotal();
			//customerオブジェクト取得
			Customer customer = logic.getCustomer();
			//リクエストスコープへ値を格納
			request.setAttribute("orderList", orderList);
			request.setAttribute("sumTotal", sumTotal);
			request.setAttribute("customer", customer);

		} catch (BusinessException e) {
			// 業務エラー発生時
			// エラーメッセージ、エラーメッセージリストをリクエストスコープに格納
			//request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessage", e.getMessage());
			// 遷移先ページ名の設定
			page = "V303_01OrderTotalByItemView.jsp";
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
