    <h3>User Form</h3>

    <form class="form-horizontal" method="post" action="${linkTo[UserController].save()}">
        <fieldset>

        <!-- Form Name -->
        <legend>User data:</legend>

            <input
                type="hidden"
                name="user.id"
                value="<c:out value="${userInfo.id}" />" />

            <tag:textFormAttribute
                id="user_field_login"
                name="user.login"
                labelKey="user.form.login.label"
                placeholder="Login"
                value="${userInfo.login}"
                required="true" />

            <tag:passwordFormAttribute
                id="user_field_pass"
                name="user.password"
                labelKey="user.form.pass.label"
                placeholder="Password"
                required="true" />

            <tag:textFormAttribute
                id="user_field_email"
                name="user.email"
                labelKey="user.form.email.label"
                placeholder="Email"
                value="${userInfo.email}"
                required="true" />

            <div class="row">
                &nbsp;
            </div>
            <button type="submit" id="user_form_save" class="btn btn-success">Salvar</button>
            <button type="reset" id="user_form_cancel" class="btn btn-danger" id="cancel">Cancelar</button>
        </fieldset>
    </form>

<script>

	function init() {
        $("#cancel").click(function() {
            history.back();
        });
	}

</script>