<html>
<head>
	<script type="text/javascript" src="jquery-3.1.0.min.js"></script>
	<script>
		$(document).ready(function(){
			setInterval(function(){
				image1.src="webcam.php?t=" + Date.now();
			}, 1000);
		});
	</script>
</head>
<body>
	<img id="image1" height=100% src="webcam.php">

</body>
</html>
