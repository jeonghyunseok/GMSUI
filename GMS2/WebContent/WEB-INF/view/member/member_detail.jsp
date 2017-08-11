<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../common/common_head.jsp"/>

<div id="container">	
		<table id="member_detail_tab">
			<tr>
				<td colspan="2" rowspan="3"><img src="${ctx}/img/defaultimg.jpg" ></td>
				<td>NAME</td>
				<td></td>
			</tr>
			<tr>
				<td>ID</td>
				<td></td>
			</tr>
			<tr>
				<td>SSN</td>
				<td></td>
			</tr>
			<tr>
				<td>PHONE</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td>e-mail</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td>grade</td>
				<td colspan="3">A</td>
			</tr>
			<tr>
				<td>major</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td>Regdate</td>
				<td colspan="3"></td>
			</tr>
		</table>
		<button id="list_btn" onclick="javascript:goList()">목록으로</button>
		<button id="update_btn" onclick="javascript:goUpdate()">목록수정</button>
</div>
	<script>
	function goList(){
		location.href="${ctx}/member/member_list.jsp?action=list";
	}
	function goUpdate(){
		location.href="${ctx}/member/member_update.jsp?name=null&email=null&phone=null&major_id=null&id=null&ssn=null";
	}
	</script>
	
<jsp:include page="../common/footer.jsp"></jsp:include>
