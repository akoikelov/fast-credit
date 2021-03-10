<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@tag description="Base template" pageEncoding="UTF-8" %>
<%@attribute name="title" fragment="true" %>
<%@attribute name="content" fragment="true" %>

<!doctype html>
<html lang="en">
<head>
    <meta name="robots" content="index, follow"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>
        <jsp:invoke fragment="title"/>
    </title>

    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/css/lightweight-admin-template.css">
    <link rel="stylesheet" type="text/css" href="https://mazipan.github.io/bem-kit/dist/bem-kit.min.css">
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
                <img class="account__img" src="/images/irfan-maulana.jpg"/>
                <security:authorize access="isAuthenticated()">

                    <span class="account__name"><security:authentication property="principal.username"/></span>

                </security:authorize>

            </div>
            <i class="account__arrow fa fa-angle-down js--show-dropdown-menu"></i>

            <div class="account__menu">
                <ul class="account__menu-wrapper">
                    <li class="account__menu-item"><a href="/profile">Профиль</a></li>
                    <li class="account__menu-item"><a href="/logout">Выход</a></li>
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
                <a href="/">
                    <i class="nav__icon fa fa-dashboard"></i> Главная
                </a>
            </li>

            <li class="nav__item nav__item--has-child ">
                <a href="#">
                    <i class="nav__icon fa fa-desktop"></i> Добавить
                    <i class="nav__arrow fa fa-angle-down"></i>
                </a>

                <ul class="nav__wrapper nav__wrapper--child" style="display: none;">
                    <li class="nav__item--child"><a href="/customer/new">Новый клиент</a></li>
                    <li class="nav__item--child"><a href="/customers/newdepositauto">Новый залог(авто)</a></li>
                    <li class="nav__item--child"><a href="/customers/newdepositanother">Новый залог(другое)</a></li>
                    <li class="nav__item--child"><a href="/customers/newcontract">Новый договор</a></li>
                    <li class="nav__item--child"><a href="/customers/newpayment">Новый платеж</a></li>
                </ul>
            </li>
            <li class="nav__item nav__item--has-child ">
                <a href="#">
                    <i class="nav__icon fa fa-desktop"></i> Списки
                    <i class="nav__arrow fa fa-angle-down"></i>
                </a>

                <ul class="nav__wrapper nav__wrapper--child" style="display: none;">
                    <li class="nav__item--child"><a href="/list/transaction">Список проводок</a></li>
                    <li class="nav__item--child"><a href="/customer/list">Список клиентов</a></li>
                    <li class="nav__item--child"><a href="/list/deposit">Список залогов</a></li>
                    <li class="nav__item--child"><a href="/list/pko">Список ПКО</a></li>
                    <li class="nav__item--child"><a href="/list/rko">Список РКО</a></li>
                    <li class="nav__item--child"><a href="/list/getlastcontract">Посл договора</a></li>
                    <li class="nav__item--child"><a href="/list/sales">Список продаж</a></li>
                    <li class="nav__item--child"><a href="/list/shopping">Список покупок</a></li>
                </ul>
            </li>
            <li class="nav__item nav__item--has-child ">
                <a href="#">
                    <i class="nav__icon fa fa-desktop"></i> Касса
                    <i class="nav__arrow fa fa-angle-down"></i>
                </a>

                <ul class="nav__wrapper nav__wrapper--child" style="display: none;">
                    <li class="nav__item--child"><a href="/cashbox/newpko">Новый ПКО</a></li>
                    <li class="nav__item--child"><a href="/cashbox/newrko">Новый РКО</a></li>
                    <li class="nav__item--child"><a href="/cashbox/newrkopartner">Повый РКО Партн</a></li>
                </ul>
            </li>
            <li class="nav__item nav__item--has-child ">
                <a href="#">
                    <i class="nav__icon fa fa-desktop"></i> Отчеты
                    <i class="nav__arrow fa fa-angle-down"></i>
                </a>

                <ul class="nav__wrapper nav__wrapper--child" style="display: none;">
                    <li class="nav__item--child"><a href="/reports/clientsreports">Отчеты о клиенте</a></li>
                    <li class="nav__item--child"><a href="/reports/cashboxreports">Отчет касса</a></li>
                    <li class="nav__item--child"><a href="/reports/debtorreports">Отчет должников</a></li>
                    <li class="nav__item--child"><a href="/reports/nondebtorreports">Отчет недолжников</a></li>
                    <li class="nav__item--child"><a href="/reports/costreports">Отчет по расходам</a></li>
                    <li class="nav__item--child"><a href="/reports/creditreports">Отчет по кредитам</a></li>
                </ul>
            </li>

            <security:authorize access="hasAnyRole('ADMIN','SUPERADMIN')">
                <li class="nav__item nav__item--has-child ">
                    <a href="#">
                        <i class="nav__icon fa fa-desktop"></i> Админ
                        <i class="nav__arrow fa fa-angle-down"></i>
                    </a>

                    <ul class="nav__wrapper nav__wrapper--child" style="display: none;">
                        <li class="nav__item--child"><a href="/admin/cancelinterest">Отмена пени</a></li>
                        <li class="nav__item--child"><a href="/admin/payroll">Начисление ЗП</a></li>
                        <li class="nav__item--child"><a href="/admin/transfer">Перевод денег</a></li>
                        <li class="nav__item--child"><a href="/admin/transferofaccrual">Перенос начислений</a></li>
                        <li class="nav__item--child"><a href="/admin/missedcharges">Пропущенные начисления</a></li>
                    </ul>
                </li>
            </security:authorize>
            <security:authorize access="hasRole('SUPERADMIN')">
                <li class="nav__item nav__item--has-child ">
                    <a href="#">
                        <i class="nav__icon fa fa-desktop"></i> Супер админ
                        <i class="nav__arrow fa fa-angle-down"></i>
                    </a>

                    <ul class="nav__wrapper nav__wrapper--child" style="display: none;">
                        <li class="nav__item--child"><a href="/superadmin/affiliates">Список филиалов</a></li>
                        <li class="nav__item--child"><a href="/superadmin/employees">Список сотрудников</a></li>
                        <li class="nav__item--child"><a href="/superadmin/cashboxes">Список касс</a></li>
                        <li class="nav__item--child"><a href="/superadmin/analytics">Список аналитики</a></li>
                    </ul>
                </li>
            </security:authorize>

            <li class="nav__item"><a href="forms.html">
                <i class="nav__icon fa fa-edit"></i> Калькулятор</a>
            </li>

        </ul>
    </nav>
    <article class="main__content content">
        <div class="content__wrapper">
            <jsp:invoke fragment="content"/>
        </div>
    </article>
</main>

<script src="https://mazipan.github.io/library/jquery.min.js"></script>
<script src="/js/lightweight-admin-template.js"></script>

</body>
</html>
