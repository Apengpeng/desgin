$(function() {
	var reading = $("input[name='reading']").val().split(",");
	var comments = $("input[name='comments']").val().split(",");
	var create = $("input[name='create']").val().split(",");
	var date = $("input[name='date']").val().split(",");
	
	var areading = new Array(reading.length);
	var acomments = new Array(comments.length);
	var acreate = new Array(create.length)
	for(var i=0;i<reading.length;i++){
		areading[i]=parseInt(reading[i]);
		acomments[i] = parseInt(comments[i]);
		acreate[i] = parseInt(create[i]);
	}
	
	$('#daymoodcontainer')
			.highcharts(
					{
						chart : {
							zoomType : 'x',
							spacingRight : 20
						},
						title : {
							text : '每日论坛信息统计展示'
						},
						xAxis : {
							type : 'datetime',
							title : {
								text : "时间"
							},
							categories : date
						},
						yAxis : {
							title : {
								text : '数量'
							}
						},
						tooltip : {
							shared : true
						},
						legend : {
							enabled : false
						},
						plotOptions : {
							area : {
								fillColor : {
									linearGradient : {
										x1 : 0,
										y1 : 0,
										x2 : 0,
										y2 : 1
									},
									stops : [
											[
													0,
													Highcharts.getOptions().colors[0] ],
											[
													1,
													Highcharts
															.Color(
																	Highcharts
																			.getOptions().colors[0])
															.setOpacity(0).get(
																	'rgba') ] ]
								},
								lineWidth : 1,
								marker : {
									enabled : false
								},
								shadow : false,
								states : {
									hover : {
										lineWidth : 1
									}
								},
								threshold : null
							}
						},

						series : [ {
							type : 'area',
							name : '评论量',
							data : acomments 
						}, {
							type : 'area',
							name : '阅读量',
							data : areading
						}, {
							type : 'area',
							name : '发帖量',
							data : acreate 
						} ]
					});
});