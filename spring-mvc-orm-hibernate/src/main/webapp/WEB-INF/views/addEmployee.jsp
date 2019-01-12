<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Add Employee</title>
    </head>
    <body>
        <table align="center">
            <tr>
                <td style="font-style: italic; color: red;">${caption}</td>
            </tr>
        </table>
        <form:form id="addEmployee" modelAttribute="addEmployee" action="addEmployee" method="post">
            <table align="center">
                <tr>
                    <td><form:label path="firstName">First Name: </form:label></td>
                    <td><form:input path="firstName" name="firstName" id="firstName" /></td>
                </tr>
                <tr>
                    <td><form:label path="middleName">Middle Name: </form:label></td>
                    <td><form:input path="middleName" name="middleName" id="middleName" /> </td>
                </tr>
                <tr>
                    <td><form:label path="lastName">Last Name: </form:label></td>
                    <td><form:input path="lastName" name="lastName" id="lastName" /></td>
                </tr>
                <tr>
                    <td><form:label path="salary">Salary: </form:label></td>
                    <td><form:input path="salary" name="salary" id="salary" /></td>
                </tr>
                <tr>
                    <td><form:label path="ssn">SSN: </form:label></td>
                    <td><form:input path="ssn" name="ssn" id="ssn" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td align="left">
                        <form:button id="save" name="save">Save</form:button>
                    </td>
                </tr>
                <tr></tr>
                <tr>
                    <td></td>
                    <td><a href="/home">Home</a>
                    </td>
                </tr>
            </table>
        </form:form>

    </body>
</html>