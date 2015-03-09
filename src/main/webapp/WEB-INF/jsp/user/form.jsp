    <h3>User Form</h3>

    <form class="form-horizontal" method="post" action="${linkTo[UserController].save()}">
        <fieldset>

        <!-- Form Name -->
        <legend>User data:</legend>

            <input
                type="hidden"
                name="userInfo.id"
                value="<c:out value="${user.id}" />"

            <tag:textFormAttribute
                id="login"
                name="user.login"
                labelKey="user.form.login.label"
                placeholder="Login"
                value="${userInfo.login}"
                required="true" />

            <tag:passwordFormAttribute
                id="pass"
                name="user.password"
                labelKey="user.form.pass.label"
                placeholder="Password"
                required="true" />

            <tag:textFormAttribute
                id="email"
                name="user.email"
                labelKey="user.form.email.label"
                placeholder="Email"
                value="${userInfo.email}"
                required="true" />

            <div class="row">
                &nbsp;
            </div>
            <button type="submit" class="btn btn-success">Salvar</button>
            <button type="reset" class="btn btn-danger">Cancelar</button>
        </fieldset>
    </form>