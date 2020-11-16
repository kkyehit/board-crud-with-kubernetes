<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.project.board.model.BoardModel" %>
<% BoardModel boardModel = (BoardModel) request.getAttribute("board"); %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><%=boardModel.getTitle()%></title>
</head>
<body>
    제목 : <input type="text" name="title" value="<%=boardModel.getTitle()%>" readonly /><br/>
    글쓴이 : <input type="text" name="title" value="<%=boardModel.getAuthor_name()%>" readonly /><br/>
    내용 : <textarea name="content" cols="40" rows="8" readonly><%=boardModel.getContent()%></textarea>
</body>
</html>