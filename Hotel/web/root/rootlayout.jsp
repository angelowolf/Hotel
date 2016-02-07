
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-bootstrap-tags" prefix="sb" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title><tiles:insertAttribute name="title" ignore="true" /></title>

        <!-- Bootstrap Core CSS -->
        <link href="/../bower_components/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
        
        <link href="/../css/bootstrap-multiselect.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="/../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="/../css/sb-admin-2.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="/../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link href="/../css/root.css" rel="stylesheet">
    </head>

    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Gestión</a>
                </div>
                <!-- /.navbar-header -->

                <ul class="nav navbar-top-links navbar-right">

                    <!-- /.dropdown -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#"><i class="fa fa-user fa-fw"></i> Perfil</a>
                            </li>
                            <li><a href="#"><i class="fa fa-gear fa-fw"></i> Configuración</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="<s:url action="logout" namespace="/"/>"><i class="fa fa-sign-out fa-fw"></i> Cerrar sesión</a>
                            </li>
                        </ul>
                        <!-- /.dropdown-user -->
                    </li>
                    <!-- /.dropdown -->
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            <li>
                                <a href="#"><i class="fa fa-transgender fa-fw"></i> Sexo<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li><a href="<s:url action="listar" namespace="/root/sexo"/>"><i class="glyphicon glyphicon-list fa-fw "></i> Todos</a></li>
                                    <li><a href="<s:url action="nuevo" namespace="/root/sexo"/>"><i class="glyphicon glyphicon-plus fa-fw "></i> Nuevo</a></li>
                                </ul>                              
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-cube fa-fw"></i> Modulo<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li><a href="<s:url action="listar" namespace="/root/modulo"/>"><i class="glyphicon glyphicon-list fa-fw "></i> Todos</a></li>
                                    <li><a href="<s:url action="nuevo" namespace="/root/modulo"/>"><i class="glyphicon glyphicon-plus fa-fw "></i> Nuevo</a></li>
                                </ul>        
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-cubes fa-fw"></i> Plan<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li><a href="<s:url action="listar" namespace="/root/plan"/>"><i class="glyphicon glyphicon-list fa-fw "></i> Todos</a></li>
                                    <li><a href="<s:url action="nuevo" namespace="/root/plan"/>"><i class="glyphicon glyphicon-plus fa-fw "></i> Nuevo</a></li>
                                </ul>        
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-credit-card fa-fw"></i> Tipo Documento<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li><a href="<s:url action="listar" namespace="/root/tipodocumento"/>"><i class="glyphicon glyphicon-list fa-fw "></i> Todos</a></li>
                                    <li><a href="<s:url action="nuevo" namespace="/root/tipodocumento"/>"><i class="glyphicon glyphicon-plus fa-fw "></i> Nuevo</a></li>
                                </ul>                              
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-bank fa-fw"></i> Tipo Pago<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li><a href="<s:url action="listar" namespace="/root/tipopago"/>"><i class="glyphicon glyphicon-list fa-fw "></i> Todos</a></li>
                                    <li><a href="<s:url action="nuevo" namespace="/root/tipopago"/>"><i class="glyphicon glyphicon-plus fa-fw "></i> Nuevo</a></li>
                                </ul>                              
                            </li>
                        </ul>
                    </div>
                    <!-- /.sidebar-collapse -->
                </div>
                <!-- /.navbar-static-side -->
            </nav>

            <!-- Page Content -->
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="text-center">
                                <s:actionerror theme="bootstrap"/>
                                <s:actionmessage theme="bootstrap"/>
                                <s:fielderror theme="bootstrap"/>
                            </div>
                            <tiles:insertAttribute name="body" />
                        </div>
                        <!-- /.col-lg-12 -->
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->

            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
        
        
        <!-- Multiselect -->        
        <script src="/../js/bootstrap-multiselect.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="/../js/bootstrap.min.js"></script>

        <!-- Metis Menu Plugin JavaScript -->
        <script src="/../bower_components/metisMenu/dist/metisMenu.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="/../js/sb-admin-2.js"></script>

    </body>

</html>
