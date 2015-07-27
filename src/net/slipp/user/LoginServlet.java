package net.slipp.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/users/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		try {
			User.login(userId, password);
			session.setAttribute("userId", userId);
			// 상태정보들을 유지하고싶을때 사용할수 있는 것 -> session
			// HTTP 프로토콜 상태에서는 웹페이지를 이동할때 데이터 유지 불가 -> 세션을통해 데이터유지
			response.sendRedirect("/");
			// session- > 서버 메모리에 저장됨 , 정말 중요한 것만 저장

		} catch (UserNotFoundException e) {
			// 메시지 담을때 -> request에 담을 수 있음
			// requestdispatcher 가 포워드할때 request 인스턴스 전달 request에 담긴 데이터가
			// login.jsp에 전달됨
			forwardJSP(request, response, "존재하지 않는 사용자 입니다. 다시 로그인하세요.");

		} catch (PasswordMismatchException e) {
			forwardJSP(request, response, "비밀번호가 틀립니다. 다시 로그인하세요.");
		}
	}

	private void forwardJSP(HttpServletRequest request,
			HttpServletResponse response, String errorMessage)
			throws ServletException, IOException {
		request.setAttribute("errorMessage", errorMessage); // jsp
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp"); // 페이지
		rd.forward(request, response);
	}

}
