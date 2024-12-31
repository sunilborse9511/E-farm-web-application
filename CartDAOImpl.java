package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Cart;
import com.entity.ProductDtls;

public class CartDAOImpl implements CartDAO {

	private Connection conn;
	
	public CartDAOImpl(Connection conn) {
		
		this.conn=conn;
	}
	
	public boolean addCart(Cart c) {
		
		boolean f= false;
		
		try {
			String sql = ("insert into cart(bid,uid,productName,brand,price,total_price) values(?,?,?,?,?,?)");
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getBid());
			ps.setInt(2, c.getUserId());
			ps.setString(3, c.getProductName());
			ps.setString(4, c.getBrand());
			ps.setDouble(5, c.getPrice());
			ps.setDouble(6, c.getTotalPrice());
			
			int i=ps.executeUpdate();
			if(i==1) {
				
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

	@Override
	public List<Cart> getProductByUser(int userId) {
		
		List<Cart> list = new ArrayList<Cart>();
		Cart c = null;
		double totalPrice= 0;
		
		try {
			String sql = "select * from cart where uid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				c=new Cart();
				c.setCid(rs.getInt(1));
				c.setBid(rs.getInt(2));
				c.setUserId(rs.getInt(3));
				c.setProductName(rs.getString(4));
				c.setBrand(rs.getString(5));
				c.setPrice(rs.getDouble(6));
				
				totalPrice = totalPrice+rs.getDouble(7);
				c.setTotalPrice(totalPrice);
				
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public boolean deleteProduct(int bid, int uid, int cid ) {
		
		boolean f = false;
		
		
		try {
			
			String sql = "delete from cart where bid=? and uid=? and cid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.setInt(2, uid);
			ps.setInt(3, cid);
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
		
	
		
}
