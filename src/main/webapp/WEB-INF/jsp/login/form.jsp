		<h2>Login</h2>

        <form class="form-horizontal" action="${linkTo[LoginController].login()}" method="post" >
            <fieldset>

            <!-- Form Name -->
            <legend>Login</legend>

            <!-- Text input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="textinput">Login</label>
              <div class="col-md-4">
              <input id="login" name="login" type="text" placeholder="User name" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Password input-->
            <div class="form-group">
              <label class="col-md-4 control-label" for="passwordinput">password</label>
              <div class="col-md-4">
                <input id="pass" name="pass" type="password" placeholder="Password" class="form-control input-md" required="">

              </div>
            </div>

            <!-- Button -->
            <div class="form-group">
              <label class="col-md-4 control-label" for="login"></label>
              <div class="col-md-4">
                <button id="send" name="send" class="btn btn-primary">Login</button>
              </div>
            </div>

            </fieldset>
        </form>

<script>
	function init(){
		$(".menu").find(".login").addClass("active");
		document.title = document.title + " | Login";
	}
</script>
