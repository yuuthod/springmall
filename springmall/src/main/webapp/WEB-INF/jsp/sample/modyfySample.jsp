<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- bootstrap CDN -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<!-- jquery CDN -->
<script type="text/javascript">
$(document).ready(()=>{
	//정규표현식을 이용한 id값 유효성 검사
	//대문자 또는 소문자로 시작하는 2~15자리 이내 (숫자로 시작 x)
	var idReg = /^[A-Za-z]{1}[A-Za-z0-9]{3,19}$/;
	
	//정규표현식을 이용한 pw값 유효성 검사
	//영문,숫자 혼합하여 6~20자리 이내
	var checkPw = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
	
	//버튼을 클릭하면 아이디,비밀번호 유효성 검사
	$('#addMemberBtn').click(()=>{
		if(!idReg.test($('#sampleId').val())){
			$('#idHelper').text('다시 입력하세요');
			$('#sampleId').focus();
			$('#pwHelper').text('');
		}else{
			$('#idHelper').text('');
			if(!checkPw.test($('#samplePw').val())){
				$('#pwHelper').text('영문,숫자 혼합하여 6~20자리 이내로 입력해주세요');
				$('#samplePw').focus();
			}else{
				$('#pwHelper').text('');
				$('#addMemberForm').submit();
			}
		}
	});
});
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md"></div>
			<div class="col-md">
				<h1>회원수정</h1>
				<form action="/sample/modyfySample" method="post" id="addMemberForm">
					<input value="${ sample.sampleNo }" type="text" name="sampleNo" class="form-control mb-2" readonly>
					<input value="${ sample.sampleId }" type="text" name="sampleId" id="sampleId"  class="form-control mb-2">
					<span id="idHelper"></span>
					<input value="${ sample.samplePw }" type="password" name="samplePw" id="samplePw" class="form-control mb-2">
					<span id="pwHelper"></span>
					<div><input type="button" value="회원수정" id="addMemberBtn" class="btn btn-primary"></div>
				</form>
			</div>
			<div class="col-md"></div>
		</div>
	</div>
</body>
</html>