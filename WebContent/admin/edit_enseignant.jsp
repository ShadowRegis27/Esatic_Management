<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.entity.Enseignant"%>
<%@page import="com.tab.EnseignantTab"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editer enseignant</title>
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
	<%@include file="navbar.jsp"%>
	<div class="container-fluid p-3">
		<div class="row">


			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Details Enseignants</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Nom</th>
									<th scope="col">Prénoms</th>
									<th scope="col">Date de Naissance</th>
									<th scope="col">Matricule</th>
									<th scope="col">Email</th>
									<th scope="col">Numéro Mobile</th>
									<th scope="col">Grade</th>
									<th scope="col">Spécialité</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								EnseignantTab dao2 = new EnseignantTab((Connection)DBConnect.getConn());
								List<Enseignant> list2 = dao2.getAllEnseignant();
								for (Enseignant d : list2) {
								%>
								<tr>
									<td><%=d.getNom_enseignant()%></td>
									<td><%=d.getPrenom_enseignant()%></td>
									<td><%=d.getDate_de_naissance_enseignant()%></td>
									<td><%=d.getMatricule_enseignant()%></td>
									<td><%=d.getEmail()%></td>
									<td><%=d.getNumero()%></td>
									<td><%=d.getGrade()%></td>
									<td><%=d.getSpecialite()%></td>
									<td><a href="modifier_enseignant.jsp?id_enseignant=<%=d.getId_enseignant() %>"
										class="btn btn-sm btn-primary">Modifier</a> 
										
										<a
										href="../deleteEnseignant?id_enseignant=<%=d.getId_enseignant()%>"
										class="btn btn-sm btn-danger">Supprimer</a></td>
								</tr>
								<%
								}
								%>



							</tbody>
						</table>

					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>