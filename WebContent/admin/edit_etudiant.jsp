<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.tab.EtudiantTab"%>
<%@page import="com.entity.Etudiant"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Etudiant par filière</title>
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
					<%
						String filiere = request.getParameter("filiere");
						EtudiantTab dao2 = new EtudiantTab((Connection)DBConnect.getConn());
						%>
						<p class="fs-3 text-center">Liste des étudiants de <%=filiere %> </p>
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
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								
								List<Etudiant> list2 = dao2.getEtudiantbyFiliere(filiere);
								for (Etudiant d : list2) {
								%>
								<tr>
									<td><%=d.getNom_etudiant()%></td>
									<td><%=d.getPrenom_etudiant()%></td>
									<td><%=d.getDate_de_naissance_etudiant()%></td>
									<td><%=d.getMatricule_etudiant()%></td>
									<td><%=d.getEmail()%></td>
									<td><%=d.getNumero()%></td>
									<td><a href="modifier_etudiant.jsp?id_etudiant=<%=d.getId_etudiant() %>"
										class="btn btn-sm btn-primary">Modifier</a> 
										
										<a
										href="../deleteEtudiant?id_etudiant=<%=d.getId_etudiant()%>"
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