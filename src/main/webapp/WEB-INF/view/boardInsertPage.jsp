<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <form action="/web/boards" method="post">
        제목 <input type ="text" name="title"><br />
        내용 <input type ="text" name="content"><br />
        작성자 <input type ="text" name="author_name"><br />
        <button type = "submit">save</button>
    </form>
</body>
</html>