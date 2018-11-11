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

--이벤트를 강제 종료해서 유효성 검사
	$(document).ready(function(){
		$('form').submit(function(event){
			if($('#sampleId').val().length == 0){
				$('#idHelper').text('유효성검사 실패');
				//이벤트 중단
				event.preventDefault();
			}else{
				$('#idHelper').text('유효성검사 성공');
				event.preventDefault();
			}
		});
	});
--리턴값을 이용해 이벤트 강제종료
$(document).ready(()=>{
	$('#addMemberForm').submit(()=>{
		if($('#sampleId').val().length == 0){
			$('#idHelper').text('유효성검사 실패');
			//false를 보내는게
			//event.preventDefault()를 
			return false;
		}else{
			$('#idHelper').text('유효성검사 성공');
			return true;
		}
	});
});
-->
<script type="text/javascript">
$(document).ready(()=>{
	$('#addMemberForm').submit(()=>{
		if($('#sampleId').val().length == 0){
			$('#idHelper').text('유효성검사 실패');
			//false를 보내는게
			//event.preventDefault()를 
			return false;
		}else{
			$('#idHelper').text('유효성검사 성공');
			return true;
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
				<form action="/sample/addSample" method="post" onsubmit="return check">
					<input type="text" name="sampleId" id="sampleId" class="form-control mb-2">
					<span id="idHelper"></span>
					<input type="password" name="samplePw" id="samplePw" class="form-control mb-2">
					<span id="pwHelper"></span>
					<input type="submit" value="회원추가" id="addMemberBtn">
				</form>
			</div>
			<div class="col-md"></div>
		</div>
	</div>
	
</body>
</html>