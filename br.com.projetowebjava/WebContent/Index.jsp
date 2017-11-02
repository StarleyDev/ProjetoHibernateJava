<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<head>
<meta charset="UTF-8">
<title>Login Servlet</title>
</head>
<link rel="stylesheet" type="text/css"
	href="ConteudoCssJs/css/LoginCss.css">


<body class="main">

	<div class="login-screen"></div>
	<div class="login-center">
		<div class="container min-height" style="margin-top: 20px;">
			<div class="row">
				<div class="col-xs-4 col-md-offset-8">
					<div class="login" id="card">
						<div class="front signin_form">
							<p>LOGIN</p>
							<form class="login-form" method="post" action="Login">
								<div class="form-group">
									<div class="input-group">
										<input type="text" class="form-control"
											placeholder="Digite seu login" nome="us"> <span
											class="input-group-addon"> <i
											class="glyphicon glyphicon-user"></i>
										</span>
									</div>
								</div>
								<div class="form-group">
									<div class="input-group">
										<input type="password" class="form-control"
											placeholder="Digite seu password" nome="pwd"> <span
											class="input-group-addon"> <i
											class="glyphicon glyphicon-lock"></i>
										</span>
									</div>
								</div>
								<div class="checkbox">
									<label><input type="checkbox">Salvar login?</label>
								</div>

								<div class="form-group sign-btn">
									<input type="submit" class="btn" value="ACESSAR">
									<p>
										<a href="#" class="forgot">Esqueceu sua senha?</a>
									</p>

								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="ConteudoCssJs/Js/LoginJs.js"></script>

</body>
</head>
</html>