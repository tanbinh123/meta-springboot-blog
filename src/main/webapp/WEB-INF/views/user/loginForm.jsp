<%--
  Created by IntelliJ IDEA.
  User: taek
  Date: 2021/12/14
  Time: 7:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../layout/header.jsp" %>

<div class="container">
    <form action="/action_page.php">
        <div class="form-group">
            <label for="username">username:</label>
            <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
        </div>
        <div class="form-group form-check">
            <label class="form-check-label">
                <input class="form-check-input" type="checkbox" name="remember"> Remember me
            </label>
        </div>
        <button type="submit" class="btn btn-primary">로그인</button>
    </form>
</div>

<%@ include file="../layout/footer.jsp" %>

