<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ attribute name="order" required="true" %>
<%@ attribute name="value" required="true" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="false" %>
<%@ attribute name="labelKey" required="false" %>

<div class="row">
  <div class="col-lg-6">
    <div class="input-group">

        <div class="checkbox">
          <label for="${id}">
            <input type="checkbox" name="configs[${order}].value" id="${id}" value="${value}">
            <c:choose>
                <c:when test="${not empty labelKey}">
                    <fmt:message key="${labelKey}" />
                </c:when>
                <c:otherwise>
                    ${label}
                </c:otherwise>
            </c:choose>
          </label>
          <input type="hidden" name="configs[${order}].key" id="${id}" value="${name}" />
        </div>

    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
</div><!-- /.row -->
