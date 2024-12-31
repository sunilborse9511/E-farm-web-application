package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.ProductDAOImpl;
import com.DB.DBConnect;
import com.entity.ProductDtls;

@WebServlet("/editproducts")

public class EditProductsServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String productname = req.getParameter("pname");
			String farmer = req.getParameter("farmer");
			String price = req.getParameter("price");
			String status = req.getParameter("status");
			
			ProductDtls p = new ProductDtls();
			p.setProductId(id);
			p.setProductname(productname);
			p.setFarmer(farmer);
			p.setPrice(price);
			p.setStatus(status);
			
			ProductDAOImpl dao = new ProductDAOImpl(DBConnect.getConn());
			boolean f=dao.updateEditProducts(p);
			
			HttpSession session = req.getSession();
			
			
			if(f) {
					session.setAttribute("succMsg", "Product Updated Successfully...");
					resp.sendRedirect("admin/all_products.jsp");
			}else {
				session.setAttribute("failedMsg", "Something Wrong On Server...");
				resp.sendRedirect("admin/all_products.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
