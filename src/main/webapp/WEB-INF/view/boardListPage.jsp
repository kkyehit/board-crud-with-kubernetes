<%@ page import="com.project.board.service.BoardService" %>
<%@ page import="com.project.board.model.BoardModel" %>
<%@ page import="com.project.board.model.response.PreviewBoardModel" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String pageNum = request.getParameter("pageNum");
    List<PreviewBoardModel> boards = (List<PreviewBoardModel>) request.getAttribute("boards");
    int currentPage = (pageNum == null ) ? 0 : Integer.parseInt(pageNum);
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
    <span>
        <a href="/web/boards?pageNum=<%=currentPage == 0? 0 : currentPage - 1%>">이전</a>
        <% if(currentPage != 0) { %>
            <a><%=currentPage - 1%></a>
        <% } %>
        <a><b><%=currentPage%></b></a>
        <a><%=currentPage + 1%></a>
        <% if(currentPage == 0) { %>
            <a><%=currentPage + 2%></a>
        <% } %>
        <a href="/web/boards?pageNum=<%=currentPage + 1%>">다음</a>
    </spane>

</body>
</html>