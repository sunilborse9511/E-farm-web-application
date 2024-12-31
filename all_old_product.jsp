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
<title>All Old product</title>
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
			ProductDAOImpl dao = new ProductDAOImpl(DBConnect.getConn());
			List<ProductDtls> list = dao.getAllOldProduct();
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
							<a href="" class="btn btn-danger btn-sm ml-3">Add Cart</a> <a
								href="" class="btn btn-success btn-sm ml-1">View details</a> <a
								href="" class="btn btn-danger btn-sm ml-1"><%=p.getPrice()%><i
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