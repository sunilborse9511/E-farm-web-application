package com.entity;

public class ProductDtls {
	
	private int productId;
	private String productname;
	private String farmer;
	private String price;
	private String productcategory;
	private String status;
	private String photoName;
	private String email;
	public ProductDtls() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDtls(String productname, String farmer, String price, String productcategory, String status,
			String photoName, String email) {
		super();
		this.productname = productname;
		this.farmer = farmer;
		this.price = price;
		this.productcategory = productcategory;
		this.status = status;
		this.photoName = photoName;
		this.email = email;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getFarmer() {
		return farmer;
	}
	public void setFarmer(String farmer) {
		this.farmer = farmer;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getProductcategory() {
		return productcategory;
	}
	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "ProductDtls [productId=" + productId + ", productname=" + productname + ", farmer=" + farmer
				+ ", price=" + price + ", productcategory=" + productcategory + ", status=" + status + ", photoName="
				+ photoName + ", email=" + email + "]";
	}
	
	
	
}
