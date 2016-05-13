$(function() {
	var mood = $("input[name='mood']").val().split(",");
	var date = $("input[name='date']").val().split(",");
	
	var amood = new Array(mood.length)
	for(var i=0;i<mood.length;i++){
		amood[i] = parseFloat(mood[i]);
	}
	
	$('#moodcontainer')
			.highcharts(
					{
						chart : {
							zoomType : 'x',
							spacingRight : 20
						},
						title : {
							text : '投资者情绪指数展示'
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
								text : '数值'
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
							name : '情绪值',
							data : amood 
						}]
					});
});