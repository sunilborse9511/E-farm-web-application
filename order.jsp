<%@page import="com.entity.Product_Order"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.ProductOrderImpl"%>
<%@page import="com.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order page</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">

	
	<%@include file="all_component/navbar.jsp"%>
	
	<c:if test="${empty userobj }">
	<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	
	<div class="container p-1">
		<h3 class="text-center text-primary">Your Order</h3>
		<table class="table table-hover mt-3">
			<thead class="bg-primary text-white">
				<tr>
					<th scope="col">Order Id</th>
					<th scope="col">Name</th>
					<th scope="col">Product Name</th>
					<th scope="col">Brand</th>
					<th scope="col">Price</th>
					<th scope="col">Payment Type</th>
					<th scope="col">Delivery status</th>
				</tr>
			</thead>
			<tbody>
				<%
			
				User u = (User)session.getAttribute("userobj");
			    ProductOrderImpl dao = new ProductOrderImpl(DBConnect.getConn());
			    List<Product_Order> plist = dao.getProduct(u.getEmail());
				
			    for(Product_Order p:plist){%>

				<tr>
					<th scope="row"><%=p.getOrderId() %></th>
					<td><%=p.getUserName()%></td>
					<td><%=p.getProductName() %></td>
					<td><%=p.getBrand() %></td>
					<td><%=p.getPrice() %></td>
					<td><%=p.getPaymentType() %></td>
					<td>delivered</td>
				</tr>

				<%}
					
			%>




			</tbody>

		</table>
	</div>
</body>
</html>