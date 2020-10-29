<%-- 
    Document   : indexjsp
    Created on : Jan 5, 2019, 6:38:15 AM
    Author     : Fokhrul Islam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <style>
            tr,th{
                color: black;
                font-size: 18pt;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6" style="background-color: #ff99ff; align-content: center">
                    <center>
                        <form action="Process1.jsp">
                            
                            <span style="font-size: 34pt;color: blue">Login to Start</span>
                           
                            <table>
                                <tr>
                                    <th>User Name</th>
                                    <th>:</th>
                                    <th>
                                        <input type="text" name="user">
                                    </th>
                                </tr>
                                <tr>
                                    <th>Password</th>
                                    <th>:</th>
                                    <th>
                                        <input type="password" name="pass">
                                    </th>
                                </tr>                
                            </table>
                           
                                <input type="submit" value="Login" style="color: black;background-color: #66ff66;height: 40px; width: 120px; border-radius: 40px;font-size: 16pt;">
                            <c:if test="${not empty param.errM}">                
                                <c:out value="${param.errM}"></c:out>  
                            </c:if>
                        </form>
                    </center>
                </div>
            </div>
        </div>

    </body>
</html>
