<%@page import="com.entity.Agent"%>
<%@page import="com.tab.AgentTab"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modifier un agent</title>
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

			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Modifier les informations d'un Agent</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>

						<%
						int id = Integer.parseInt(request.getParameter("id_agent"));
						AgentTab dao2 = new AgentTab((Connection)DBConnect.getConn());
						Agent d = dao2.getAgentById(id);
						%>


						<form action="../updateAgent" method="post">
							<div class="mb-3">
								<label class="form-label">Nom</label> <input type="text"
									required name="nom_agent" class="form-control"
									value="<%=d.getNom_agent()%>">
							</div>
							<div class="mb-3">
								<label class="form-label">Prénoms</label> <input type="text"
									required name="prenom_agent" class="form-control"
									value="<%=d.getPrenom_agent()%>">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Date de Naissance</label> <input type="date"
									value="<%=d.getDate_de_naissance_agent()%>" required name="date_de_naissance_agent"
									class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Matricule</label> <input required
									value="<%=d.getMatricule_agent()%>" name="matricule_agent"
									type="text" class="form-control">
							</div>
							
							<div class="mb-3">
								<label class="form-label">Mot de passe</label> <input required
									value="<%=d.getMot_de_passe_agent()%>" name="mot_de_passe_agent" type="text"
									class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Email</label> <input type="text"
									value="<%=d.getEmail()%>" required name="email"
									class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Numéro de téléphone</label> <input type="text"
									value="<%=d.getNumero()%>" required name="numero"
									class="form-control">
							</div>
							<input type="hidden" name="id_agent" value="<%=d.getId_agent()%>">

							<button type="submit" class="btn btn-primary col-md-12">Modifier</button>
						</form>
					</div>
				</div>
			</div>




		</div>
	</div>
</body>
</html>