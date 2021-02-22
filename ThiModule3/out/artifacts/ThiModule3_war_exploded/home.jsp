<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Eczar&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.23/css/dataTables.bootstrap4.min.css">
</head>
<style>
    * {
        font-family: "Helvetica", sans-serif;
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    h1 {
        font-family: 'Eczar', serif;
        font-size: 50px;
    }

</style>
<body>
<jsp:include page="jsp/layout/header.jsp"/>
<div class="row container-fluid mx-0 px-0 min-vh-100">
    <div class="col-0 col-lg-2 bg-light align-self-start align-self-lg-stretch">
        <jsp:include page="jsp/layout/left_nav.jsp"/>
    </div>
    <div class="col-0 col-lg-10">
        <c:if test="${requestScope['content'] != null}">
            <jsp:include page="${requestScope['content']}"/>
        </c:if>
    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLabel">Delete Employee</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Delete confirm?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <form method="post" id="form-delete">
                    <input id="id" name="id" hidden/>
                    <input id="action_user" name="actionUser" value="delete" hidden/>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="jsp/layout/footer.jsp"/>
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.10.23/js/dataTables.bootstrap4.min.js" crossorigin="anonymous"></script>
<script>
    $(document).ready(function () {
        $('#deleteModal').on('show.bs.modal', function (event) {
            var button = $(event.relatedTarget);
            var id = button.data('id');
            var action = button.data('action');
            var modal = $(this);
            modal.find('#form-delete').attr("action",action);
            modal.find('#id').val(id);
        });
        $('#table').dataTable( {
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5
        });
    });
</script>
</body>
</html>


