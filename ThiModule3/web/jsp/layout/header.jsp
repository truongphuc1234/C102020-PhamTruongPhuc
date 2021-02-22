    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <nav class="navbar navbar-expand-lg navbar-light bg-light d-flex flex-column align-items-stretch px-lg-5
        sticky-top">
        <div class="container-fluid d-flex flex-row justify-content-lg-between">
        <div class="navbar-brand mx-auto mx-lg-2">
        <a href="<c:url value="/home"/>">
        <img src="../../img/logo.png" alt="" style="height: 100px; width: auto;"/>
        </a>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>
        <h1 class="d-none d-lg-inline">Furama Resort</h1>
        <span class="d-none d-lg-inline">Phạm Trường Phúc</span>
        </div>
        <div class="collapse navbar-collapse d-lg-flex justify-content-lg-between" id="navbarSupportedContent">
        <ul class="navbar-nav ml-0">
        <li class="nav-item mx-2">
        <a class="nav-link" href="<c:url value="/home"/>">Home<span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item mx-2">
        <a class="nav-link" href="<c:url value="/home?actionUser=employee"/>">Employee<span
        class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item mx-2">
        <a class="nav-link" href="<c:url value="/home?actionUser=customer"/>">Customer<span
        class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item mx-2">
        <a class="nav-link" href="<c:url value="/home?actionUser=service"/>">Order<span
        class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item mx-2">
        <a class="nav-link" href="<c:url value="/home?actionUser=product"/>">Product<span
        class="sr-only">(current)</span></a>
        </li>
        </ul>
        <form method="get" action="/${requestScope['search']}" class="form-inline my-2 my-lg-0 mr-0">
            <input name="actionUser" value="search" hidden>
            <div class="input-group">
                <div class="input-group-prepend">
                    <button class ="btn btn-outline-success" type="submit">
                        <span class=" material-icons" id="basic-addon1">search</span>
                    </button>
                </div>
                <input class="form-control" placeholder="Search" aria-label="Search" type="search" name="name">
            </div>
        </form>
        </div>
        </nav>
