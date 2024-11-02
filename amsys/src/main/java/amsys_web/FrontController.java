/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * FrontController.java
 *
 */
package amsys_web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/amsysFC" })
public class FrontController extends HttpServlet {
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *          response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		// ページパス
		String path = "/WEB-INF/jsp/";
		String page = null;
		// Actionクラス初期化
		ActionIF action = null;
		// ボタンID取得
		String buttonId = request.getParameter("buttonId");
		//初回アクセスの処理
		if (buttonId == null || buttonId.equals("")) {
			buttonId = "V101_01";
		}else {
			//2回目以降のアクセス毎にセッションチェックさせる（セッションがなければログイン画面に遷移）
			HttpSession session = request.getSession(false);
			if(session == null) buttonId = "V101_01";
		}

		// 遷移先ページ
		switch (buttonId) {
			case "V101_00":
				action = new LogoutAction();
				page = action.execute(request);
				break;
			case "V101_01":
				page = "V101_01Login.jsp";
				break;
			case "V101_03":
				action = new LoginAction();
				page = action.execute(request);
				break;
			case "V101_02":
				page = "V101_02MainMenu.jsp";
				break;
			// デフォルトページ
			case "V201_01":
				page = "V201_01CustomerSearchView.jsp";
				break;
			// 得意先検索画面（検索ボタン）
			case "V201_02":
				action = new CustomerFindAction();
				page = action.execute(request);
				break;
			// 得意先登録画面
			case "V202_01":
				page = "V202_01CustomerRegistView.jsp";
				break;
			// 得意先検索画面（検索ボタン）
			case "V202_02":
				action = new CustomerRegistAction();
				page = action.execute(request);
				break;
			case "V203_01":
				page = "V203_01CustomerDeleteView.jsp";
				break;
			// 得意先検索画面（検索ボタン）
			case "V203_02_01":
				action = new CustomerDeleteFindAction();
				page = action.execute(request);
				break;

			// 得意先検索画面（検索ボタン）
			case "V203_02_02":
				action = new CustomerDeleteExecuteAction();
				page = action.execute(request);
				break;
			case "V204_01":
				page = "V204_01CustomerChangeFindView.jsp";
				break;
			// 得意先検索画面（検索ボタン）
			case "V204_02":
				action = new CustomerChangeFindAction();
				page = action.execute(request);
				break;
			case "V204_03":
				action = new CustomerChangeExecuteAction();
				page = action.execute(request);
				break;
			case "V205_01":
				action = new CustomerListAction();
				page = action.execute(request);
				break;
			case "V301_01":
				page = "V301_01MonthlyOrderTotalView.jsp";
				break;
			case "V301_02":
				action = new MonthlyOrderTotalAction();
				page = action.execute(request);
				break;
			case "V302_01":
				page = "V302_01YearOrderTotalView.jsp";
				break;
			case "V302_02":
				action = new YearOrderTotalAction();
				page = action.execute(request);
				break;
			case "V303_01":
				page = "V303_01OrderTotalByItemView.jsp";
				break;
			case "V303_02":
				action = new OrderTotalByItemAction();
				page = action.execute(request);
				break;

		}

		// 結果画面に転送
		RequestDispatcher rd = request.getRequestDispatcher(path + page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *          response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
