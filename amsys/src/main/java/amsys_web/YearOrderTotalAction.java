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
import amsys_entity.OrderTotalByCustomer;
import amsys_logic.CustomerFindLogic;
import amsys_logic.MonthlyOrderTotalLogic;
import amsys_logic.YearOrderTotalLogic;
import jakarta.servlet.http.HttpServletRequest;



/**
 *
 * @author FLM
 * @version 1.0.0
 */
public class YearOrderTotalAction implements ActionIF{

	public String execute(HttpServletRequest request) {
		// 遷移先ページ名の設定
		String page = "V302_01YearOrderTotalView.jsp";

		try {
			// パラメータの取得
			String year = request.getParameter("year");

			// パラメータ未送信または未入力の場合
			// BusinessExceptionをスローする
			// エラーメッセージリストの生成
			if (year == null || year.equals("")) {
				throw new BusinessException("西暦が選択されていません。");
			}

			// 業務Logic呼び出し
			YearOrderTotalLogic logic = new YearOrderTotalLogic();
			//データが格納されたエンティティリストを格納
			ArrayList<OrderTotalByCustomer> orderList = logic.total(year);
			//ロジックで計算している総計を取得
			int sumTotal = logic.getSumTotal();
			//リクエストスコープへ値を格納
			request.setAttribute("orderList", orderList);
			request.setAttribute("sumTotal", sumTotal);

		} catch (BusinessException e) {
			// 業務エラー発生時
			// エラーメッセージ、エラーメッセージリストをリクエストスコープに格納
			//request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessageList", e.getMessageList());
			// 遷移先ページ名の設定
			page = "V302_01YearOrderTotalView.jsp";
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
