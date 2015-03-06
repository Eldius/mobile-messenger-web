
<h3><fmt:message key="page.packages.title" /></h3>

<a class="btn btn-default" href="${linkTo[ViagemController].form()}">Novo</a>

<br />

<table class="table table-stripped">
    <thead>
        <tr>
            <th><fmt:message key="page.packages.grid.id" /></th>
            <th><fmt:message key="page.packages.grid.title" /></th>
            <th><fmt:message key="page.packages.grid.price" /></th>
            <th><fmt:message key="page.packages.grid.action" /></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${pacoteViagemList}" var="pacote">
            <tr>
                <td><c:out value="${pacote.id}" />
                <td><c:out value="${pacote.titulo}" />
                <td><c:out value="${pacote.valor}" />
                <td>
                    <a href="${linkTo[ViagemController].form(pacote.id)}">
                        <span class="glyphicon glyphicon-pencil"></span>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<script>
	function init(){
		$(".menu").find(".package").addClass("active");
		document.title = document.title + " | List page";

		$(".editElement").click(function(){
			var url = $(this).data('element-url');
			showModalForm(url);
		});
	}
</script>
