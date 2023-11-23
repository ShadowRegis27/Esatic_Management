<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<style type="text/css">
	.text-success {
    color: #0d81c0!important;
}
</style>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp"><img src="../img/Logo.png" class="d-block w-100" alt="..."
					height="50px" width="50px"></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link" href="index.jsp">ACCUEIL</a></li>
				<li class="nav-item"><a class="nav-link" href="agent.jsp">AGENT</a></li>
				<li class="nav-item"><a class="nav-link" href="edit_agent.jsp">VOIR AGENTS</a></li>
				<li class="nav-item"><a class="nav-link" href="enseignant.jsp">ENSEIGNANT</a></li>
				<li class="nav-item"><a class="nav-link" href="edit_enseignant.jsp">VOIR ENSEIGNANTS</a></li>
				<li class="nav-item"><a class="nav-link" href="etudiant.jsp">ETUDIANT</a></li>
				<li class="nav-item"><a class="nav-link" href="filiere_etudiant.jsp">VOIR ETUDIANTS</a></li>
			</ul>

			<form class="d-flex">
				<div class="dropdown">
					<button class="btn btn-light dropdown-toggle" type="button"
						id="dropdownMenuButton1" data-bs-toggle="dropdown"
						aria-expanded="false">
						<i class="fas fa-user-circle"></i> Administrateur
					</button>
					<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton1">
						<li><a class="dropdown-item" href="../adminLogout">Deconnexion</a></li>
					</ul>
				</div>
			</form>
		</div>
	</div>
</nav>
