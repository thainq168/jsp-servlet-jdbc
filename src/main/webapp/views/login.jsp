<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Đăng nhập</title>
    
  </head>
  <body>
  
    <div class="wrapper fadeInDown">
      <div id="formContent">
        <!-- Tabs Titles -->
        
        <c:if test="${not empty message }">
        	<div class="alert alert-${alert}" role="alert">
  				${message}
			</div>
        </c:if>

        <!-- Login Form -->
        <form action="/dang-nhap" method="post">
          <input
            type="text"
            id="userName"
            class="fadeIn second"
            name="userName"
            placeholder="Tên đăng nhập"s
          />
          <input
            type="text"
            id="password"
            class="fadeIn third"
            name="password"
            placeholder="Mật khẩu"
          />
          <input type="hidden" value="login" name="action"/>
          <input type="submit" class="fadeIn fourth" value="Đăng nhập" />
        </form>

        <!-- Remind Passowrd -->
        <div id="formFooter">
          <a class="underlineHover" href="#">Quên mật khẩu?</a>
        </div>
      </div>
    </div>
  </body>
</html>
