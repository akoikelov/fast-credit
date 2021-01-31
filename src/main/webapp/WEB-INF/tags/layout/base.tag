<%@tag description="Base template" pageEncoding="UTF-8"%>
<%@attribute name="title" fragment="true" %>
<%@attribute name="content" fragment="true" %>

<!doctype html>
<html lang="en">
<head>
    <meta name="robots" content="index, follow"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title><jsp:invoke fragment="title" /></title>

    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/lightweight-admin-template.css">

</head>
<body class="site">

<header role="header" class="site__header header" id="home">
    <div class="header__wrapper">

        <div class="header__brand">
            <div class="header__title">
                Spring MVC App
            </div>
        </div>

        <div class="header__account account account--has-login">
            <div class="account__wrapper">
                <img class="account__img" src="/images/irfan-maulana.jpg" />
                <span class="account__name">{Username}</span>
            </div>
            <i class="account__arrow fa fa-angle-down js--show-dropdown-menu"></i>

            <div class="account__menu">
                <ul class="account__menu-wrapper">
                    <li class="account__menu-item"><a href="">Profile</a></li>
                    <li class="account__menu-item"><a href="">Logout</a></li>
                </ul>
            </div>

        </div>

        <div class="header__nav--mobile">
            <div class="header__nav-btn" id="menu-toggle">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </div>
        </div>

    </div>
</header>


<main role="main" class="site__main main">
    <nav class="main__nav nav">

        <ul class="nav__wrapper">
            <li class="nav__item nav__item--active">
                <a href="">
                    <i class="nav__icon fa fa-dashboard"></i> Dashboard
                </a>
            </li>
        </ul>
    </nav>
    <article class="main__content content">
        <div class="content__wrapper">
            <jsp:invoke fragment="content" />
        </div>
    </article>
</main>

<script src="https://mazipan.github.io/library/jquery.min.js"></script>
<script src="/js/lightweight-admin-template.js"></script>

</body>
</html>
