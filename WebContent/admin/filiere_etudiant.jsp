<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.tab.EtudiantTab"%>
<%@page import="com.entity.Etudiant"%>
<%@page import="com.entity.Filiere"%>
<%@page import="com.tab.FiliereTab"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Filiere etudiant</title>
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


			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Filiere</p>
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
									<th scope="col">Acronyme</th>
									<th scope="col">Description</th>
									<th scope="col">Niveau</th>
									<th scope="col">Nombre d'étudiants</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								FiliereTab dao2 = new FiliereTab((Connection)DBConnect.getConn());
								List<Filiere> list2 = dao2.getAllFiliere();
								for (Filiere d : list2) {
								%>
								<tr>
									<td><%=d.getAcrofil()%></td>
									<td><%=d.getDescfil()%></td>
									<td><%=d.getNiveaufil()%></td>
									<td><%=dao2.nbEtduiantbyFiliere(d.getAcrofil())%></td>
									<td><a href="edit_etudiant.jsp?filiere=<%=d.getAcrofil() %>"
										class="btn btn-sm btn-primary">Voir les étudiants</a> 
										
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