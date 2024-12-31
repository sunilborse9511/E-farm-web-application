package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.ProductDtls;

public class ProductDAOImpl implements ProductDAO {

	private Connection conn;

	public ProductDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean addProducts(ProductDtls p) {

		boolean f = false;

		try {
			String sql = "insert into product_dtls(productname,farmer,price,productcategory,status,photo,email) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getProductname());
			ps.setString(2, p.getFarmer());
			ps.setString(3, p.getPrice());
			ps.setString(4, p.getProductcategory());
			ps.setString(5, p.getStatus());
			ps.setString(6, p.getPhotoName());
			ps.setString(7, p.getEmail());

			int i = ps.executeUpdate();

			if (i == 1) {

				f = true;
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return f;
	}

	@Override
	public List<ProductDtls> getAllProducts() {

		List<ProductDtls> list = new ArrayList<ProductDtls>();
		ProductDtls p = null;

		try {

			String sql = "select * from product_dtls";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				p = new ProductDtls();
				p.setProductId(rs.getInt(1));
				p.setProductname(rs.getString(2));
				p.setFarmer(rs.getString(3));
				p.setPrice(rs.getString(4));
				p.setProductcategory(rs.getString(5));
				p.setStatus(rs.getString(6));
				p.setPhotoName(rs.getString(7));
				p.setEmail(rs.getString(8));
				list.add(p);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public ProductDtls getProductById(int id) {
		ProductDtls p = null;

		try {

			String sql = "select * from product_dtls where productId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				p = new ProductDtls();
				p.setProductId(rs.getInt(1));
				p.setProductname(rs.getString(2));
				p.setFarmer(rs.getString(3));
				p.setPrice(rs.getString(4));
				p.setProductcategory(rs.getString(5));
				p.setStatus(rs.getString(6));
				p.setPhotoName(rs.getString(7));
				p.setEmail(rs.getString(8));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public boolean updateEditProducts(ProductDtls p) {
		boolean f = false;

		try {
			String sql = "update product_dtls set productname=?,farmer=?,price=?,status=? where productId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, p.getProductname());
			ps.setString(2, p.getFarmer());
			ps.setString(3, p.getPrice());
			ps.setString(4, p.getStatus());
			ps.setInt(5, p.getProductId());
			int i = ps.executeUpdate();
			if (i == 1) {

				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	@Override
	public boolean deleteProducts(int id) {
		boolean f = false;

		try {

			String sql = "delete from product_dtls where productId=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<ProductDtls> getNewProduct() {

		List<ProductDtls> list = new ArrayList<ProductDtls>();
		ProductDtls p = null;

		try {
			String sql = "select * from product_dtls where productcategory=? and status=? order by ProductId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "New");
			ps.setString(2, "Active");
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				p = new ProductDtls();
				p.setProductId(rs.getInt(1));
				p.setProductname(rs.getString(2));
				p.setFarmer(rs.getString(3));
				p.setPrice(rs.getString(4));
				p.setProductcategory(rs.getString(5));
				p.setStatus(rs.getString(6));
				p.setPhotoName(rs.getString(7));
				p.setEmail(rs.getString(8));
				list.add(p);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ProductDtls> getRecentProduct() {
		List<ProductDtls> list = new ArrayList<ProductDtls>();
		ProductDtls p = null;

		try {
			String sql = "select * from product_dtls where status=? order by ProductId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				p = new ProductDtls();
				p.setProductId(rs.getInt(1));
				p.setProductname(rs.getString(2));
				p.setFarmer(rs.getString(3));
				p.setPrice(rs.getString(4));
				p.setProductcategory(rs.getString(5));
				p.setStatus(rs.getString(6));
				p.setPhotoName(rs.getString(7));
				p.setEmail(rs.getString(8));
				list.add(p);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	
	public List<ProductDtls> getOldProduct() {
		
		List<ProductDtls> list = new ArrayList<ProductDtls>();
		ProductDtls p = null;

		try {
			String sql = "select * from product_dtls where productcategory=? and status=? order by ProductId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Old");
			ps.setString(2, "Active");
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				p = new ProductDtls();
				p.setProductId(rs.getInt(1));
				p.setProductname(rs.getString(2));
				p.setFarmer(rs.getString(3));
				p.setPrice(rs.getString(4));
				p.setProductcategory(rs.getString(5));
				p.setStatus(rs.getString(6));
				p.setPhotoName(rs.getString(7));
				p.setEmail(rs.getString(8));
				list.add(p);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ProductDtls> getAllRecentProduct() {
		List<ProductDtls> list = new ArrayList<ProductDtls>();
		ProductDtls p = null;

		try {
			String sql = "select * from product_dtls where status=? order by ProductId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				p = new ProductDtls();
				p.setProductId(rs.getInt(1));
				p.setProductname(rs.getString(2));
				p.setFarmer(rs.getString(3));
				p.setPrice(rs.getString(4));
				p.setProductcategory(rs.getString(5));
				p.setStatus(rs.getString(6));
				p.setPhotoName(rs.getString(7));
				p.setEmail(rs.getString(8));
				list.add(p);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ProductDtls> getAllNewProduct() {
		
		List<ProductDtls> list = new ArrayList<ProductDtls>();
		ProductDtls p = null;

		try {
			String sql = "select * from product_dtls where productcategory=? and status=? order by ProductId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "New");
			ps.setString(2, "Active");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				p = new ProductDtls();
				p.setProductId(rs.getInt(1));
				p.setProductname(rs.getString(2));
				p.setFarmer(rs.getString(3));
				p.setPrice(rs.getString(4));
				p.setProductcategory(rs.getString(5));
				p.setStatus(rs.getString(6));
				p.setPhotoName(rs.getString(7));
				p.setEmail(rs.getString(8));
				list.add(p);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ProductDtls> getAllOldProduct() {
		List<ProductDtls> list = new ArrayList<ProductDtls>();
		ProductDtls p = null;

		try {
			String sql = "select * from product_dtls where productcategory=? and status=? order by ProductId DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Old");
			ps.setString(2, "Active");
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				p = new ProductDtls();
				p.setProductId(rs.getInt(1));
				p.setProductname(rs.getString(2));
				p.setFarmer(rs.getString(3));
				p.setPrice(rs.getString(4));
				p.setProductcategory(rs.getString(5));
				p.setStatus(rs.getString(6));
				p.setPhotoName(rs.getString(7));
				p.setEmail(rs.getString(8));
				list.add(p);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	

}
