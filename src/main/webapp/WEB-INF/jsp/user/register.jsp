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
        <div>
            用户名
            <input id="name" type="text" name="name" value=""/>
        </div>
        <div>
            邮箱
            <input id="email" type="text" name="email" value=""/>
        </div>
        <div>
            手机号
            <input id="phone" type="text" name="phone" value=""/>
        </div>
        <div>
            密码
            <input  id="password"type="text" name="password" value=""/>
        </div>
        <div>
            <input type="button" value="注册" onclick="register()"/>
        </div>
        </thead>
    </table>
</div>
<script language="JavaScript" type="text/javascript" src="${static_abs_url}public/js/jquery-2.1.1.min.js"></script>
<script language="JavaScript" type="text/javascript" src="${static_abs_url}public/js/ajaxupload.js"></script>
<script type="text/javascript">
    function register() {
        var name = $("#name").val();
        var email = $("#email").val();
        var phone = $("#phone").val();
        var password = $("#password").val();
        $.ajax({
            url: "${static_abs_url}user/register.xhtml",
            type: "POST",
            dataType: "json",
            async: false,
            data: {name: name, password: password, email: email, phone: phone},
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
</script>
</body>
</html>
