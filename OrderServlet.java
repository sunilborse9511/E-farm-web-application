package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAOImpl;
import com.DAO.ProductOrderImpl;
import com.DB.DBConnect;
import com.entity.Cart;
import com.entity.Product_Order;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			HttpSession session = req.getSession();
			int id = Integer.parseInt(req.getParameter("id"));

			String name = req.getParameter("username");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String address = req.getParameter("address");
			String landmark = req.getParameter("landmark");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String zip = req.getParameter("zip");
			String paymentType = req.getParameter("payment");

			String fullAdd = address + "," + landmark + "," + city + "," + state + "," + zip;

			// System.out.println(name+" "+email+" "+phone+" "+fullAdd+" "+paymentType);

			CartDAOImpl dao = new CartDAOImpl(DBConnect.getConn());
			List<Cart> plist = dao.getProductByUser(id);
			
			if(plist.isEmpty()) {
				session.setAttribute("failedMsg", "Add Item");
				resp.sendRedirect("checkout.jsp");
				
			}else {
				
				ProductOrderImpl dao2 = new ProductOrderImpl(DBConnect.getConn());

				Product_Order o = null;

				ArrayList<Product_Order> orderlist = new ArrayList<Product_Order>();
				Random r = new Random();

				for (Cart c : plist) {
					o = new Product_Order();
					// System.out.println(c.getProductName()+" "+c.getBrand()+" "+c.getPrice());
					o.setOrderId("PRODUCT-ORD-00" + r.nextInt(1000));
					o.setUserName(name);
					o.setEmail(email);
					o.setPhno(phno);
					o.setFullAdd(fullAdd);
					o.setProductName(c.getProductName());
					o.setBrand(c.getBrand());
					o.setPrice(c.getPrice() + "");
					o.setPaymentType(paymentType);
					orderlist.add(o);

				}

				if ("noselect".equals(paymentType)) {
					session.setAttribute("failedMsg", "Choose Your Payment Method");
					resp.sendRedirect("checkout.jsp");
				} else {

					boolean f = dao2.saveOrder(orderlist);

					if (f) {
						
						resp.sendRedirect("order_success.jsp");

					} else {

						System.out.println("Order failed");
					}
				}

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
