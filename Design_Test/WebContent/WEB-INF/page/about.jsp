<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<title>投资者情绪-关于</title>
<link type="image/x-icon" rel="shortcut icon" href="../logo.ico" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="<%=basePath%>/resource/pages/js/jquery-1.12.3.min.js"></script>
<script src="<%=basePath%>/resource/bootstrap/js/bootstrap.min.js"></script>
<script
	src="<%=basePath%>/resource/bootstrap/js/bootstrap-datepicker.js"></script>

<link rel="stylesheet" href="<%=basePath%>/resource/pages/css/about.css" />
<link rel="stylesheet"
	href="<%=basePath%>/resource/bootstrap/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=basePath%>/resource/bootstrap/css/datepicker.css" />
<link rel="stylesheet"
	href="<%=basePath%>/resource/pages/css/commen.css" />
<script type="text/javascript">
	$(document).ready(function() {
		$("#myNav").affix({
			offset : {
				top : 125
			}
		});
	});
</script>
</head>
<body data-spy="scroll" data-target="#myScrollspy">
	<div class="container">
		<div class="row">
			<div class="span12">
				<div class="navbar">
					<div class="navbar-inner">
						<div class="container-fluid">
							<a data-target=".navbar-responsive-collapse"
								data-toggle="collapse" class="btn btn-navbar"><span
								class="icon-bar"></span><span class="icon-bar"></span><span
								class="icon-bar"></span></a> <a href="<%=basePath%>" class="brand">投资者情绪</a>
							<div class="nav-collapse collapse navbar-responsive-collapse">
								<ul class="nav">
									<li><a href="<%=basePath%>">首页</a></li>
									<li><a href="<%=basePath%>/page/mood.do">指数信息</a></li>
									<li><a href="<%=basePath%>/page/daymood.do">每日信息</a></li>
									<li><a href="<%=basePath%>/page/note.do">论坛信息</a></li>
									<li><a href="<%=basePath%>/page/interface.do">程序接口</a></li>
									<li class="active"><a href="<%=basePath%>/page/about.do">关于</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="page-header">
					<h3>关于</h3>
				</div>
				<div class="col-xs-3" id="myScrollspy">
					<ul class="nav nav-tabs nav-stacked" id="myNav">
						<li><a href="#section-1">网站介绍</a></li>
						<li><a href="#section-2">模型介绍</a></li>
						<li><a href="#section-3">网站源码</a></li>
					</ul>
				</div>
				<div class="col-xs-5" id="about_content">
					<h2 id="section-1">网站介绍</h2>
					<hr>
					<p style="text-indent: 2em;">投资者情绪网站是一个专门展示投资者情绪数据的网站。网站以学长的投资者理论模型为基础，从网络实时采集大量的数据
					，结合股市信息，使用SPSS建模，使用Python等工具语言，构建一个新的指数模型。通过投资者情绪网站，可以获取到详尽
					的数据资料图表，也通过我们对外提供的第三方接口来调取我们的数据，帮助您完成相应的数据分析工作。通过投资者情绪网站，
					可以动态的反映市场上投资者的情绪变化，对实际的股市投资活动有一定的帮助。</p>
					<hr>
					<h2 id="section-2">模型介绍</h2>
					<hr>
					<p> 输入变量：</p>
<p style="text-indent: 2em;">1、将t日的“情绪的极性指标M_t”、“情绪的热度指标H_t”和“情绪的集中度指标A_t”作为输入变量。</p>
<p style="text-indent: 2em;">2、同时引入两个交叉项。</p>
<p style="text-indent: 2em;">我们考虑到，投资者情绪依赖于论坛发帖这一行为载体进行传播，发帖是情绪传递的一种路径，情绪极性指标与发帖量之间会有一定的关联，所以我们再引入情绪极性与发帖量的交叉项“X^1”作为输入变量之一；
另外，帖子的评论量与阅读量之间也有一定的关系，评论行为绝大多数是建立在阅读行为之上的，通常只有在阅读过帖子之后产生了强烈情感之后才会留言评论，所以我们再引入了阅读量与评论量的交叉项“X^2”作为输入变量之一。
</p>
<p>输出变量：</p>
<p style="text-indent: 2em;">我们采用t日的上证指数“收益率”为输出变量,利用神经网络的方式进行模型构建：</p>


					
					<hr>
					<h2 id="section-3">网站源码</h2>
					<hr>
					<p style="text-indent: 2em;">投资者情绪指数构建的数据抓取和处理代码以及网站的代码，已经全部发布在了GitHub.欢迎大家扔砖。</p>
					<div>
						<a href="https://github.com/Apengpeng/desgin"><button type="button" class="btn btn-primary">Github</button></a>
					</div>
					<hr>
				</div>
			</div>
		</div>
		<div class="hero-unit" id="page_footer">
			<address>
				<br /> <a href="<%=basePath%>/page/about.do#section-2">关于投资者情绪</a><br />
				© 2015 - 2016 GaBeng Wang, unless otherwise noted. <br /> <br />
			</address>
		</div>

	</div>

</body>
</html>