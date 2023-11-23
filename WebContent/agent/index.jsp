<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.tab.AgentTab" %>
<%@page import="com.tab.ECUETab" %>
<%@page import="com.tab.UETab" %>
<%@page import="com.entity.UE" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>accueil agent</title>
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
	<c:if test="${empty AgentObj }">
		<c:redirect url="../agent_login.jsp"></c:redirect>
	</c:if>

	<%@include file="navbar.jsp"%>
	<p class="text-center fs-3">Tableau de bord d'un agent</p>
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
			<div class="col-md-3 offset-md-2">
		    <div class="card paint-card">
		        <div class="card-body text-center text-success" id="popup-trigger">
		            <i class="fas fa-chalkboard fa-3x"></i><br>
		            <p class="fs-4 text-center">
		            Filière  
		            </p>
		        </div>
		    </div>
		</div>


			<div class="col-md-3">
				<div class="card paint-card " data-bs-target="#exampleModal" id="spec">
					<div class="card-body text-center text-success">
						<i class="fas fa-book fa-3x"></i><br>
						<p class="fs-4 text-center">
							UE
						</p>
					</div>
				</div>
			</div>
		<div class="col-md-3">
				<div class="card paint-card " id="ecue">
					<div class="card-body text-center text-success">
						<i class="fas fa-clone fa-3x"></i><br>
						<p class="fs-4 text-center">
							ECUE
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
                <h5 class="modal-title" id="popup-form-label">Nouvelle Filière</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
             
                <form action="../addFiliere" method="post">
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Acronyme de la FIlière</label>
                        <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="M2 SIGL" name=acrofil>
                    </div>
                    
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Description</label>
                        <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="Système d'Information et Génie Logiciel" name="descfil">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Niveau</label>
                        <select name="niveaufil" required class="form-control">
									<option>--select--</option>
									<option>Licence 1</option>
									<option>Licence 2</option>
									<option>Licence 3</option>
									<option>Master 1</option>
									<option>Master 2</option>
						</select>
                    </div>
                    <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                <button type="submit" class="btn btn-primary">Créer</button>
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
                <h5 class="modal-title" id="popup-form-label">Ajouter Unité d'enseignement UE</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
             
                <form action="../addUE" method="post">
                    
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">CODE de l'UE</label>
                        <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="MTH2100" name="code_ue">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Intitulé de l'UE</label>
                        <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="Mathématique" name="intitule_ue">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Crédit de l'UE</label>
                        <input type="number" class="form-control" id="exampleFormControlInput2" placeholder="6" name="credit_ue">
                    </div>
                    <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                <button type="submit" class="btn btn-primary">Ajouter</button>
            		</div>
                </form>
            </div>
        </div>
    </div>
    </div>
    <div class="modal fade" id="pop" tabindex="-1" aria-labelledby="popup-form-label" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="popup-form-label">Ajouter Eléments constitutifs d'une unité d'enseignement ECUE</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
             
                <form action="../addECUE" method="post">
                    
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">CODE de l'ECUE</label>
                        <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="1MTH2100" name="code_ecue">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Intitulé de l'ECUE</label>
                        <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="Processus de Markov et files d'attente" name="intitule_ecue">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Crédit de l'ECUE</label>
                        <input type="number" class="form-control" id="exampleFormControlInput2" placeholder="2" name="credit_ecue">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">UE</label>
                        <select name="ue_ecue" required class="form-control">
                        <option>--select--</option>
                        <%UETab e = new UETab((Connection)DBConnect.getConn()); 
                        	List<UE> list = e.getAllUE();
							for (UE s : list) {
							%>
							<option><%=s.getCode_ue()%></option>
							<%
							}
							%>
									
									
						</select>
                    </div>
                    <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fermer</button>
                <button type="submit" class="btn btn-primary">Ajouter</button>
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
    document.getElementById('ecue').addEventListener('click', function () {
        // Affichez le pop-up en utilisant Bootstrap modal
        var myModal = new bootstrap.Modal(document.getElementById('pop'));
        myModal.show();
    });
</script>
</body>
</html>