<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="net.slipp.user.User"%>
<%@ page import="net.slipp.db.Database"%>
<%
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	
	if(User.login(userId, password)){
		//상태정보들을 유지하고싶을때 사용할수 있는 것 -> session
        //HTTP 프로토콜 상태에서는 웹페이지를 이동할때 데이터 유지 불가 -> 세션을통해 데이터유지
		session.setAttribute("userId", userId);
	}
	
	response.sendRedirect("/");
%>