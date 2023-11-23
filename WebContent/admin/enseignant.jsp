<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.entity.Grade"%>
<%@page import="com.tab.GradeTab"%>
<%@page import="com.entity.Specialite"%>
<%@page import="com.tab.SpecialiteTab"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter des enseignants </title>
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
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-5 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Ajouter Enseignant</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form action="../addEnseignant" method="post">
							<div class="mb-3">
								<label class="form-label">Nom</label> <input type="text"
									required name="nom_enseignant" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Prénoms</label> <input type="text"
									required name="prenom_enseignant" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Date de Naissance</label> <input type="date"
									required name="date_de_naissance_enseignant" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Matricule</label> <input required
									name="matricule_enseignant" type="text" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Mot de passe</label> <input required
									name="mot_de_passe_enseignant" type="password" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Grade</label> <select name="grade"
									required class="form-control">
									<option>--select--</option>

									<%
									GradeTab dao = new GradeTab((Connection)DBConnect.getConn());
									List<Grade> list = dao.allgrade();
									for (Grade s : list) {
									%>
									<option><%=s.getDesignation_grade()%></option>
									<%
									}
									%>


								</select>
							</div>
							<div class="mb-3">
								<label class="form-label">Spécialité</label> <select name="specialite"
									required class="form-control">
									<option>--select--</option>

									<%
									SpecialiteTab da = new SpecialiteTab((Connection)DBConnect.getConn());
									List<Specialite> li = da.allSpec();
									for (Specialite s : li) {
									%>
									<option><%=s.getDesspec() %></option>
									<%
									}
									%>


								</select>
							</div>
							<div class="mb-3">
								<label class="form-label">Email</label> <input type="text"
									required name="email" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Numéro de téléphone</label> <input type="text"
									required name="numero" class="form-control">
							</div>
							
							<button type="submit" class="btn btn-primary">Valider</button>
						</form>
					</div>
				</div>
			</div>


			
		</div>
	</div>
</body>
</html>