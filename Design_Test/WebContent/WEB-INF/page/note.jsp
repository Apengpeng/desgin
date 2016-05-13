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
<title>投资者情绪-论坛信息</title>
<link type="image/x-icon" rel="shortcut icon" href="../logo.ico" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<script src="<%=basePath%>/resource/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=basePath%>/resource/pages/js/jquery-1.12.3.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/resource/datapicker/js/bootstrap-datetimepicker.js"
	charset="UTF-8"></script>
<script type="text/javascript"
	src="<%=basePath%>/resource/datapicker/js/locales/bootstrap-datetimepicker.zh-CN.js"
	charset="UTF-8"></script>
<script src="<%=basePath%>/resource/lighter/js/exporting.js"
	type="text/javascript"></script>
<link
	href="<%=basePath%>/resource/datapicker/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" media="screen">
<link href="<%=basePath%>/resource/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" media="screen">

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

<link rel="stylesheet"
	href="<%=basePath%>/resource/bootstrap/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet"
	href="<%=basePath%>/resource/bootstrap/css/datepicker.css" />
<link rel="stylesheet" href="<%=basePath%>/resource/pages/css/note.css" />
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
								class="icon-bar"></span></a> <a href="<%=basePath%>" class="brand">投资者情绪</a>
							<div class="nav-collapse collapse navbar-responsive-collapse">
								<ul class="nav">
									<li><a href="<%=basePath%>">首页</a></li>
									<li><a href="<%=basePath%>/page/mood.do">指数信息</a></li>
									<li><a href="<%=basePath%>/page/daymood.do">每日信息</a></li>
									<li class="active"><a href="<%=basePath%>/page/note.do">论坛信息</a></li>
									<li><a href="<%=basePath%>/page/interface.do">程序接口</a></li>
									<li><a href="<%=basePath%>/page/about.do">关于</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="page-header">
					<h3>每日排名</h3>
				</div>
				<table class="table table-hover table-striped" id="readingtable_one">
					<caption>
						<strong><big>阅读量排名</big></strong>
					</caption>
					<thead>
						<tr>
							<th>标题</th>
							<th>阅读量</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${reading}" var="rnote">
							<tr>
								<td>${rnote.title}</td>
								<td>${rnote.reading}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<table class="table table-hover table-striped" id="readingtable_two">
					<caption>
						<strong><big>评论量排名</big></strong>
					</caption>
					<thead>
						<tr>
							<th>标题</th>
							<th style="min-width: 3em;">数量</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${comments}" var="cnote">
							<tr>
								<td>${cnote.title}</td>
								<td>${cnote.comments}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<table class="table table-hover table-striped"
					id="readingtable_three">
					<caption>
						<strong><big>发帖数排名</big></strong>
					</caption>
					<thead>
						<tr>
							<th>网友名称</th>
							<th>发帖数量</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${create}" var="note">
							<tr>
								<td>${note.author}</td>
								<td>${note.count}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</div>
		</div>
		

		<div class="row">
			<div class="span12">
				<hr>
				<div class="page-header">
					<h3>帖子信息</h3>
				</div>
				<form class="form-inline" role="form"
					action="<%=basePath%>/page/note.do">
					<div class="form-group" align="left">
						<div class="input-append date form_datetime">
							<label class="sr-only" for="name">时间：</label> <input
								type="text" class="form-control" id="time" name="time" readonly
								size="16" value="${time}"> <span class="add-on"><i
								class="icon-th"></i></span>
						</div>
						<button type="submit" class="btn btn-default">查询</button>
					</div>
				</form>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>标题</th>
							<th>情绪值</th>
							<th>阅读量</th>
							<th>评论量</th>
							<th>链接</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${note != null}">
							<c:forEach items="${note}" var="notevo">
								<tr>
									<td>${notevo.id}</td>
									<td>${notevo.title}</td>
									<td>${notevo.moodValue}</td>
									<td>${notevo.reading}</td>
									<td>${notevo.comments}</td>
									<td>${notevo.link}</td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${note.size()==0}">
							<tr>
								<td colspan="6"><center>暂无数据</center></td>
							</tr>
						</c:if>
					</tbody>
				</table>
				<div class="button-group" id="buttongroup">
					<c:if test="${now_page-1>0}">
						<a
							href="<%=basePath%>/page/note.do?time=${time}&page=${now_page-1}"><button
								type="button" class="btn btn-default" data-toggle="button">
								上一页</button></a>
					</c:if>
					<c:if test="${page+1<=totle_page}">
						<a
							href="<%=basePath%>/page/note.do?time=${time}&page=${now_page+1}"><button
								type="button" class="btn btn-default" data-toggle="button">
								下一页</button> </a>
					</c:if>
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