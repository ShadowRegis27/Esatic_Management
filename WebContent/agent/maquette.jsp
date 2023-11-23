<%@page import="com.mysql.jdbc.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Maquette</title>
</head>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</style>
<%@include file="../component/allcss.jsp"%>
<c:if test="${empty AgentObj }">
		<c:redirect url="../agent_login.jsp"></c:redirect>
	</c:if>

	<%@include file="navbar.jsp"%>
	<p class="text-center fs-3">Maquette</p>
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
			
				<div class="col-md-4 offset-md-2">
		    <div class="card paint-card">
		    <a href="creer_maquette.jsp">
		        <div class="card-body text-center text-success" id="popup-trigger">
		            <i class="fas fa-chalkboard fa-3x"></i><br>
		            <p class="fs-4 text-center">
		            Créer Maquette  
		            </p>
		        </div>
		        	</a>
		    </div>
			</div>
		


			<div class="col-md-4">
				<div class="card paint-card " data-bs-target="#exampleModal" id="spec">
					<a href="editer_maquette.jsp">
						<div class="card-body text-center text-success">
						<i class="fas fa-book fa-3x"></i><br>
						<p class="fs-4 text-center">
							Editer Maquette
						</p>
					</div>
					</a>
				</div>
			</div>
		
		</div>
	</div>
	
<body>

</body>
</html>