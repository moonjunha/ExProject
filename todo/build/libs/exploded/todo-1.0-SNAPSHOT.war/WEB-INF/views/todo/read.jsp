<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>afdasdfasdf    </title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<div class="card-body">
    <div class="input-group mb-3">
        <span class="input-group-text">TNO</span>
        <input type="text" name="tno" class="form-control"
               value=<c:out value="${dto.tno}"></c:out> readonly>
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">Title</span>
        <input type="text" name="title" class="form-control"
               value='<c:out value="${dto.title}"></c:out>' readonly>
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">DueDate</span>
        <input type="date" name="dueDate" class="form-control"
               value=<c:out value="${dto.dueDate}"></c:out> readonly>
    </div>
    <div class="input-group mb-3">
        <span class="input-group-text">Writer</span>
        <input type="text" name="writer" class="form-control"
               value=<c:out value="${dto.writer}"></c:out> readonly>
    </div>
    <div class="form-check">
        <label class="form-check-label" > Finished &nbsp;
        </label>
        <input class="form-check-input" type="checkbox" name="finished"
        ${dto.finished?"checked":""} disabled >
    </div>
    <div class="my-4">
        <div class="float-end">
            <button type="button" class="btn btn-primary">Modify</button>
            <button type="button" class="btn btn-secondary">List</button>
        </div>
    </div>
    </div>

<script>
    document.querySelector(".btn-primary").addEventListener("click", function(e){
        self.location = "/todo/modify?tno="+${dto.tno}
    },false)
    document.querySelector(".btn-secondary").addEventListener("click", function(e){
        self.location = "/todo/list";
    },false)
</script>

</body>
</html>
