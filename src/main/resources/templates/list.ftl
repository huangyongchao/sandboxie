<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>列表</title>
</head>

<body>
<p>
    <h2>沙盒模拟API配置(路径&返回JSON数据)</h2>
    *修改服务器上的host</br>
    *vi /etc/hosts</br>
    *添加接口域名 映射到沙盒服务器</br>
</p>
<p>
    <a href="http://127.0.0.1:8090/sandbox/create"><b>新增</b></a>
</p>
<table width="800"  align="left">
    <tr align="left">
        <th scope="col">id</th>
        <th scope="col">路径</th>
        <th scope="col">样本数据</th>

        <th scope="col">操作</th>
    </tr>

<#list list as obj>
    <tr>
        <td>${obj.id}</td>
        <td>${obj.path}</td>
        <td><textarea cols="80" rows="5" >${obj.returndata}</textarea></td>

        <td><a href="http://127.0.0.1:8090/sandbox/delete/${obj.id}">删除</a></td>
    </tr>
</#list>

</table>


</body>
</html>