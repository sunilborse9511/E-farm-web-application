package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DAO.ProductDAOImpl;
import com.DB.DBConnect;
import com.entity.Cart;
import com.entity.ProductDtls;

@WebServlet("/cart")

public class CartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int bid = Integer.parseInt(req.getParameter("bid"));
			int uid = Integer.parseInt(req.getParameter("uid"));
			
			ProductDAOImpl dao = new ProductDAOImpl(DBConnect.getConn());
			
			ProductDtls p = dao.getProductById(bid);
			
			Cart c = new Cart();
			c.setBid(bid);
			c.setUserId(uid);
			c.setProductName(p.getProductname());
			c.setBrand(p.getFarmer());
			c.setPrice(Double.parseDouble(p.getPrice()));
			c.setTotalPrice(Double.parseDouble(p.getPrice()));
			
			CartDAOImpl dao2 = new CartDAOImpl(DBConnect.getConn());
			boolean f = dao2.addCart(c);
			HttpSession session = req.getSession();
			
			if(f) {
				session.setAttribute("addCart", "Product Added Successfully");
				resp.sendRedirect("all_new_product.jsp");
			}else {
				session.setAttribute("failed", "not added cart");
				resp.sendRedirect("all_new_product.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
		
	
}
