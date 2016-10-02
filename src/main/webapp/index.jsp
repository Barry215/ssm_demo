<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>首页</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<form action="/login" method="post">
    <table>
        <tr>
            <td>用户名: </td>
            <td><input type="text" name="username"/></td>
        </tr>

        <tr>
            <td>密码: </td>
            <td><input type="password" name="password"/></td>
        </tr>

        <tr>
            <td colspan="2"><input type = "submit" value = "登陆"/></td>
        </tr>
    </table>
</form>

<form action="/signUp" method="post">
    <table>
        <tr>
            <td>用户名: </td>
            <td><input type="text" name="username"/></td>
        </tr>

        <tr>
            <td>密码: </td>
            <td><input type="password" name="password"/></td>
        </tr>

        <tr>
            <td>手机号: </td>
            <td><input type="text" name="phone"/></td>
        </tr>

        <tr>
            <td colspan="2"><input type = "submit" value = "注册"/></td>
        </tr>
    </table>
</form>

</body>
</html>
