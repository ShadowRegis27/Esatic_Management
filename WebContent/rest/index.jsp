<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.tab.PlatTab" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>accueil restaurateur</title>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</style>
<%@include file="../component/allcss.jsp"%>
</head>
<body>
	<c:if test="${empty restObj }">
		<c:redirect url="../restaurateur_login.jsp"></c:redirect>
	</c:if>

	<%@include file="navbar.jsp"%>

	<p class="text-center fs-3">Tableau de bord du Restaurateur</p>
	<c:if test="${not empty errorMsg}">
			<p class="fs-3 text-center text-danger">${errorMsg}</p>
			<c:remove var="errorMsg" scope="session" />
		</c:if>
		<c:if test="${not empty succMsg}">
			<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
			<c:remove var="succMsg" scope="session" />
		</c:if>
<% 
PlatTab p = new PlatTab((Connection)DBConnect.getConn()) ;
%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-2">
		    <div class="card paint-card">
		        <div class="card-body text-center text-success" id="popup-trigger">
		            <i class="fa fa-cutlery fa-3x"></i><br>
		            <p class="fs-4 text-center">
		            Plat  <%=p.nbPlat() %>
		            </p>
		        </div>
		    </div>
		</div>


			<div class="col-md-4">
				<div class="card paint-card " data-bs-target="#exampleModal" >
					<div class="card-body text-center text-success">
						<i class="fas fa-clipboard-list fa-3x"></i><br>
						<p class="fs-4 text-center">
							Commande 0
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
                <h5 class="modal-title" id="popup-form-label">Formulaire</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
             
                <form action="../addPlat" method="post">
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Nom du plat</label>
                        <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="riz-gras avec pâte" name="nom_plat">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlTextarea1" class="form-label">Description du plat</label>
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="description_plat"></textarea>
                    </div>
                    <div class="mb-3">
								<label class="form-label">Heure du service</label> <select name="service"
									required class="form-control">
									<option>--select--</option>

									
									<option>Midi 12h00 - 14h00</option>
									<option>Soir 17h30 - 19h30</option>

								</select>
							</div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Prix du plat</label>
                        <input type="number" class="form-control" id="exampleFormControlInput2" placeholder="200" name="prix_plat">
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
</script>
</body>
</html>