<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.tab.AgentTab" %>
<%@page import="com.tab.UETab" %>
<%@page import="com.entity.UE" %>
<%@page import="com.entity.Filiere"%>
<%@page import="com.tab.FiliereTab"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nouvelle Maquette</title>
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
	<c:if test="${empty AgentObj }">
		<c:redirect url="../agent_login.jsp"></c:redirect>
	</c:if>
	
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-5 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Nouvelle Maquette</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form action="../addMaquette" method="post">
					<div class="mb-3">
								<label class="form-label">Filière</label> <select name="filiere_ma"
									required class="form-control">
									<option>--select--</option>

									<%
									FiliereTab dao = new FiliereTab((Connection)DBConnect.getConn());
									List<Filiere> list1 = dao.getAllFiliere();
									for (Filiere s1 : list1) {
									%>
									<option><%=s1.getAcrofil()%></option>
									<%
									}
									%>


								</select>
							</div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">Semestre</label>
                        <select name="semestre" required class="form-control">
									<option>--select--</option>
									<option>Semestre 1</option>
									<option>Semestre 2</option>
						</select>
                    </div>
						<div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">UE</label>
                        <select name="ue_1" required class="form-control">
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
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">UE</label>
                        <select name="ue_2" required class="form-control">
                        <option>--select--</option>
                        <%
							for (UE s : list) {
							%>
							<option><%=s.getCode_ue()%></option>
							<%
							}
							%>
									
									
						</select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">UE</label>
                        <select name="ue_3" required class="form-control">
                        <option>--select--</option>
                        <%
							for (UE s : list) {
							%>
							<option><%=s.getCode_ue()%></option>
							<%
							}
							%>
									
									
						</select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">UE</label>
                        <select name="ue_4" required class="form-control">
                        <option>--select--</option>
                        <%
							for (UE s : list) {
							%>
							<option><%=s.getCode_ue()%></option>
							<%
							}
							%>
									
									
						</select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">UE</label>
                        <select name="ue_5" required class="form-control">
                        <option>--select--</option>
                        <%
							for (UE s : list) {
							%>
							<option><%=s.getCode_ue()%></option>
							<%
							}
							%>
									
									
						</select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">UE</label>
                        <select name="ue_6" required class="form-control">
                        <option>--select--</option>
                        <%
							for (UE s : list) {
							%>
							<option><%=s.getCode_ue()%></option>
							<%
							}
							%>
									
									
						</select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">UE</label>
                        <select name="ue_7" required class="form-control">
                        <option>--select--</option>
                        <%
							for (UE s : list) {
							%>
							<option><%=s.getCode_ue()%></option>
							<%
							}
							%>
									
									
						</select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">UE</label>
                        <select name="ue_8" required class="form-control">
                        <option>--select--</option>
                        <%
							for (UE s : list) {
							%>
							<option><%=s.getCode_ue()%></option>
							<%
							}
							%>
									
									
						</select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">UE</label>
                        <select name="ue_9" required class="form-control">
                        <option>--select--</option>
                        <%
							for (UE s : list) {
							%>
							<option><%=s.getCode_ue()%></option>
							<%
							}
							%>
									
									
						</select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">UE</label>
                        <select name="ue_10" required class="form-control">
                        <option>--select--</option>
                        <%
							for (UE s : list) {
							%>
							<option><%=s.getCode_ue()%></option>
							<%
							}
							%>
									
									
						</select>
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