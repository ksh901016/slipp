package net.slipp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {
	// private String name; 필드에서 개발하면안됨

	// get 방식으로 요청하는 기능에 대해서 동작을 할 수 있음
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		System.out.println("Request Success!!");
		resp.getWriter().print(name + " Hello World from Servlet!!"); //ctrl+6 서버 재시작
	}
}
