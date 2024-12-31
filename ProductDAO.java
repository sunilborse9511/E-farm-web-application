package com.DAO;

import java.util.List;

import com.entity.ProductDtls;

public interface ProductDAO {
	
	public boolean addProducts(ProductDtls p); 
	
	public List<ProductDtls> getAllProducts();
	
	public ProductDtls getProductById(int id);
	
	public boolean updateEditProducts(ProductDtls p);
	
	public boolean deleteProducts(int id);
	
	public List<ProductDtls> getNewProduct();
	
	public  List<ProductDtls> getRecentProduct();
	
	public List<ProductDtls> getOldProduct();
	
	public List<ProductDtls> getAllRecentProduct();
	
	public List<ProductDtls> getAllNewProduct();
	
	public List<ProductDtls> getAllOldProduct();
	
	
	
}
