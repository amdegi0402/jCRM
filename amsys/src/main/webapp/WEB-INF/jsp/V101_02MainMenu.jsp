<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="pageTitle" value="メインメニュー" />
<%@ include file="header.jsp" %>

<div class="card">
    <div class="card-header">
        <h2>メインメニュー</h2>
    </div>
    <div class="card-body">
        <div class="grid grid-2">
            <div class="card">
                <h3>得意先管理</h3>
                <div class="grid grid-2">
                    <form action="./amsysFC" method="post">
                        <button type="submit" name="buttonId" value="V201_01" class="btn btn-primary">得意先検索</button>
                    </form>
                    <form action="./amsysFC" method="post">
                        <button type="submit" name="buttonId" value="V202_01" class="btn btn-primary">新規登録</button>
                    </form>
                </div>
            </div>
            <div class="card">
                <h3>受注管理</h3>
                <div class="grid grid-2">
                    <form action="./amsysFC" method="post">
                        <button type="submit" name="buttonId" value="V301_01" class="btn btn-primary">月別受注集計</button>
                    </form>
                    <form action="./amsysFC" method="post">
                        <button type="submit" name="buttonId" value="V302_01" class="btn btn-primary">年間受注集計</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>