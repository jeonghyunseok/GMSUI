<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="../common/common_head.jsp"/>

<div id="container">	
      	<form action="${ctx}/member/service_update.jsp" method="get" >
		<table id="member_detail_tab">
			<tr>
				<td colspan="2" rowspan="3"><img src="../img/jam.jpg"></td>
				<td>NAME</td>
				<td></td>
			</tr>
			<tr>
				<td>ID</td>
				<td></td>
			</tr>
			<tr>
				<td>email</td>
				<td></td>
			</tr>
			<tr>
				<td>major</td>
				<td colspan="3"><input type="text" name="major_id"  placeholder="null"/></td>
			</tr>
			<tr>
				<td>phone</td>
				<td colspan="3"><input type="text" name="phone"  placeholder="null"/></td>
			</tr>
			<tr>
				<td>regdate</td>
				<td colspan="3"></td>
			</tr>

		</table>
		<input type="submit" id="confirm_btn" value="수정"/>
		<input type="button" onclick="javascript:cancel()" value="취소"/>
		<input type="hidden" name="id" value="null" />
		</form>
</div>
	<script>
	function cancel(){
			location.href="${ctx}/member/member_list.jsp?action=list";
	}
	</script>

<jsp:include page="../common/footer.jsp"></jsp:include>
