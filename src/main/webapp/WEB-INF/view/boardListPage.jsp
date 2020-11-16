<%@ page import="com.project.board.service.BoardService" %>
<%@ page import="com.project.board.model.BoardModel" %>
<%@ page import="com.project.board.model.response.PreviewBoardModel" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    List<PreviewBoardModel> boards = (List<PreviewBoardModel>) request.getAttribute("boards");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Author</th>
            <th>CreatedAt</th>
        </tr>
        <%
            for(PreviewBoardModel board: boards){
        %>
            <tr>
                <td><%=board.getTitle()%></td>
                <td><%=board.getAuthor_name()%></td>
                <td><%=board.getCreatedAt()%></td>
            </tr>
        <%
            }
        %>
    </table>

</body>
</html>