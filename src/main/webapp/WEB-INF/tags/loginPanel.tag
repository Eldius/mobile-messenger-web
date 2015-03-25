<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


    <c:if test="${empty userSession.login}">

        <!-- login form -->

        <form class="navbar-form navbar-right" role="form" id="loginForm" action="${linkTo[LoginController].login()}" method="post" >
            <div class="form-group">
                <input type="text" name="login" id="menubar_login_field" placeholder="Email" class="form-control">
            </div>
            <div class="form-group">
                <input type="password" name="pass" id="menubar_pass_field" placeholder="Password" class="form-control">
            </div>
            <button id="login_button" type="submit" class="btn btn-success">Sign in</button>
            <c:if test="${not empty serverConfigGetter.openRegistrationProperty && serverConfigGetter.openRegistrationProperty.booleanValue}">
                <a id="signupButton" class="btn btn-info" href="${linkTo[UserController].form()}">Sign up</a>
            </c:if>
        </form>
    <!-- login form -->
    </c:if>

    <c:if test="${not empty userSession.login}">
        <ul class="nav navbar-nav navbar-right" id="userSession">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                    <c:out value="${userSession.login}"/> <span class="caret"></span>
                </a>
                <ul class="dropdown-menu" role="menu">
                    <li>
                        <a id="userSession_profile_subitem" href="${linkTo[UserController].form(userSession.user)}">Perfil</a>
                    </li>
                    <li>
                        <a id="userSession_logout_subitem" href="${linkTo[LoginController].logout()}">Sair</a>
                    </li>
                </ul>
            </li>
        </ul>
    </c:if>