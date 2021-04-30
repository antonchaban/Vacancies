<%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 30.04.2021
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <style>
        @import url("https://rsms.me/inter/inter-ui.css");
        ::selection {
            background: #2d2f36;
        }
        ::-webkit-selection {
            background: #2d2f36;
        }
        ::-moz-selection {
            background: #2d2f36;
        }
        body {
            background-image: url("https://i.pinimg.com/originals/46/1d/25/461d254f8563f8945ce3a385f289df17.jpg");
            font-family: "Inter UI", sans-serif;
            margin: 0;
        }
        .page {
            background-image: url("https://i.pinimg.com/originals/46/1d/25/461d254f8563f8945ce3a385f289df17.jpg");
            display: flex;
            flex-direction: column;
            height: calc(100%);
            position: absolute;
            place-content: center;
            width: calc(100%);
        }
        @media (max-width: 767px) {
            .page {
                height: auto;
                margin-bottom: 20px;
                padding-bottom: 20px;
            }
        }
        .container {
            display: flex;
            height: 320px;
            margin: 0 auto;
            width: 640px;
        }
        @media (max-width: 767px) {
            .container {
                flex-direction: column;
                height: 630px;
                width: 320px;
            }
        }
        .left {
            background: rgba(255, 255, 255, 0);
            height: calc(100% - 40px);
            top: 20px;
            position: relative;
            width: 50%;
        }
        @media (max-width: 767px) {
            .left {
                height: 100%;
                left: 20px;
                width: calc(100% - 40px);
                max-height: 270px;
            }
        }
        .login {
            font-size: 50px;
            font-weight: 900;
            margin: 50px 40px 40px;
        }
        .eula {
            color: #999;
            font-size: 14px;
            line-height: 1.5;
            margin: 40px;
        }
        .right {
            background: #474a59;
            box-shadow: 0px 0px 40px 16px rgba(0, 0, 0, 0.22);
            color: #f1f1f2;
            position: relative;
            width: 50%;
        }
        @media (max-width: 767px) {
            .right {
                flex-shrink: 0;
                height: 100%;
                width: 100%;
                max-height: 350px;
            }
        }
        svg {
            position: absolute;
            width: 320px;
        }
        path {
            fill: none;
            stroke: url(#linearGradient);
            stroke-width: 4;
            stroke-dasharray: 240 1386;
        }
        .form {
            margin: 40px;
            position: absolute;
        }
        label {
            color: #c2c2c5;
            display: block;
            font-size: 14px;
            height: 16px;
            margin-top: 20px;
            margin-bottom: 5px;
        }
        input {
            background: transparent;
            border: 0;
            color: #f2f2f2;
            font-size: 20px;
            height: 30px;
            line-height: 30px;
            outline: none !important;
            width: 100%;
        }
        input::-moz-focus-inner {
            border: 0;
        }
        #submit {
            color: #707075;
            margin-top: 40px;
            transition: color 300ms;
        }
        #submit:focus {
            color: #f2f2f2;
        }
        #submit:active {
            color: #d0d0d2;
        }

    </style>
</head>
<body>
<div class="page">
    <div class="container">
        <div class="left">
            <div class="login">Sign-Up</div>
            <div class="eula">By registration in you agree to check out my super-puper course work immediately</div>
        </div>
        <div class="right">
            <svg viewBox="0 0 320 300">
                <defs>
                    <linearGradient inkscape:collect="always" id="linearGradient" x1="13" y1="193.49992" x2="307" y2="193.49992" gradientUnits="userSpaceOnUse">
                        <stop style="stop-color:#ff00ff;" offset="0" id="stop876" />
                        <stop style="stop-color:#ff0000;" offset="1" id="stop878" />
                    </linearGradient>
                </defs>
                <path d="m 40,120.00016 239.99984,-3.2e-4 c 0,0 24.99263,0.79932 25.00016,35.00016 0.008,34.20084 -25.00016,35 -25.00016,35 h -239.99984 c 0,-0.0205 -25,4.01348 -25,38.5 0,34.48652 25,38.5 25,38.5 h 215 c 0,0 20,-0.99604 20,-25 0,-24.00396 -20,-25 -20,-25 h -190 c 0,0 -20,1.71033 -20,25 0,24.00396 20,25 20,25 h 168.57143" />
            </svg>
            <form method="post" action="/do/register" class="form" >
                <label for="email">Email</label>
                <input type="email" id="email" name="login">
                <label for="password">Password</label>
                <input type="password" id="password" name="password">
                <input type="submit" id="submit" value="Register">
            </form>
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.0.2/anime.js"></script>
<script src="backend.js" charset="utf-8"></script>
<script src="/javascript/animation.js"></script>
</body>
</html>
