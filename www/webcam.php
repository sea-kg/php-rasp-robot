<?php

	header("Expires: 0");
	header("Last-Modified: ".gmdate("D, d M Y H:i:s")." GMT");
	header('Cache-Control: no-store, no-cache, must-revalidate'); 
	header('Cache-Control: post-check=0, pre-check=0', FALSE); 
	header('Pragma: no-cache');  
	header('Content-Type: image/jpeg');
	// system("streamer -q -c `/dev/video0` -f jpeg -o /dev/stdout");
	$cmd = "streamer -q -c /dev/`ls /dev/ | grep video` -f jpeg -o /dev/stdout";
	system($cmd);
	// error_log($cmd);
