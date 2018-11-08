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
<style>
	.container{margin-top:200px;}
</style>
<!-- jquery CDN -->
<script type="text/javascript">
	// jquery를 이용한 유효성 검사
	$(document).ready(()=>{
		//정규표현식을 이용한 id값 유효성 검사
		//대문자 또는 소문자 또는 숫자로 시작하는 아이디 (숫자로 시작하는 아이디x, 길이제한 없음)
		let checkId = /^[A-za-z]/g;
		//길이 제한 있는 식
		//var idReg = /^[A-za-z]{5,15}/g;
		//id값을 입력하지 않으면 다른곳으로 넘어갈 수 없다.
		$('#sampleId').focus();
		$('#sampleId').blur(()=>{
			if(!checkId.test($('#sampleId').val())){
				$('#idHelper').text('대문자 또는 소문자로 시작해 주세요');
				$('#sampleId').focus();
			}else{
				$('#idHelper').text('');
				$('#samplePw').focus();
			}
		});
		//정규표현식을 이용한 pw값 유효성 검사
		//영문,숫자 혼합하여 6~20자리 이내
		let checkPw = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
		
		$('#addMemberBtn').click(()=>{
			if(!checkPw.test($('#samplePw').val())){
				$('#pwHelper').text('영문,숫자 혼합하여 6~20자리 이내로 입력해주세요');
				$('#samplePw').focus();
			}else{
				$('#pwHelper').text('');
				$('#addMemberBtn').submit(); 
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
				<h1>회원추가</h1>
				<form action="/sample/addSample" method="post">
					<input type="text" name="sampleId" id="sampleId" class="form-control mb-2">
					<span id="idHelper"></span>
					<input type="password" name="samplePw" id="samplePw" class="form-control mb-2">
					<span id="pwHelper"></span>
					<input type="button" id="addMemberBtn" class="btn btn-primary" value="회원추가">
				</form>
			</div>
			<div class="col-md"></div>
		</div>
	</div>
</body>
</html>