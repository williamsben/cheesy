<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="ch" %>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Cheesy Login</title>
        <link href="/demo/css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body class="cheesy-background">
        <div class="overlay"></div>
        <div class="full flex flex-center">
            <div class="modal text-center border flex flex-column">
                <ch:message />
                <form class="flex flex-column" name='login-form' action="login" method='POST' autocomplete="off">
                    <input class="box border text-center text-input" type='text' placeholder="Username" name='username'>
                    <input class="box border text-center text-input" type='password' placeholder="Password" name='password' />
                    <input class="box button text-center" name="submit" type="submit" value="Login" />
                </form>
            </div>
        </div>
    </body>
</html>