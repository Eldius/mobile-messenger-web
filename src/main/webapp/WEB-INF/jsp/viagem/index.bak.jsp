
<h3><fmt:message key="form.customer.title" /></h3>

<c:forEach items="${customerList }" var="customerIt" varStatus="id">
	${id.index }
	<jsp:include page="/ui_components/customer_view.jsp"></jsp:include>
</c:forEach>



<br />

<c:import url="/ui_components/customer_form.jsp"></c:import>


<c:forEach items="${customerList }" var="customerIt" varStatus="id">
	<%@ include file="/ui_components/customer_view.jsp"%>
</c:forEach>