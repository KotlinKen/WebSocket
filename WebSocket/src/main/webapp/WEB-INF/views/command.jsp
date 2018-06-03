<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<form action="/kotlin/command" id="findForm" method="post">
      <input type="text" name="id" value ="aquare" />
      <input type="text" name="name" value ="김테스트" />
      <input type="password" name="pass" value ="1234" />
      <input type="email" name="email" value ="aquareness@gmail.com" />
 
        <div class="box btn">
            <button type="submit" class="btn join">
                <i class="fa fa-envelope"></i>
                이메일 전송
            </button>
        </div>
        <!-- // .box.btn -->
</form>


