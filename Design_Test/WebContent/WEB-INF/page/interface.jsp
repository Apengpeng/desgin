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
<title>投资者情绪-接口</title>
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
<script type="text/javascript"
	src="<%=basePath%>/resource/pages/js/interface.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/resource/lighter/scripts/shCore.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/resource/lighter/scripts/shBrushJScript.js"></script>
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>/resource/lighter/styles/shCoreDefault.css" />
<script type="text/javascript">
	SyntaxHighlighter.all();
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
									<li><a href="<%=basePath%>/page/mood.do">指数信息</a></li>
									<li><a href="<%=basePath%>/page/daymood.do">每日信息</a></li>
									<li><a href="<%=basePath%>/page/note.do">论坛信息</a></li>
									<li class="active"><a
										href="<%=basePath%>/page/interface.do">程序接口</a></li>
									<li><a href="<%=basePath%>/page/about.do">关于</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<div>
					<div class="page-header">
						<h3>接口介绍</h3>
					</div>
					<p style="text-indent: 2em">投资者情绪指数网站为各位网友提供了方便，简单，多样的程序接口，以供大家调用获取不同纬度的指数和相关信息。对外我们提供的JAVA和Python的调用示例，如下方所示。
						此外，我们还提供了接口文档供大家参考和查阅，里面详细记录函数API，可以满足大家的开发需求。</p>
				</div>
				<hr>
				<div>
					<div class="page-header">
						<h3>接口调用示例</h3>
					</div>
					<ul id="myTab" class="nav nav-tabs">
						<li class="active"><a href="#java" data-toggle="tab">
								Java</a></li>
						<li><a href="#Python" data-toggle="tab">Python</a></li>

					</ul>
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane fade in active" id="java">
							<pre class="brush: js;">
package com.design.connect.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class InterfaceTest {

	public static void main(String[] args) throws HttpException, IOException {
		// 构造请求
		HttpClient httpClient = new HttpClient();
		PostMethod method = new PostMethod(
				"http://localhost:8080/Design_Test/interface/mood/daymood.do");
		method.addParameter("date", "2016-02-24");
		HttpMethodParams param = method.getParams();
		param.setContentCharset("utf-8");
		method.setParams(param);
		// 发送请求,获取返回流
		httpClient.executeMethod(method);
		InputStream stream = method.getResponseBodyAsStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(stream,
				"UTF-8"));
		StringBuffer buf = new StringBuffer();
		String line;
		while (null != (line = br.readLine())) {
			buf.append(line).append("\n");
		}
		System.out.println(buf.toString());
		// 释放连接
		method.releaseConnection();
	}
}

</pre>
						</div>
						<div class="tab-pane fade" id="Python">
							<pre class="brush: js;">
#!/usr/bin/python
# -*- coding: utf-8 -*-
import urllib
import urllib2
url = 'http://localhost:8080/design_test/interface/mood/daymood.do'
values = {'date':'2016-02-16'}
data = urllib.urlencode(values)
print data
req = urllib2.Request(url, data)
response = urllib2.urlopen(req)
print(response)
</pre>
						</div>
					</div>
				</div>
				<hr>
				<div>
					<div class="page-header">
						<h3>接口说明文档</h3>
					</div>
					<a href="<%=basePath%>/resource/file/interface.pdf"><button type="button" class="btn btn-primary">点击下载</button></a>
				</div>
				<hr>
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