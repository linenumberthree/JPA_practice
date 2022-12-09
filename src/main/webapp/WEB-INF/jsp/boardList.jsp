<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="header.jsp"%>

<script>
    $(document).ready(function(){
        let list = '${boardList}';
        let grid = new tui.Grid({
            el: document.getElementById('list'),
            data: JSON.parse(list),
            contentType: 'application/json',
            scrollX: false,
            scrollY: false,
            minRowHeight: 50,
            header: {
                height: 50
            },
            columns: [
                {
                    header: 'id',
                    name: 'id',
                    width: '50'
                },
                {
                    header: '제목',
                    name: 'title',
                    width: '200'
                },
                {
                    header: '작성일',
                    name: 'createDate',
                    width: '50'
                }
            ]
        })
    })
</script>

<div id="list">

</div>