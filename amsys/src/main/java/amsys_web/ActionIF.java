
package amsys_web;

import jakarta.servlet.http.HttpServletRequest;

public interface ActionIF {
	/**
	 * リクエスト時の処理を実行する。
	 *
	 * @param request
	 *            リクエスト情報
	 * @return 遷移先ページ名
	 */
	public String execute(HttpServletRequest request);
}
