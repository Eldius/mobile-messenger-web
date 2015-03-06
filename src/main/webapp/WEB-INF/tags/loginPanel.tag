				<c:if test="${not empty userSession.login}">
                    <ul class="nav navbar-nav navbar-right" id="userSession">
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <c:out value="${userSession.login}"/> <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu" role="menu">
                                <li>
                                    <a href="${linkTo[LoginController].logout()}">Sair</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </c:if>