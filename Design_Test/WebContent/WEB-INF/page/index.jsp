<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>投资者情绪</title>
<link type="image/x-icon" rel="shortcut icon" href="../logo.ico" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="<%=basePath%>/resource/pages/js/jquery-1.12.3.min.js"></script>
<script src="<%=basePath%>/resource/bootstrap/js/bootstrap.min.js"></script>
<script
	src="<%=basePath%>/resource/bootstrap/js/bootstrap-datepicker.js"></script>

<link rel="stylesheet"
	href="<%=basePath%>/resource/bootstrap/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=basePath%>/resource/bootstrap/css/datepicker.css" />
<link rel="stylesheet"
	href="<%=basePath%>/resource/pages/css/commen.css" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="span12">
				<div class="navbar">
					<div class="navbar-inner">
						<div class="container-fluid">
							<a data-target=".navbar-responsive-collapse"
								data-toggle="collapse" class="btn btn-navbar"><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span></a> <a href="<%=basePath%>"
								class="brand">投资者情绪</a>
							<div class="nav-collapse collapse navbar-responsive-collapse">
								<ul class="nav">
									<li class="active"><a href="<%=basePath%>">首页</a></li>
									<li ><a href="<%=basePath%>/page/mood.do">指数信息</a></li>
									<li><a href="<%=basePath%>/page/daymood.do">每日信息</a></li>
									<li><a href="<%=basePath%>/page/note.do">论坛信息</a></li>
									<li><a href="<%=basePath%>/page/interface.do">程序接口</a></li>
									<li><a href="<%=basePath%>/page/about.do">关于</a></li>
							</div>
						</div>
					</div>
				</div>
				<div id="myCarousel" class="carousel slide">
					<ol class="carousel-indicators">
						<li class="active" data-slide-to="0"
							data-target="#carousel-257249"></li>
						<li data-slide-to="1" data-target="#carousel-257249"></li>
						<li data-slide-to="2" data-target="#carousel-257249"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<a href="#index_one_content"><img alt="" src="<%=basePath%>/resource/pages/image/11.jpg" /></a>
							<div class="carousel-caption">
								<h4>理论模型</h4>
								<p>源自经济理论，采用SPSS建模技术，融合神经网络算法，打造卓越的指数模型。</p>
							</div>
						</div>
						<div class="item">
							<a href="#index_two_content"><img alt="" src="<%=basePath%>/resource/pages/image/21.jpg" width="1600px" height="500px"/></a>
							<div class="carousel-caption">
								<h4>多方位数据展示</h4>
								<p>不同纬度，不同视角为你全方位展示投资者情绪指数。</p>
							</div>
						</div>
						<div class="item">
							<a href="#index_three_content"><img alt="" src="<%=basePath%>/resource/pages/image/31.jpg" /></a>
							<div class="carousel-caption">
								<h4>多种数据接口</h4>
								<p>完善的第三方接口支持JAVA,Python等多种程序的调用</p>
							</div>
						</div>
					</div>
					<a class="carousel-control left" href="#myCarousel"
						data-slide="prev">&lsaquo;</a> <a class="carousel-control right"
						href="#myCarousel" data-slide="next">&rsaquo;</a>
				</div>
				<div class="hero-unit" id="index_one_content">
					<h3>理论模型介绍：</h3>
					<p>源自经济理论，采用SPSS建模技术，融合神经网络算法，打造卓越的指数模型。</p>
					<p>
						<a class="btn btn-primary btn-large" href="<%=basePath%>/page/about.do#section-2">参看更多 »</a>
					</p>
				</div>
				<div class="hero-unit" id="index_two_content">
					<h3>多方位数据展示：</h3>
					<p>不同纬度，不同视角为你全方位展示投资者情绪指数。</p>
				</div>
				<div class="hero-unit" id="index_three_content">
					<h3>多种数据接口：</h3>
					<p>完善的第三方接口支持JAVA,Python等多种程序的调用</p>
					<p>
						<a class="btn btn-primary btn-large" href="<%=basePath%>/page/interface.do">参看更多 »</a>
					</p>
				</div>
				<div class="hero-unit" id="page_footer">
					<address>
						<br /><a href="<%=basePath%>/page/about.do#section-2" >关于投资者情绪</a><br /> 
						© 2015 - 2016 GaBeng Wang, unless otherwise noted.
						<br/><br/>
					</address>
				</div>
			</div>
		</div>
	</div>
</body>
</html>