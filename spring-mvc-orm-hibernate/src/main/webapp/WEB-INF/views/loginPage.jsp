<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="false"%>

<html>

    <head>
        <title>Spring MVC</title>
    </head>

    <body>
        <h1>${message}</h1>
        <p>Today's Date: ${localDate}</p>
        <p>This Spring Web MVC is built using java annotations - no Spring Context xml or Web.xml</p>
        <p><a href="/test/addEmployee">Add Employee</a></p>

        <form:form id="login" modelAttribute="login" action="login" method="post">
            <table align="center">
                <tr>
                    <td><form:label path="userName">User Name: </form:label></td>
                    <td><form:input path="userName" name="userName" id="userName" /></td>
                </tr>
                <tr>
                    <td><form:label path="password">Password: </form:label></td>
                    <td><form:input path="password" name="password" id="password" /> </td>
                </tr>
                <tr>
                    <td></td>
                    <td align="left">
                        <form:button id="login" name="login">Login</form:button>
                    </td>
                </tr>
                <tr></tr>
            </table>
        </form:form>
    </body>

</html>
