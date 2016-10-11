<!DOCTYPE html>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
           prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>


<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">

    <title><decorator:title/></title>

    <!-- Bootstrap core CSS -->
    <link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/jumboron.css" rel="stylesheet">

    <script src="webjars/jquery/1.11.1/jquery.js"></script>
    <script src="webjars/jquery-ui/1.11.3/jquery-ui.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/i18n/jquery-ui-i18n.min.js"></script>
    <script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link href="webjars/jquery-ui/1.11.3/jquery-ui.css" rel="stylesheet">
    <link href="webjars/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet"/>
    <script src="webjars/bootstrap-growl/2.0.1/bootstrap-growl.min.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>


    <![endif]-->
</head>

<body>

<!--
<nav class="navbar navbar-inverse">

</nav>-->

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div>
        <div class="container-fluid">
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#" class="navbar-brand">Sniffer</a></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">All actions
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="admin">Admin view</a></li>
                            <li><a href="logout.jsp">Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron">
    <div class="container">
        <decorator:body/>


    </div>
</div>

<div class="container">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-4">
            Сниффер для просмотра угнанных при помощи XSS-атаки куки.
        </div>
    </div>

    <hr>

    <footer>
        <p>&copy;Сниффер 2016/p>
        <script>
            $(function () {
                //setting up Datapicker internationalization + defaults
                $.datepicker.setDefaults(
                        $.extend($.datepicker.regional["${language}"]));
                $(".datepicker").datepicker({
                    minDate: null,
                    maxDate: null, dateFormat: 'yy-mm-dd'
                }).val();

            });


            $(document).ready(function () {
                $("form").submit(function () {
                    var btn = $(this).find("input[type=submit]:focus");
                    $(btn).attr("disabled", "true");
                });
            });
            // disabling form's Submit buttons after the submit
        </script>
    </footer>
</div>
<!-- /container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
</body>
</html>

