		<h2>Admin</h2>

        <form class="form-horizontal" method="post" action="${linkTo[AdminController].saveConfig()}">
            <fieldset>
                <!-- Form Name -->
                <legend>Configura&ccedil;&atilde;o da aplica&ccedil;&atilde;o</legend>

                <tag:booleanConfigAttribute
                    id="openReg"
                    name="app.config.open_reg"
                    order="0"
                    value="true"
                    labelKey="admin.config.open_reg"
                    property="${serverConfigGetter.openRegistrationProperty}"/>

                <!-- Button (Double) -->
                <div class="row">
                    <div class="input-group">
                        <div class="col-lg-16">
                            <button id="save" name="save" class="btn btn-success">Salvar</button>
                            <button id="reset" name="reset" class="btn btn-danger">Cancelar</button>
                        </div>
                    </div>
                </div> <!-- /.row -->
            </fieldset>
        </form>

<script>
	function init(){
		$(".menu").find(".admin").addClass("active");
		document.title = document.title + " | Admin page";
	}
</script>
