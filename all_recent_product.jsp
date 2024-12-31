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
<title>All Recent product</title>
<%@include file="all_component/allCss.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #fcf7f7;
}
</style>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-3">

			<%
			ProductDAOImpl dao2 = new ProductDAOImpl(DBConnect.getConn());
			List<ProductDtls> list2 = dao2.getAllRecentProduct();
			for (ProductDtls p : list2) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho mt-3">
					<div class="card-body text-center">
						<img alt="" src="product/<%=p.getPhotoName()%>"
							style="width: 140px; height: 180px" class="img-thumblin">
						<p><%=p.getProductname()%></p>
						<p>
							Brand:<%=p.getFarmer()%></p>

						<%
						if (p.getProductcategory().equals("Old")) {
						%>
						<p>
							Categories:<%=p.getProductcategory()%></p>
						<div class="row">

							<!-- <a href="view_product.jsp" class="btn btn-success btn-sm ml-5">View details</a> --> <a
								href="" class="btn btn-success btn-sm ml-4"><%=p.getPrice()%><i
								class="fa-solid fa-indian-rupee-sign ml-1"></i></a>


						</div>


						<%
						} else {
						%>
						<p>
							Categories:<%=p.getProductcategory()%></p>
						<div class="row">
							<!-- <a href="view_product.jsp" class="btn btn-success btn-sm ml-3">View details</a>   --> <a
								href="" class="btn btn-success btn-sm ml-5"><%=p.getPrice()%><i
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
	</div>


</body>
</html>