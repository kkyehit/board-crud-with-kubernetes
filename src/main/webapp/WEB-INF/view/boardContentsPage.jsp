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
    <center>
        <table>
            <tr>
                <td>제목 :</td>
                <td><input type="text" size="40" name="title" value="<%=boardModel.getTitle()%>" readonly /></td>
            </tr>
            <tr>
                <td>글쓴이 :</td>
                <td><input type="text" size="40" name="title" value="<%=boardModel.getAuthor_name()%>" readonly /></td>
            </tr>
            <tr>
                <td>내용</td>
                <td><textarea name="content" cols="40" rows="8" readonly><%=boardModel.getContent()%></textarea></td>
            </tr>
        </table>
    </center>
</body>
</html>