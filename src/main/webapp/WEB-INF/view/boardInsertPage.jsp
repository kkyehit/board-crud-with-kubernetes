<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert</title>
</head>
<body>
    <center>
    <form action="/web/boards" method="post">
        <table>
            <tr>
                <td> 제목 </td>
                <td> <input type ="text" size="40" name="title"> </td>
            </tr>
            <tr>
                <td> 작성자 </td>
                <td> <input type ="text" size="40" name="author_name"> </td>
            </tr>
            <tr>
                <td> 내용 </td>
                <td> <textarea name="content" cols="40" rows="8" ></textarea> </td>
            </tr>

            <tr>
                <td> <button type = "submit">save</button> </td>
            </tr>
        </table>
    </form>
    </center>
</body>
</html>