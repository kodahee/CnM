<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${list }" var="dto">
<div>${dto.theaterNum }</div>
<div>${dto.room }</div>

<c:choose>
	<c:when test="${dto.room eq'1관' }">
	
	</c:when>
	<c:when test="${dto.room eq'2관' }">
	
	</c:when>
	<c:when test="${dto.room eq'3관' }">
	
	</c:when>
	<c:when test="${dto.room eq'4관' }">
	
	</c:when>
</c:choose>
</c:forEach>
