<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%@include file="./commons/_head.jspf"%>
</head>

<body>
	<%@include file="./commons/_top.jspf"%>

	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
			<div class="page-header">
				<h1>회원가입</h1>
            </div>
				<form class="form-horizontal" action="/form_action.jsp" method="post">
					<div class="control-group">
						<label class="control-label" for="userId">사용자 아이디</label>
						<div class="controls">
							<input type="text" name="userId" value="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">비밀번호</label>
						<div class="controls">
							<input type="password" id="password" name="password" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">이름</label>
						<div class="controls">
							<input type="text" id="name" name="name" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">이메일</label>
						<div class="controls">
							<input type="text" id="email" name="email" placeholder="" />
						</div>
					</div>
					<br>
					<div class="control-group">
						<button type="submit" class="btn btn-default">회원가입</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- /.container -->


</body>

</html>