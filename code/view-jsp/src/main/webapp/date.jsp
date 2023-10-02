<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/functions.tld" prefix="f" %>

<fmt:requestEncoding value="UTF-8" />

<html>
    <head><title>Localized Dates</title></head>
    <body bgcolor="white">

        <jsp:useBean id="locales" scope="application" class="br.cefetmg.inf.sisloc.util.MyLocales" />

        <form name="localeForm" action="date.jsp" method="post">
        </p>
        <c:set var="selectedLocaleString" value="${param.locale}" />
        <c:set var="selectedFlag" value="${not empty selectedLocaleString}" />
        <b>Locale:</b>
        <select name=locale>
            <c:forEach var="localeString" items="${locales.localeNames}" >
                <c:choose>
                    <c:when test="${selectedFlag}">
                        <c:choose>
                            <c:when test="${f:equals(selectedLocaleString,localeString)}" >
                                <option selected>${localeString}</option>
                            </c:when>
                            <c:otherwise>
                                <option>${localeString}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <option>${localeString}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
        <input type="submit" name="Submit" value="Get Date">
    </form>

    <c:if test="${selectedFlag}" >
        <jsp:setProperty name="locales" property="selectedLocaleString" value="${selectedLocaleString}" />
        <jsp:useBean id="date" class="br.cefetmg.inf.sisloc.util.MyDate"/>
        <jsp:setProperty name="date" property="locale" value="${locales.selectedLocale}"/>
        <b>Date: </b>${date.date}
    </c:if>

</body>
</html>
