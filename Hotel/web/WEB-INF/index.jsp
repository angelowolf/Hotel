<%-- 
    Document   : index
    Created on : 31/01/2016, 02:24:53
    Author     : flore
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="/struts-bootstrap-tags" prefix="sb" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Iniciar Sesión</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet' type='text/css'>
        <style>
            @import url(https://fonts.googleapis.com/css?family=Slabo+27px&subset=latin,latin-ext);

            html, body {
                background-image: -webkit-radial-gradient(closest-corner, rgba(16, 47, 70, 0) 60%, rgba(16, 47, 70, 0.26)), -webkit-linear-gradient(108deg, #26d0ce, #1a2980 90%);
                background-image: -moz-radial-gradient(closest-corner, rgba(16, 47, 70, 0) 60%, rgba(16, 47, 70, 0.26)), -moz-linear-gradient(108deg, #26d0ce, #1a2980 90%);
                background-image: -ms-radial-gradient(closest-corner, rgba(16, 47, 70, 0) 60%, rgba(16, 47, 70, 0.26)), -ms-linear-gradient(108deg, #26d0ce, #1a2980 90%);
                font-family: 'Raleway', sans-serif;
                font-weight: 300;
                height: 100%; /*Allow spacing based on window height*/
                margin: 0;
                min-height: 240px;
            }

            /*The form part*/
            .content {
                /*A box that the form resides in - centered vertically and horizontally based on the window. The max-width and % width combo allow it to resize for small devices*/  
                background: #FFF;
                border-radius: 8px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                display: block;
                left: 50%;
                max-width: 360px;
                position: absolute;
                top: 50%;
                -ms-transform: translate(-50%, -50%);
                -webkit-transform: translate(-50%, -50%);
                transform: translate(-50%, -50%);
                width: 90%;
                z-index: 2;
            }

            form {
                display: block;
                margin: auto;
                padding: 27px 0;
                width: 85%;
            }

            /*Text-inputs*/
            .mat-in {
                position: relative;
                margin-bottom: 32px;
            }

            input {
                border: none;
                border-bottom: 1px solid #9E9E9E;
                display: block;
                font-size: 16px;
                padding: 8px 0px;
                -webkit-transition: 0.2s border-bottom;
                transition: 0.2s border-bottom;
                width: 100%;
            }

            input:focus, input:invalid {
                box-shadow: none;
                outline: none;
            }

            input:focus {
                border-bottom: 1px solid #2196f3;
            }

            /*Labels*/
            label {
                color: #9E9E9E;
                font-size: 16px;
                pointer-events: none;
                position: absolute;
                top: 10px;
                -webkit-transition: 0.2s ease all;
                transition: 0.2s ease all;
            }

            input:focus ~ label, input:valid ~ label {
                color: #2196f3;
                font-size: 12px;
                top: -16px;
            }

            /*Bar that appears when an input is selected*/
            .bar:before, .bar:after {
                background: #2196f3;
                bottom: 1px;
                content: '';
                height: 2px;
                position: absolute;
                -webkit-transition: 0.2s ease all;
                transition: 0.2s ease all;
                width: 0;
            }

            .bar:before {
                left: 50%;
            }

            .bar:after {
                right: 50%;
            }

            input:focus ~ .bar:before, input:focus ~ .bar:after {
                width: 50%;
            }

            /*Submit Button*/
            input[type="submit"] {
                background: #2196f3;
                border: none;
                border-radius: 2px;
                color: #FFF;
                cursor: pointer;
                font-size: 16px;
                opacity: 0.999;
                padding: 8px 0;
                position: relative;
                -webkit-transition: 0.2s ease background;
                transition: .2s ease background;
                width: 100%;
            }

            input[type="submit"]:hover {
                background: #1976d2;
            }

            input[type="submit"]:before, input[type="submit"]:after {
                border-radius: 2px;
                content: '';
                height: 0;
                left: 0;
                opacity: 0;
                position: absolute;
                width: 100%;
                -webkit-transition: 0.2s ease all;
                transition: .2s ease all;
                z-index: -1;
            }

            input[type="submit"]:before {
                top: 50%;
            }

            input[type="submit"]:after {
                bottom: 50%;
            }

            input[type="submit"]:active:before, input[type="submit"]:active:after {
                background: #0d47a1;
                height: 50%;
                opacity: 1;
            }

            /*Error Messages*/
            .alert > p, .alert > ul {
                margin-bottom: 0;
            }
            .alert > p {
                line-height: 56px;
            }
            .alert {
                border: none;
                box-sizing: border-box;
                color: #fff;
            }
            .alert-danger {
                background: #FF595F;
                border-radius: 0;
                margin: 16px auto 0;
                text-align: center;
            }

            /*The Background Part - Each svg element will act as a column that rises. Within each svg column will be a rect element that rotates. Due to an error FF regarding the transform-origin of objects in an svg, the transform-orgin must be explicitly given without percents*/

            .bg-boxes{
                /*Set the container for the svg elements to take up the whole window and hide objects outside of the window*/
                height: 100%;
                min-height: 240px;
                position: absolute;
                overflow: hidden;
                width: 100%;
                z-index: 1;
            }

            svg{
                /*Set defaults for svg columns. Opacity set to 0 so the elements are invisible before the animation begins and will not show up on browsers without animation*/
                -webkit-animation: riser 20s infinite;
                animation: riser 20s infinite;
                opacity: 0;
                overflow: visible;
                position: absolute;
            }

            .bubble{
                /*Set the defaults for the "bubbles". transform-origin should always be the center-point of the object including blank-space within the svg. Since the object should be centered, this is equal to the width of the object. The default bubble is 100px by 100px in an svg object with a width of 200px*/
                -webkit-animation: rotator 20s linear infinite;
                animation: rotator 20s linear infinite;
                fill: #FFF;
                -webkit-transform-origin: 100px 100px;
                transform-origin: 100px 100px;
            }
            #col1{
                /*Since this element is larger than the set default, I want it to rise a little faster to give a subtle sense of depth*/
                -webkit-animation-duration: 15s;
                animation-duration: 15s;
            }
            #bub1{
                /*The transform-origin has to be redefined because this bubble is not the set default size*/
                -webkit-transform-origin: 150px 150px;
                transform-origin: 150px 150px;
            }

            #col2{
                /*To offset the columns, adjust their left attribute and add an animation-delay*/
                left: 15%;
                -webkit-animation-delay: 18s;
                animation-delay: 18s;
            }

            #col3{
                left: 30%;
                -webkit-animation-delay: 14s;
                animation-delay: 14s;
                -webkit-animation-duration: 17s;
                animation-duration: 17s;
            }

            #bub3{
                -webkit-animation-delay: 14s;
                animation-delay: 14s;
                -webkit-transform-origin: 130px 130px;
                transform-origin: 130px 130px;
            }

            #col4{
                left: 45%;
                -webkit-animation-delay: 8s;
                animation-delay: 8s;
                -webkit-animation-duration: 22s;
                animation-duration: 22s;
            }

            #bub4{
                -webkit-animation-delay: 8s;
                animation-delay: 8s;
                -webkit-transform-origin: 80px 80px;
                transform-origin: 80px 80px;
            }

            #col5{
                left: 60%;
                -webkit-animation-delay: 15s;
                animation-delay: 15s;
                -webkit-animation-duration: 18s;
                animation-duration: 18s;
            }

            #bub5{
                -webkit-animation-delay: 15s;
                animation-delay: 15s;
                -webkit-transform-origin: 120px 120px;
                transform-origin: 120px 120px;
            }

            #col6{
                left: 75%;
                -webkit-animation-delay: 19s;
                animation-delay: 19s;
            }

            #col7{
                left: 90%;
                -webkit-animation-delay: 4s;
                animation-delay: 4s;
            }

            #col8{
                left: -5%;
                -webkit-animation-delay: 11s;
                animation-delay: 11s;
            }

            #col9{
                left: 25%;
                -webkit-animation-delay: 5s;
                animation-delay: 5s;
            }

            #col10{
                left: 50%;
                -webkit-animation-delay: 12s;
                animation-delay: 12s;
            }

            #col11{
                left: 67%;
                -webkit-animation-delay: 1s;
                animation-delay: 1s;
                -webkit-animation-duration: 25s;
                animation-duration: 25s;
            }

            #bub11{
                -webkit-animation-delay: 1s;
                animation-delay: 1s;
                -webkit-transform-origin: 50px 50px;
                transform-origin: 50px 50px;
            }

            /*Rotation Animation - Should be set to a factor of 360 to prevent jumpiness*/ 
            @-webkit-keyframes rotator{
                to{
                    -webkit-transform: rotate(360deg);
                    transform: rotate(360deg);
                }
            }

            @keyframes rotator{
                to{
                    -webkit-transform: rotate(360deg);
                    transform: rotate(360deg);
                }
            }

            @-webkit-keyframes riser{
                0%{
                    opacity: 0.2;
                    -webkit-transform: translateY(100%);
                    transform: translateY(100%);
                }
                100%{
                    opacity: 0.2;
                    -webkit-transform: translateY(-250px);
                    transform: translateY(-250px);
                }
            }

            @keyframes riser{
                0%{
                    opacity: 0.2;
                    -webkit-transform: translateY(100%);
                    transform: translateY(100%);
                }
                100%{
                    opacity: 0.2;
                    -webkit-transform: translateY(-250px);
                    transform: translateY(-250px);
                }
            }
        </style>
    </head>
    <body>
        <div class="content">
            <s:actionerror theme="bootstrap" />
            <!--Echo out errors here. See example-->
            <!--<p class=error>Error, wrong username or password used. Please, try again.-->
            <s:form action="login" theme="simple" namespace="/" >
                <div class="mat-in">
                    <input type="text" name="email" value="nick2" required />
                    <span class="bar"></span>
                    <label>Email</label>
                </div>
                <div class="mat-in">
                    <input type="password" name="clave" value="clave" required />
                    <span class="bar"></span>
                    <label>Contraseña</label>
                </div>
                <input type="submit" value="Iniciar Sesión">
            </s:form>
        </div>

        <div class="bg-boxes">
            <svg width="300px" height="100%" id="col1">
            <rect width="150px" height="150px" x="75px" y="75px" class="bubble" id="bub1" />
            </svg>
            <svg width="200px" height="100%" id="col2">
            <rect width="100px" height="100px" x="50px" y="50px" class="bubble" id="bub2" />
            </svg>
            <svg width="260px" height="100%" id="col3">
            <rect width="130px" height="130px" x="65px" y="65px" class="bubble" id="bub3" />
            </svg>
            <svg width="160px" height="100%" id="col4">
            <rect width="80px" height="80px" x="40px" y="40px" class="bubble" id="bub4" />
            </svg>
            <svg width="240px" height="100%" id="col5">
            <rect width="120px" height="120px" x="60px" y="60px" class="bubble" id="bub5" />
            </svg>
            <!--Here is a triangle-->
            <svg width="200px" height="100%" id="col6">
            <polygon points="50,150 100,50 150,150" class="bubble" id="bub6" />
            </svg>
            <svg width="200px" height="100%" id="col7">
            <rect width="100px" height="100px" x="50px" y="50px" class="bubble" id="bub7" />
            </svg>
            <svg width="200px" height="100%" id="col8">
            <rect width="100px" height="100px" x="50px" y="50px" class="bubble" id="bub8" />
            </svg>
            <svg width="200px" height="100%" id="col9">
            <rect width="100px" height="100px" x="50px" y="50px" class="bubble" id="bub9" />
            </svg>
            <svg width="200px" height="100%" id="col10">
            <rect width="100px" height="100px" x="50px" y="50px" class="bubble" id="bub10" />
            </svg>
            <svg width="100px" height="100%" id="col11">
            <rect width="50px" height="50px" x="25px" y="25px" class="bubble" id="bub11" />
            </svg>
        </div>
        <script src="https://code.jquery.com/jquery-2.2.0.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </body>
</html>