<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="header.jsp"%>

<div class="container">
    <h1>${board.title}</h1>
    <span>${board.createDate}</span>
    <hr/>
    <p>
        ${board.content}
    </p>
    <hr/>
    <button class="btn-primary" value="목록" onclick="location.href='/board'">목록</button>
    <button class="btn-warning" value="수정" onclick="">수정</button>
</div>