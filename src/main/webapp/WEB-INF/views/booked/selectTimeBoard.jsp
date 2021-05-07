<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<div class="detail_cont">
<c:forEach items="${list }" var="dto">

<c:choose>
	<c:when test="${dto.room eq'1관' }">
		<div class="inner_cont t">
	
		<div>${dto.scheduleDate }</div>
		<div>${dto.room }</div>
			<dl class="list_cont">
				<dt class="scheduleTime">${dto.scheduleTime }</dt>
				<dd>${dto.movieType }</dd>
			</dl>
		<div hidden="hidden" class="totalSeat">${dto.totalSeat }</div>
		</div>
	</c:when>
	<c:when test="${dto.room eq'2관' }">
		<div class="inner_cont t">
		
		<div>${dto.scheduleDate }</div>
		<div>${dto.room }</div>
			<dl class="list_cont">
				<dt>${dto.scheduleTime }</dt>
				<dt>${dto.movieType }</dt>
			</dl>
		</div>
	</c:when>
	<c:when test="${dto.room eq'3관' }">
		<div class="inner_cont t">
		
		<div>${dto.scheduleDate }</div>
		<div>${dto.room }</div>
			<dl class="list_cont"> 
				<dt>${dto.scheduleTime }</dt>
				<dt>${dto.movieType }</dt>
			</dl>
		</div>
	</c:when>
	<c:when test="${dto.room eq'4관' }">
		<div class="inner_cont t">
	
		<div>${dto.scheduleDate }</div>
		<div>${dto.room }</div>
			<dl class="list_cont">
				<dt>${dto.scheduleTime }</dt>
				<dt>${dto.movieType }</dt>
			</dl>
		</div>
	</c:when>
</c:choose>
</c:forEach>
</div>
<script type="text/javascript">
	let t = $('.time').text();
	let time = new Date(t);
	let o=time.getHours()
	$('.o').text(o);
</script>