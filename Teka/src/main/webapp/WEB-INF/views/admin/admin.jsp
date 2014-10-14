<%@page import="org.joda.time.DateTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@page session="false" %>
<%@taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<% pageContext.setAttribute("now", new DateTime());%>
<h1>Admin page</h1>
<s:url var="logoutUrl" value="/j_spring_security_logout" />
<p></p>

<div id="userinfo">
    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal.username" />
        <br/>
        <a href="${logoutUrl}">labelLogout</a>
    </sec:authorize>
</div>