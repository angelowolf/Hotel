<%-- 
    Document   : index
    Created on : 31/01/2016, 13:29:32
    Author     : flore
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-bootstrap-tags" prefix="sb" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <h1>Hello World!</h1>
        <s:actionerror theme="bootstrap" />
                <s:actionmessage theme="bootstrap" />
    </body>
</html>
