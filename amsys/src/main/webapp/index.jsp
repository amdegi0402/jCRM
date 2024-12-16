<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:set var="pageTitle" value="ホーム"/>
<%@ include file="views/common/header.jsp" %>

<div class="card">
    <h2 class="card-title">jCRM へようこそ</h2>
    <p class="mb-3">顧客管理システムです。以下のメニューから操作を選択してください。</p>
    
    <div class="row">
        <div class="col mb-3">
            <div class="card">
                <h3 class="card-title">顧客管理</h3>
                <p class="mb-2">顧客情報の登録・編集・削除を行います。</p>
                <a href="views/customers/list.jsp" class="btn btn-primary">顧客一覧へ</a>
            </div>
        </div>
        
        <div class="col mb-3">
            <div class="card">
                <h3 class="card-title">タスク管理</h3>
                <p class="mb-2">タスクの登録・管理を行います。</p>
                <a href="views/tasks/list.jsp" class="btn btn-primary">タスク一覧へ</a>
            </div>
        </div>
    </div>
</div>

<%@ include file="views/common/footer.jsp" %>