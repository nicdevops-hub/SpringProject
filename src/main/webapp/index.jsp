<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NICWS LIVE SERVER RESPONSE</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
        $.ajax({
            url: "http://localhost:8080/ifhms_hrmsws/web_service_response",
            dataType: 'html',
            success: function (data) {
                $("#ws_list").html(data);
            }});
});
</script>
</head>
<body>
<div id="ws_list"></div>
</body>  
</html>