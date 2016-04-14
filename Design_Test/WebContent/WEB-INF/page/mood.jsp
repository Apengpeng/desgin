<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>投资者情绪-每日信息</title>
<link type="image/x-icon" rel="shortcut icon" href="../logo.ico" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- base js -->
<script src="<%=basePath%>/resource/pages/js/jquery-1.12.3.min.js"></script>
<script src="<%=basePath%>/resource/bootstrap/js/bootstrap.min.js"></script>
<!-- chart js -->
<script src="<%=basePath%>/resource/pages/js/highcharts.js"></script>
<script src="<%=basePath%>/resource/pages/js/highcharts-more.js"></script>
<script src="<%=basePath%>/resource/lighter/js/exporting.js"
	type="text/javascript"></script>
<script src="<%=basePath%>/resource/pages/js/moodchart.js"></script>

<!-- time js -->
<script type="text/javascript"
	src="<%=basePath%>/resource/datapicker/js/bootstrap-datetimepicker.js"
	charset="UTF-8"></script>
<script type="text/javascript"
	src="<%=basePath%>/resource/datapicker/js/locales/bootstrap-datetimepicker.zh-CN.js"
	charset="UTF-8"></script>

<link rel="stylesheet"
	href="<%=basePath%>/resource/pages/css/commen.css" />

<link
	href="<%=basePath%>/resource/datapicker/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" media="screen">
<link rel="stylesheet"
	href="<%=basePath%>/resource/bootstrap/css/bootstrap.min.css"
	type="text/css" />

<link rel="stylesheet"
	href="<%=basePath%>/resource/pages/css/daymood.css" />
<script type="text/javascript">
	$(function() {
		$(".form_datetime").datetimepicker({
			language : 'zh-CN',
			pickTime : false,
			todayBtn : true,
			autoclose : true,
			minView : '2',
			forceParse : false,
			format : "yyyy-mm-dd"
		});
	});
</script>
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
								class="icon-bar"></span></a> <a href="<%=basePath%>" class="brand">投资者情绪</a>
							<div class="nav-collapse collapse navbar-responsive-collapse">
								<ul class="nav">
									<li><a href="<%=basePath%>">首页</a></li>
									<li class="active"><a href="<%=basePath%>/page/mood.do">指数信息</a></li>
									<li ><a href="<%=basePath%>/page/daymood.do">每日信息</a></li>
									<li><a href="<%=basePath%>/page/note.do">论坛信息</a></li>
									<li><a href="<%=basePath%>/page/interface.do">程序接口</a></li>
									<li><a href="<%=basePath%>/page/about.do">关于</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="page-header">
					<h3>今日指数</h3>
				</div>

				<div class="list-group">
					<table class="mood_table">
						<tr>
							<td width="20%"><span class="list-group-item">情绪指数：${daymood.moodValue}</span></td>
							<td width="20%"><span class="list-group-item">情绪指数变化率：${daymood.moodValueChange }</span></td>
						</tr>
						<tr>
							<td width="20%"><span class="list-group-item">上证综合指数：${daymood.shcloseValue}</span></td>
							<td width="20%"><span class="list-group-item">上证综合指数变化率：${daymood.shcloseValueChange }</span></td>
						</tr>
					</table>
				</div>
				<hr>
				<div class="page-header">
					<h3>趋势信息</h3>
				</div>
				<form class="form-inline" role="form"
					action="<%=basePath%>/page/mood.do">
					<div class="form-group" align="left">
						<div class="input-append date form_datetime">
							<label class="sr-only" for="name">开始时间：</label> <input
								type="text" class="form-control" id="begintime" readonly
								name="begintime" value="${begintime}" size="16"> <span
								class="add-on"><i class="icon-th"></i></span>
						</div>

						<div class="input-append date form_datetime">
							<label class="sr-only" for="name">结束时间：</label> <input
								type="text" class="form-control" id="endtime" value="${endtime}"
								name="endtime" readonly size="16"> <span class="add-on"><i
								class="icon-th"></i></span>
						</div>
						<button type="submit" class="btn btn-default">查询</button>
					</div>
				</form>
				<div id="moodcontainer" style="min-width: 800px; height: 400px;">
					<input type="hidden" value="${mood}" id="mood" name="mood">
					<input type="hidden" value="${date}" id="date" name="date">
				</div>
				<hr>
				<div class="hero-unit" id="page_footer">
					<address>
						<br /> <a href="<%=basePath%>/page/about.do#section-2">关于投资者情绪</a><br />
						© 2015 - 2016 GaBeng Wang, unless otherwise noted. <br /> <br />
					</address>
				</div>
			</div>
		</div>
	</div>
</body>
</html>