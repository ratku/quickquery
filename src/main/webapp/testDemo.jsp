<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>api test</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="ajax方式">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript">
        var resdata; 
        function access() {
        	var url1 = $("input[name=url1]").val();
        	var parameter = $("input[name=parameter]").val();
        	$.ajax({
            	url:url1+parameter,//后台提供的接口  
                type: "post",   //请求方式是post  
                data:{
                	url:url1
                },  
                dataType: "json", //数据类型是json型
                success: function (data) {
                   // console.log(data.data);//打印服务端返回的数据(调试用)
                    resdata = data.data;
                    console.log(resdata);
                    var str = JSON.stringify(data);
                    document.getElementById("return").innerHTML=str;
                    ;
                },
                error : function() {
                    alert("error");
                }
            });
        }
        function access2() {
        	$.ajax({
            	url:"http://192.168.0.103:8000/sell/buyer/product/private"+"?datas="+resdata,//后台提供的接口  
                type: "post",   //请求方式是post  
                data:{
                },  
                dataType: "json", //数据类型是json型
                success: function (data) {
                    var str = JSON.stringify(data);
                    document.getElementById("data").innerHTML=str;
                    ;
                },
                error : function() {
                    alert("error");
                }
            });
        }
    </script>
</head>
<body>
<div id="form-div">
    <form id="form1" onsubmit="return false" action="##" method="post">
        <p>url:<input name="url1" type="text" id="urlName" tabindex="1" size="55" value=""/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="Go" onclick="access()"></p>
        <p>parameter : <input name="parameter" type="text" id="parameter" tabindex="2" size="16" value=""/></p>
        <div id="return" >return : </div>
        <p><input type="button" value="Decryption" onclick="access2()"></p>
        <div id="data">data  : </div>
    </form>
</div>
</body>
</html>