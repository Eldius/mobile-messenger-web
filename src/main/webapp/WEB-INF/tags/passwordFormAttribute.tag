<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ attribute name="id" required="true" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="label" required="false" %>
<%@ attribute name="labelKey" required="false" %>
<%@ attribute name="placeholder" required="false" %>
<%@ attribute name="required" required="false" %>

<!-- Text input-->
<div class="row">
  <div class="col-lg-6">
    <div class="input-group">
      <span class="input-group-addon" id="basic-addon1" for="${id}">
        <c:choose>
            <c:when test="${not empty labelKey}">
                <fmt:message key="${labelKey}" />
            </c:when>
            <c:otherwise>
                ${label}
            </c:otherwise>
        </c:choose>
      </span>
      <div class="controls">
        <input type="password" class="form-control" aria-describedby="basic-addon1" id="${id}" name="${name}" type="text" placeholder="${placeholder}" class="input-xlarge" <c:if test="${required}"> required="" </c:if> >
      </div>
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
</div><!-- /.row -->
