
package amsys_web;

import java.util.ArrayList;

import amsys_common.BusinessException;
import amsys_common.SystemException;
import amsys_entity.Employee;
import amsys_logic.LoginLogic;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;



public class LoginAction implements ActionIF{

	public String execute(HttpServletRequest request) {
		// 遷移先ページ名の設定
		String page = "V101_02MainMenu.jsp";
		try {
			// パラメータの取得
			String employeeNo = request.getParameter("employeeNo");
			String password = request.getParameter("password");

			// パラメータ未送信または未入力の場合
			// EmployeeBusinessExceptionをスローする

			// エラーメッセージリストの生成
			ArrayList<String> errorMessageList = new ArrayList<>();
			if (employeeNo == null || employeeNo.equals("")) {
				errorMessageList.add("従業員番号が未入力です。");
			}
			if (password == null || password.equals("")) {
				errorMessageList.add("パスワードが未入力です。");
			}
			if (!errorMessageList.isEmpty()) {
				throw new BusinessException(errorMessageList);
			}

			// 業務Logic呼び出し
			LoginLogic logic = new LoginLogic();
			Employee employee = logic.login(employeeNo,password);

			// セッションの生成
			HttpSession session = request.getSession();
			// ログイン情報の格納
			session.setAttribute("employee", employee);
		} catch (BusinessException e) {
			// 業務エラー発生時
			// エラーメッセージ、エラーメッセージリストをリクエストスコープに格納
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessageList", e.getMessageList());
			// 遷移先ページ名の設定
			page = "V101_01Login.jsp";
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
