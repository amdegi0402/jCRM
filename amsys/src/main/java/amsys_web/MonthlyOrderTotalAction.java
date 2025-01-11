
package amsys_web;

import java.util.ArrayList;

import amsys_common.BusinessException;
import amsys_common.SystemException;
import amsys_entity.Customer;
import amsys_entity.OrderTotalByCustomer;
import amsys_logic.CustomerFindLogic;
import amsys_logic.MonthlyOrderTotalLogic;
import jakarta.servlet.http.HttpServletRequest;



public class MonthlyOrderTotalAction implements ActionIF{

	public String execute(HttpServletRequest request) {
		// 遷移先ページ名の設定
		String page = "V301_01MonthlyOrderTotalView.jsp";
		ArrayList<String> errorMessageList = new ArrayList<>();
		try {
			// パラメータの取得
			String year = request.getParameter("year");
			String month = request.getParameter("month");

			// パラメータ未送信または未入力の場合
			// BusinessExceptionをスローする
			// エラーメッセージリストの生成
			if (year == null || year.equals("")) {
				errorMessageList.add("西暦が選択されていません。");
			}
			if (month == null || month.equals("")) {
				errorMessageList.add("月が選択されていません。");
			}
			if(!errorMessageList.isEmpty()) {
				throw new BusinessException(errorMessageList);
			}

			// 業務Logic呼び出し
			MonthlyOrderTotalLogic logic = new MonthlyOrderTotalLogic();
			//データが格納されたエンティティリストを格納
			ArrayList<OrderTotalByCustomer> orderList = logic.total(year, month);
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
			page = "V301_01MonthlyOrderTotalView.jsp";
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
