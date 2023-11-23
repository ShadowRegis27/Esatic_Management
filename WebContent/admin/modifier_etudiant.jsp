<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.entity.Grade"%>
<%@page import="com.tab.EtudiantTab"%>
<%@page import="com.entity.Etudiant"%>
<%@page import="com.entity.Filiere"%>
<%@page import="com.tab.FiliereTab"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modifier un étudiant</title>
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
	<c:if test="${empty adminObj }">
		<c:redirect url="../admin_login.jsp"></c:redirect>
	</c:if>
	
	
	<div class="container-fluid p-3">
		<div class="row">
		<%
						int id = Integer.parseInt(request.getParameter("id_etudiant"));
						EtudiantTab dao2 = new EtudiantTab((Connection)DBConnect.getConn());
						Etudiant d = dao2.getEtudiantbyId(id);
						%>
			<div class="col-md-5 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Modifier les informations d'étudiant</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form action="../updateEtudiant" method="post">
							<div class="mb-3">
								<label class="form-label">Nom</label> <input type="text"
									required name="nom_etudiant" value="<%=d.getNom_etudiant() %>" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Prénoms</label> <input type="text"
									required name="prenom_etudiant" value="<%=d.getPrenom_etudiant() %>" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Date de Naissance</label> <input type="date"
									required name="date_de_naissance_etudiant" value="<%=d.getDate_de_naissance_etudiant() %>" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Matricule</label> <input required
									name="matricule_etudiant" type="text" value="<%=d.getNom_etudiant() %>" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Mot de passe</label> <input required
									name="mot_de_passe_etudiant" type="password" value="<%=d.getMot_de_passe_etudiant() %>" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Filière</label> <select name="filiere"
									required class="form-control">
									<option><%=d.getFiliere() %></option>

									<%
									FiliereTab dao = new FiliereTab((Connection)DBConnect.getConn());
									List<Filiere> list = dao.getAllFiliere();
									for (Filiere s : list) {
									%>
									<option><%=s.getAcrofil()%></option>
									<%
									}
									%>


								</select>
							</div>
							
							<div class="mb-3">
								<label class="form-label">Email</label> <input type="text"
									required name="email" value="<%=d.getEmail() %>" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Numéro de téléphone</label> <input type="text"
									required name="numero"  value="<%=d.getNumero() %>"class="form-control">
							</div>
							<input type="hidden" name="id_etudiant" value="<%=d.getId_etudiant() %>">
							<button type="submit" class="btn btn-primary">Modifier</button>
						</form>
					</div>
				</div>
			</div>


			
		</div>
	</div>
</body>
</html>