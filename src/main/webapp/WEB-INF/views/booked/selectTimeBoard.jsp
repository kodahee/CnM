<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${list }" var="dto">


<c:choose>
	<c:when test="${dto.room eq'1관' }">
		<div>
		<div></div>
		<div>${dto.scheduleDate }</div>
		<div>${dto.room }</div>
			<dl>
				<dt>${dto.scheduleTime }</dt>
				<dd>${dto.movieType }</dd>
			</dl>
		</div>
	</c:when>
	<c:when test="${dto.room eq'2관' }">
		<div>
		<div></div>
		<div>${dto.totalSeat }</div>
		<div>${dto.scheduleDate }</div>
		<div>${dto.room }</div>
			<dl>
				<dt>${dto.scheduleTime }</dt>
				<dd>${dto.movieType }</dd>
			</dl>
		</div>
	</c:when>
	<c:when test="${dto.room eq'3관' }">
		<div>
		<div></div>
		<div>${dto.totalSeat }</div>
		<div>${dto.scheduleDate }</div>
		<div>${dto.room }</div>
			<dl>
				<dt>${dto.scheduleTime }</dt>
				<dd>${dto.movieType }</dd>
			</dl>
		</div>
	</c:when>
	<c:when test="${dto.room eq'4관' }">
		<div>
		<div></div>
		<div>${dto.totalSeat }</div>
		<div>${dto.scheduleDate }</div>
		<div>${dto.room }</div>
			<dl>
				<dt>${dto.scheduleTime }</dt>
				<dd>${dto.movieType }</dd>
			</dl>
		</div>
	</c:when>
</c:choose>
</c:forEach>

<script type="text/javascript">
	let t = $('.time').text();
	let time = new Date(t);
	let o=time.getHours()
	$('.o').text(o);
</script>