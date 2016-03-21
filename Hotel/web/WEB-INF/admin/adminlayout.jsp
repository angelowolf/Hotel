
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-bootstrap-tags" prefix="sb" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:importAttribute name="stylesheet" />
<tiles:importAttribute name="javascript" />
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        <s:iterator value="#attr.stylesheet" var="cadaCSS">
            <link href="<s:url value="%{cadaCSS}"/>" rel="stylesheet" type="text/css" >
        </s:iterator>
    </head>

    <body>

        <div class="container-fluid">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">Panel</a>
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Habitaciones <span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="<s:url action="mishabitaciones" namespace="/tipohabitacion"/>">Habitaciones</a></li>
                                </ul>
                            </li>
                        </ul>
                        <form class="navbar-form navbar-left" role="search">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Ej.: ID Reserva">
                            </div>
                            <button type="submit" class="btn btn-default">Buscar</button>
                        </form>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#">Link</a></li>
                        </ul>
                    </div>
                </div>
            </nav><!-- /.navbar-collapse -->
        </div>
        <div class="container">
            <div class="row">
                <tiles:insertAttribute name="body" />
            </div>
        </div>
            

        <s:iterator value="#attr.javascript" var="cadaJS">
            <script src="<s:url value="%{cadaJS}"/>" ></script>
        </s:iterator>
    </body>
</html>
