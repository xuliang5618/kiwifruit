<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>

    <table>
        <thead>
        <form action="${static_abs_url}user/login" id="MsgForm" method="post">
            <div>
                用户号
                <input id='number' type="text" name="number" value=""/>
            </div>

            <div>
                密码
                <input type="password" name="password" value=""/>
            </div>
            <div>
                <input type="button" value="登录"  onclick="auth()"/>
                <input type="button" value="注册"  onclick="register();"/>
            </div>
        </form>
        </thead>
    </table>

</div>
<script language="JavaScript" type="text/javascript" src="${static_abs_url}public/js/jquery-2.1.1.min.js"></script>
<script language="JavaScript" type="text/javascript" src="${static_abs_url}public/js/ajaxupload.js"></script>
<script type="text/javascript">
    function auth() {
        var number = $("#number").val();
        var password = $("#password").val();
        $.ajax({
            url: "${static_abs_url}user/auth.xhtml",
            type: "POST",
            dataType: "json",
            async: false,
            data: {name: number, password: password},
            success: function (resp) {
                if (resp.errCode == 0) {
                    window.location.href = "${static_abs_url}demo/insert";
                }
                else {
                    var msg = "错误码: " + resp.errCode + " 错误信息: " + resp.msg;
                    alert(msg);
                }
            }
        });
    }
    function register() {
        window.location.href = "${static_abs_url}user/registerIndex.xhtml";
    }
</script>
</body>
</html>
