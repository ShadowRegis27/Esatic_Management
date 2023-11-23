<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<style type="text/css">
	.bg-success {
    background-color: #0d81c0!important;
}
.paint-card {
    box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
    margin-top:100px;
}
</style>
<nav class="navbar navbar-expand-lg navbar-dark bg-success">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp"><img src="img/Logo.png" class="d-block w-100" alt="..."
					height="50px" width="50px"></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <c:if test="${empty userObj }">
                    <div class="d-flex">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="admin_login.jsp"><i class="fas fa-sign-in-alt"></i> ADMINISTRATEUR</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="agent_login.jsp">AGENT</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="enseignant_login.jsp">ENSEIGNANT</a></li>
                       <li class="nav-item"><a class="nav-link active" aria-current="page" href="restaurateur_login.jsp">RESTAURATEUR</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="etudiant_login.jsp">ETUDIANT</a></li>
                    </div>
                </c:if>
            </ul>
        </div>
    </div>
</nav>