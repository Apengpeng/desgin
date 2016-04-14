<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="../resource/pages/js/anychart.min.js"></script>

<title>Line Chart with Log Scale and Data Labels</title>
<style>
html, body, #container {
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>
	<div id="container"></div>
	<script type="text/javascript">
		anychart.onDocumentReady(function() {
			chart = anychart.line();
			chart.animation(true);
			chart.container('container');
			chart.title().text(
					'Line chart with Logarithmic Y-Axis and Data Labels');
			var logScale = anychart.scales.log();
			logScale.minimum(1);
			chart.yScale(logScale);
			var series = chart.line([ [ 'P1', '112.61 ' ], [ 'P2', '163.21 ' ],
					[ 'P3', '229.98 ' ], [ 'P4', '2790.54' ],
					[ 'P5', '4104.19' ], [ 'P6', '3250.67' ],
					[ 'P7', '5720.43' ], [ 'P8', '43.76' ], [ 'P9', '61.34' ],
					[ 'P10', '34.17' ], [ 'P11', '45.72' ],
					[ 'P12', '122.56 ' ], [ 'P13', '87.12' ],
					[ 'P14', '54.32' ], [ 'P15', '33.08' ] ]);
			series.labels().enabled(true).anchor('bottom').fontWeight('bold');
			chart.draw();
		});
	</script>
</body>
</html>
