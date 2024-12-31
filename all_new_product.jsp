<%@page import="com.entity.User"%>
<%@page import="com.entity.ProductDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.ProductDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All New product</title>
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #fcf7f7;
}

#toast {
	min-width: 300px;
	position: fixed;
	bottom: 30px;
	left: 50%;
	margin-left: -125px;
	background: #333;
	padding: 10px;
	color: white;
	text-align: center;
	z-index: 1;
	font-size: 18px;
	visibility: hidden;
	box-shadow: 0px 0px 100px #000;
}

#toast.display {
	visibility: visible;
	animation: fadeIn 0.5, fadeout 0.5s 2.5s;
}

@
keyframes fadeIn {from { bottom:0;
	opacity: 0;
}

to {
	bottom: 30px;
	opacity: 1;
}

}
@
keyframes fadeout {from { bottom:30px;
	opacity: 1;
}

to {
	bottom: 0;
	opacity: 0;
}
}
</style>
</head>
<body>

	<%
	User u = (User) session.getAttribute("userobj");
	%>

	<c:if test="${not empty addCart }">
		<div id="toast">${addCart }</div>

		<script type="text/javascript">
	
	showToast();
	function showToast(content){
		
		$('#toast').addClass("display");
		$('#toast').html(content);
		setTimeout(()=>{
			
			$('#toast').removeClass("display")
		
		},2000)
	}
	
	</script>
	<c:remove var="addCart" scope="session"/>

	</c:if>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-3">

			<%
			ProductDAOImpl dao = new ProductDAOImpl(DBConnect.getConn());
			List<ProductDtls> list = dao.getAllNewProduct();
			for (ProductDtls p : list) {
			%>


			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="product/<%=p.getPhotoName()%>"
							style="width: 150px; height: 200px" class="img-thumblin">
						<p><%=p.getProductname()%></p>
						<p>
							Brand:<%=p.getFarmer()%></p>
						<p>
							Categories:<%=p.getProductcategory()%>
						</p>

						<div class="row">	
							
							<%
							if (u == null) {
							%>

							<a href="login.jsp" class="btn btn-danger btn-sm ml-3">Add
								Cart</a>
							<%
							} else {
							%>
							<a href="cart?bid=<%=p.getProductId()%>&&uid=<%=u.getId()%>"
								class="btn btn-success btn-sm ml-5">Add Cart</a>
							<%
							}
							%> 
							
							
								
							<a
								href="" class="btn btn-danger btn-sm ml-2"><%=p.getPrice()%><i
								class="fa-solid fa-indian-rupee-sign ml-1"></i></a>


						</div>

					</div>
				</div>
			</div>
			<%
			}
			%>

		</div>
	</div>


</body>
</html>