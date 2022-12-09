<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="header.jsp"%>
<div>
    <div class="container">
        <form id="newForm" method="post" action="/board/save">
            <label for="title">제목</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요"/>
            <label for="content">내용</label>
            <textarea class="form-control" id="content" name="content" placeholder="내용을 입력하세요"></textarea>
            <input type="submit" value="저장" class="btn-primary"/>
            <input type="button" value="취소" class="btn-warning" onclick="history.go(-1)"/>
        </form>
    </div>
</div>

<script>
    function encodeValues() {
        $("#title").val(encodeURIComponent($("#title").val()));
        $("#content").val(encodeURIComponent($("#content").val()));
    }
</script>