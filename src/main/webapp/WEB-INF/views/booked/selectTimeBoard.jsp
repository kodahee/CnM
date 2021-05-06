<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${list }" var="dto">


<c:choose>
	<c:when test="${dto.room eq'1관' }">
		<div>
		<div>${dto.room }</div>
		<div>${dto.totalSeat }</div>
		<div>${dto.movieType }</div>
		<div>${dto.scheduleDate }</div>
		<div>${dto.scheduleTime }</div>
			<table>
				<tr>
				<td></td>
				<td class="8_o'clock"><!-- 08:00~ --></td>
				<td class="10_o'clock"><!-- 10:00~ --></td>
				<td class="12_o'clock"><!-- 12:00~ --></td>
				<td class="14_o'clock"><!-- 14:00~ --></td>
				<td class="16_o'clock"><!-- 16:00~ --></td>
				<td class="18_o'clock"><!-- 18:00~ --></td>
				<td class="20_o'clock"><!-- 20:00~ --></td>
				<td class="22_o'clock"><!-- 22`:00~ --></td>
				</tr>
			</table>
		</div>
	</c:when>
	<c:when test="${dto.room eq'2관' }">
		<div>
		<div>${dto.room }</div>
		<div>${dto.totalSeat }</div>
		<div>${dto.movieType }</div>
		<div>${dto.scheduleDate }</div>
		<div>${dto.scheduleTime }</div>
			<table>
				<tr>
				<td></td>
				<td class="8_o'clock"><!-- 08:00~ --></td>
				<td class="10_o'clock"><!-- 10:00~ --></td>
				<td class="12_o'clock"><!-- 12:00~ --></td>
				<td class="14_o'clock"><!-- 14:00~ --></td>
				<td class="16_o'clock"><!-- 16:00~ --></td>
				<td class="18_o'clock"><!-- 18:00~ --></td>
				<td class="20_o'clock"><!-- 20:00~ --></td>
				<td class="22_o'clock"><!-- 22`:00~ --></td>
				</tr>
			</table>
		</div>
	</c:when>
	<c:when test="${dto.room eq'3관' }">
		<div>
		<div>${dto.room }</div>
		<div>${dto.totalSeat }</div>
		<div>${dto.movieType }</div>
		<div>${dto.scheduleDate }</div>
		<div>${dto.scheduleTime }</div>
			<table>
				<tr>
				<td></td>
				<td class="8_o'clock"><!-- 08:00~ --></td>
				<td class="10_o'clock"><!-- 10:00~ --></td>
				<td class="12_o'clock"><!-- 12:00~ --></td>
				<td class="14_o'clock"><!-- 14:00~ --></td>
				<td class="16_o'clock"><!-- 16:00~ --></td>
				<td class="18_o'clock"><!-- 18:00~ --></td>
				<td class="20_o'clock"><!-- 20:00~ --></td>
				<td class="22_o'clock"><!-- 22`:00~ --></td>
				</tr>
			</table>
		</div>
	</c:when>
	<c:when test="${dto.room eq'4관' }">
		<div>
		<div>${dto.room }</div>
		<div>${dto.totalSeat }</div>
		<div>${dto.movieType }</div>
		<div>${dto.scheduleDate }</div>
		<div class="time">${dto.scheduleTime }</div>
			<table>
				<tr>
				<td></td>
				<td class="8_o'clock"><!-- 08:00~ --></td>
				<td class="10_o'clock"><!-- 10:00~ --></td>
				<td class="12_o'clock"><!-- 12:00~ --></td>
				<td class="14_o'clock"><!-- 14:00~ --></td>
				<td class="16_o'clock"><!-- 16:00~ --></td>
				<td class="18_o'clock"><!-- 18:00~ --></td>
				<td class="20_o'clock"><!-- 20:00~ --></td>
				<td class="22_o'clock"><!-- 22`:00~ --></td>
				</tr>
			</table>
		</div>
	</c:when>
</c:choose>
</c:forEach>

