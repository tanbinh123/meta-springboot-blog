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
    <form>
        <div class="form-group">
            <label for="username">username:</label>
            <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
        </div>
    </form>
    <button id="btn-save" class="btn btn-primary">회원가입완료</button>
</div>

<script type="text/javascript" src="/blog/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>

