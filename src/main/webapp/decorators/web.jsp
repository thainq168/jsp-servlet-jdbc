<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html lang="en">

<head>

  <title><dec:title default="Trang chủ" /></title>

  <!-- Bootstrap core CSS -->
  <link href="<c:url value='/template/web/vendor/bootstrap/css/bootstrap.min.css '/>" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="<c:url value='/template/web/css/shop-homepage.css' />" rel="stylesheet">

</head>

<body>

  <!-- header -->
  <%@include file="/common/web/header.jsp" %>

  <div class="container">
  	<dec:body />
  </div>

  <!-- footer -->
  <%@include file="/common/web/footer.jsp" %>

  <!-- Bootstrap core JavaScript -->
  <script src="<c:url value='/template/web/vendor/jquery/jquery.min.js' />"></script>
  <script src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>

</body>

</html>
