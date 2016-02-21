<%-- 
    Document   : exito
    Created on : 11/02/2016, 01:29:04
    Author     : ang_2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-bootstrap-tags" prefix="sb" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> todo bien </h1>
          <div class="text-center">
            <s:actionerror theme="bootstrap"/>
            <s:actionmessage theme="bootstrap"/>
            <s:fielderror theme="bootstrap"/>
        </div>
    </body>
</html>
