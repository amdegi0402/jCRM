

package amsys_web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


public class LogoutAction implements ActionIF{

	public String execute(HttpServletRequest request) {
		// 遷移先ページ名の設定
		String page = "V101_01Login.jsp";
		HttpSession session = request.getSession(false);
		// セッションが存在する場合は破棄
		if (session != null) {
		    session.invalidate();
		}
		return page;
	}

}
