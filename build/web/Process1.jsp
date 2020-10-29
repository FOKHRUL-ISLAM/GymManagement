<%-- 
    Document   : Process1
    Created on : Jan 5, 2019, 8:08:53 AM
    Author     : Fokhrul Islam
--%>

<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${empty param.user and empty param.pass}">
            <c:redirect url="indexjsp.jsp">
                <c:param name="errM" value="user name and password is empty"></c:param>
            </c:redirect>
        </c:if>
        <c:if test="${empty param.user}">
            <c:redirect url="indexjsp.jsp">
                <c:param name="errM" value="user name is empty"></c:param>
            </c:redirect>
        </c:if>
        <c:if test="${empty param.pass}">
            <c:redirect url="indexjsp.jsp">
                <c:param name="errM" value="Password is empty"></c:param>
            </c:redirect>
        </c:if>
        <c:if test="${not empty param.user and not empty param.pass}">
            <sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/login_db" user="root" password="apcl123456"></sql:setDataSource>
            <sql:query var="squery" dataSource="${ds}">
               SELECT count(*)as aa FROM login_table where user_name="${param.user}" and password="${param.pass}"
            </sql:query>
            <c:forEach var="r" items="${squery.rows}">
                <c:choose>
                    <c:when test="${r.aa gt 0}">
                        <c:set var="userinfo" value="${param.user}" scope="session"/>
                        <c:redirect url="MainPage_1.xhtml"/>
                    </c:when>
                    <c:otherwise>
                        <c:redirect url="indexjsp.jsp">
                            <c:param name="errM" value="user name and password is wrong"></c:param>
                        </c:redirect>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </c:if>
    </body>
</html>
