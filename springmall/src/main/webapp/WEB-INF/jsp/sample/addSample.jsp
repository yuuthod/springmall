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
	#idHelper, #pwHelper, #fileHelper{
		color: red;
	}
</style>
<!-- jquery CDN -->
<!--
정규표현식
/^  <== 줄의 처음
$/  <== 줄의 끝 

[a-z]영어 소문자 a~z까지
[A-Z]영어 대문자 A~Z까지
[0-9]숫자 0~9까지
[A-Za-z0-9]영어 대문자, 소문자, 숫자 전부

id유효성 검사 해석
[A-Z-az]{1}   <== 줄의 처음에오는 {1} 한글자는 [A-Za-z](영어 대문자, 소문자)만 가능하고
[A-Za-z0-9]{3,19}   <== [A-Za-z0-9](영어 대문자, 소문자, 숫자 전부)가 3~19자가 (위에 첫글자 1자 포함 4~20자)
[A-Za-z0-9_]  <== _(언더바)도 입력가능

pw유효성 검사 해석
(?=.{6,20}) <== 6~20자 이내
(?=.*[0-9]) <== 하나이상의 숫자
(?=.*[a-zA-Z]) <== 하나이상의 대문자,소문자

+추가
(?=.*?[#?!@$%^&*-]) <== 하나 이상의 특수 문자
-->
<script type="text/javascript">
$(document).ready(()=>{
	//정규표현식을 이용한 id값 유효성 검사
	//대문자 또는 소문자로 시작하는 2~15자리 이내 (숫자로 시작 x)
	var idReg = /^[A-Za-z]{1}[A-Za-z0-9]{3,19}$/;
	
	//정규표현식을 이용한 pw값 유효성 검사
	//영문,숫자 혼합하여 6~20자리 이내
	var checkPw = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
	
	//버튼을 클릭하면 아이디,비밀번호 유효성 검사
	$('#addBtn').click(()=>{
		if(!idReg.test($('#sampleId').val())){
			$('#idHelper').text('다시 입력하세요');
			$('#sampleId').focus();
			$('#pwHelper').text('');
		}else if(!checkPw.test($('#samplePw').val())){
			$('#idHelper').text('');
			$('#pwHelper').text('영문,숫자 혼합하여 6~20자리 이내로 입력해주세요');
			$('#samplePw').focus();
		}else if(!$('#multipartfile').val()){
			$('#pwHelper').text('');
			$('#fileHelper').text('파일을 업로드 해주세요');
		}else{
			$('#fileHelper').text('');
			$('#addMemberForm').submit();
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
				<form action="/sample/addSample" method="post" enctype="multipart/form-data" id="addMemberForm">
					<div>
						ID : <input type="text" name="sampleId" id="sampleId" class="form-control mb-2">
						<span id="idHelper"></span>
					</div>
					<div>
						PW : <input type="password" name="samplePw" id="samplePw" class="form-control mb-2">
						<span id="pwHelper"></span>
					</div>
					<div>
						FILE : <input type="file" name="multipartfile" id="multipartfile" multiple="multiple">
						<span id="fileHelper"></span>
					</div>
					<button type="button" id="addBtn">SAMPLE 추가</button>
				</form>
			</div>
			<div class="col-md"></div>
		</div>
	</div>
	
</body>
</html>