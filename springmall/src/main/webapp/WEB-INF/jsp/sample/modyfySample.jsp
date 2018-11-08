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
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md"></div>
			<div class="col-md">
				<h1>회원수정</h1>
				<form action="/sample/modyfySample" method="post"">
					<input value="${ sample.sampleNo }" type="text" name="sampleNo" class="form-control mb-2" readonly>
					<input value="${ sample.sampleId }" type="text" name="sampleId" class="form-control mb-2">
					<input value="${ sample.samplePw }" type="password" name="samplePw" class="form-control mb-2">
					<div><input type="submit" value="회원수정" class="btn btn-primary"></div>
				</form>
			</div>
			<div class="col-md"></div>
		</div>
	</div>
</body>
</html>