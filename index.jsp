

<%@page import="com.entity.User"%>
<%@page import="com.entity.ProductDtls"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.ProductDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>E-farm: index</title>
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
.back-img {
	background: url("img/barley.jpg");
	height: 50vh;
	width: 100%;
	background-size: cover;
	background-repeat: no repeat;
}

.crd-ho:hover {
	background-color: #fcf7f7;
}
</style>
</head>
<body style="background-color: #f7f7f7">

	<%
	User u = (User) session.getAttribute("userobj");
	%>
	<%@include file="all_component/navbar.jsp"%>

	<div class="container-fluid back-img">
		<h2 class="text-center text-danger">E-farm Website</h2>
	</div>



	<!-- start recent products -->


	<div class="container">
		<h3 class="text-center">Recent products</h3>
		<div class="row">
			<%
			ProductDAOImpl dao2 = new ProductDAOImpl(DBConnect.getConn());
			List<ProductDtls> list2 = dao2.getRecentProduct();
			for (ProductDtls p : list2) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body text-center">
						<img alt="" src="product/<%=p.getPhotoName()%>"
							style="width: 150px; height: 200px" class="img-thumblin">
						<p><%=p.getProductname()%></p>
						<p>
							Brand:<%=p.getFarmer()%></p>

						<%
						if (p.getProductcategory().equals("Old")) {
						%>
						<p>
							Categories:<%=p.getProductcategory()%></p>
						<div class="row">


							<a href="view_product.jsp?pid=<%=p.getProductId()%>"
								class="btn btn-success btn-sm ml-5">View details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=p.getPrice()%><i
								class="fa-solid fa-indian-rupee-sign ml-1"></i></a>


						</div>


						<%
						} else {
						%>
						<p>
							Categories:<%=p.getProductcategory()%></p>
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
								class="btn btn-danger btn-sm ml-3">Add Cart</a>
							<%
							}
							%>
							    <a href="view_product.jsp?pid=<%=p.getProductId()%>"
								class="btn btn-success btn-sm ml-1">View details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=p.getPrice()%><i
								class="fa-solid fa-indian-rupee-sign ml-1"></i></a>


						</div>
						<%
						}
						%>





					</div>
				</div>

			</div>
			<%
			}
			%>




		</div>

		<div class="text-center mt-1">
			<a href="all_recent_product.jsp"
				class="btn btn-danger btn-sm text-white">View all</a>
		</div>
	</div>

	<!-- End recent products -->

	<hr>

	<!-- start New products -->


	<div class="container">
		<h3 class="text-center">New products</h3>
		<div class="row">

			<%
			ProductDAOImpl dao = new ProductDAOImpl(DBConnect.getConn());
			List<ProductDtls> list = dao.getNewProduct();
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
								class="btn btn-danger btn-sm ml-3">Add Cart</a>
							<%
							}
							%>


							<a href="view_product.jsp?pid=<%=p.getProductId()%>"
								class="btn btn-success btn-sm ml-1">View details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=p.getPrice()%><i
								class="fa-solid fa-indian-rupee-sign ml-1"></i></a>


						</div>

					</div>
				</div>
			</div>
			<%
			}
			%>
		</div>

		<div class="text-center mt-1">
			<a href="all_new_product.jsp"
				class="btn btn-danger btn-sm text-white">View all</a>
		</div>
	</div>

	<!-- End New products -->

	<hr>

	<!-- start Old products -->


	<div class="container">
		<h3 class="text-center">Old products</h3>
		<div class="row">
			<%
			ProductDAOImpl dao3 = new ProductDAOImpl(DBConnect.getConn());
			List<ProductDtls> list3 = dao3.getOldProduct();
			for (ProductDtls p : list3) {
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
							Categories:<%=p.getProductcategory()%></p>

						<div class="row">
							<a href="view_product.jsp?pid=<%=p.getProductId()%>"
								class="btn btn-success btn-sm ml-5">View details</a> <a href=""
								class="btn btn-danger btn-sm ml-1"><%=p.getPrice()%><i
								class="fa-solid fa-indian-rupee-sign ml-1"></i></a>




						</div>
					</div>
				</div>

			</div>
			<%
			}
			%>









		</div>

		<div class="text-center mt-1">
			<a href="all_old_product.jsp"
				class="btn btn-danger btn-sm text-white">View all</a>
		</div>

	</div>

	<!-- End Old products -->

	<%@include file="all_component/footer.jsp"%>
</body>
</html>