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
<!-- jquery CDN -->
<script type="text/javascript">
	$(document).ready(()=>{
		 
		//ID를 입력하지 않으면 다른곳으로 넘어가지 않는다.
	    $('#sampleId').focus();
		//FOCUS를 푸는 BLUR
	    $('#sampleId').blur(()=>{
	        if(!isNaN($('#sampleId').val())){
	            $('#idHelper').text('ID는 문자만 입력하세요');
	            $('#sampleId').focus();
	        }else if($('#sampleId').val().length <2){
	            $('#idHelper').text('ID는 두글자이상 입력하세요');
	            $('#sampleId').focus();
	        }else{
	            $('#idHelper').text('');
	            $('#samplePw').focus();
	        }
	    });
		//버튼을 누르면 마지막 입력데이터의 유효성 검사를 하고, 일치하면 FORM을 SUBMIT시켜준다.
	    $('#addMemberBtn').click(()=>{
	    	if(isNaN($('#samplePw').val())){
	            $('#pwHelper').text('PW는 숫자만 입력하세요');
	            $('#samplePw').focus();
	        }else if($('#samplePw').val().length <2){
	            $('#pwHelper').text('PW는 두글자이상 입력하세요');
	            $('#samplePw').focus();
	        }else{
                $('#pwHelper').text('');
                $('#addMemberForm').submit();   
            }
        });
	});
	
<!-- 정규표현식을 이용한 유효성 검사 
	$(document).ready(()=>{
		//정규표현식을 이용한 id값 유효성 검사
		//대문자 또는 소문자 또는 숫자로 시작하는 2~15자리 이하의 아이디 (숫자로 시작하는 아이디x)
		var idReg = /^[A-za-z]{2,15}/g;
		
		//정규표현식을 이용한 pw값 유효성 검사
		//영문,숫자 혼합하여 6~20자리 이내
		var checkPw = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
		
		//버튼을 클릭하면 아이디,비밀번호 유효성 검사
		$('#addMemberBtn').click(()=>{
			if(!idReg.test($('#sampleId').val())){
				$('#idHelper').text('대문자 또는 소문자로 시작해 주세요');
				$('#sampleId').focus();
			}else{
				$('#idHelper').text('');
				if(!checkPw.test($('#samplePw').val())){
					$('#pwHelper').text('영문,숫자 혼합하여 6~20자리 이내로 입력해주세요');
					$('#samplePw').focus();
				}else{
					$('#idHelper').text('');
					$('#addMemberForm').submit();
				}
			}
		});
	});
-->
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md"></div>
			<div class="col-md">
				<h1>회원추가</h1>
				<form action="/sample/addSample" method="post" id="addMemberForm">
					<input type="text" name="sampleId" id="sampleId" class="form-control mb-2">
					<span id="idHelper"></span>
					<input type="password" name="samplePw" id="samplePw" class="form-control mb-2">
					<span id="pwHelper"></span>
					<input type="button" value="회원추가" id="addMemberBtn">
				</form>
			</div>
			<div class="col-md"></div>
		</div>
	</div>
	
</body>
</html>