<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.tab.PlatTab" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil administrateur</title>
</head>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</style>
<%@include file="../component/allcss.jsp"%>

<body>
	<c:if test="${empty adminObj }">
		<c:redirect url="../admin_login.jsp"></c:redirect>
	</c:if>

	<%@include file="navbar.jsp"%>
	<p class="text-center fs-3">Tableau de bord de l'administrateur</p>
	<c:if test="${not empty errorMsg}">
			<p class="fs-3 text-center text-danger">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>
		<c:if test="${not empty succMsg}">
			<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
			<c:remove var="succMsg" scope="session" />
		</c:if>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-2">
		    <div class="card paint-card">
		        <div class="card-body text-center text-success" id="popup-trigger">
		            <i class="fas fa-graduation-cap fa-3x"></i><br>
		            <p class="fs-4 text-center">
		            Grade  
		            </p>
		        </div>
		    </div>
		</div>


			<div class="col-md-4">
				<div class="card paint-card " data-bs-target="#exampleModal" id="spec">
					<div class="card-body text-center text-success">
						<i class="fas fa-book-open fa-3x"></i><br>
						<p class="fs-4 text-center">
							Spécialité
						</p>
					</div>
				</div>
			</div>

		</div>
	</div>
	

<div class="modal fade" id="popup-form" tabindex="-1" aria-labelledby="popup-form-label" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="popup-form-label">Ajouter Grade</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
             
                <form action="../addGrade" method="post">
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Acronyme</label>
                        <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Dr" name=acronyme>
                    </div>
                    
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Designation</label>
                        <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="Docteur" name="designation_grade">
                    </div>
                    <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                <button type="submit" class="btn btn-primary">Envoyer</button>
            		</div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="popup" tabindex="-1" aria-labelledby="popup-form-label" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="popup-form-label">Ajouter Spécialité</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
             
                <form action="../addSpecialite" method="post">
                    
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Spécialité</label>
                        <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="Mathématique" name="desspec">
                    </div>
                    <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                <button type="submit" class="btn btn-primary">Envoyer</button>
            		</div>
                </form>
            </div>
        </div>
    </div>
</div>
	<script>
    // Attachez un gestionnaire d'événements au clic sur l'élément avec l'ID "popup-trigger"
    document.getElementById('popup-trigger').addEventListener('click', function () {
        // Affichez le pop-up en utilisant Bootstrap modal
        var myModal = new bootstrap.Modal(document.getElementById('popup-form'));
        myModal.show();
    });
    document.getElementById('spec').addEventListener('click', function () {
        // Affichez le pop-up en utilisant Bootstrap modal
        var myModal = new bootstrap.Modal(document.getElementById('popup'));
        myModal.show();
    });
</script>
</body>
</html>