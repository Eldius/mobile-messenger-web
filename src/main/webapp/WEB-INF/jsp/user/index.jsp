    <h3>User Form</h3>

    <div id="userList">
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>#ID</th>
                    <th>Login</th>
                    <th>Email</th>
                    <th>Admin</td>
                    <th>Editar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${userInfoList}" var="user" varStatus="userIndex">
                    <tr>
                        <td><c:out value="${user.id}" /></td>
                        <td><c:out value="${user.login}" /></td>
                        <td><c:out value="${user.email}" /></td>
                        <td>
                            <input
                                id="user_${userIndex.index}"
                                type="checkbox"
                                class="adminChecker"
                                data-user-id="${user.id}"
                                <c:if test="${user.userType.accessLevel == 0}">
                                    checked="checked"
                                </c:if>
                                data-on-text="<fmt:message key="dialog.yes.button" />"
                                data-off-text="<fmt:message key="dialog.no.button" />"
                                 />
                        </td>
                        <td>
                            <a href="${linkTo[UserController].form(user)}" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span></a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

<script>
	function init(){
		$(".menu").find(".users").addClass("active");
		document.title = document.title + " | Users page";

        $(".adminChecker").bootstrapSwitch();

        $('.adminChecker').on('switchChange.bootstrapSwitch', function(event, state) {
            console.log(state);
            var element = $(this);

            jQuery.post(
                '${linkTo[UserController].setAsAdmin()}'
                , 'userId=' + $(this).data('user-id') + '&isAdmin=' + state
                , function(data, status) {
                    console.log(JSON.stringify(data));
                    console.log(JSON.stringify(status));
                }
            ).fail(function(){
                element.bootstrapSwitch("toggleState", true);
            });
        });

	}

</script>
