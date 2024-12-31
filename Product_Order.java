package com.entity;

public class Product_Order {
		
		private int id;
		private String orderId;
		private String userName;
		private String email;
		private String phno;
		private String productName;
		private String Brand;
		private String price;
		private String fullAdd;
		private String paymentType;
		
		public Product_Order() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		

		public String getProductName() {
			return productName;
		}



		public void setProductName(String productName) {
			this.productName = productName;
		}



		public String getBrand() {
			return Brand;
		}



		public void setBrand(String brand) {
			Brand = brand;
		}



		public String getPrice() {
			return price;
		}



		public void setPrice(String price) {
			this.price = price;
		}



		public String getOrderId() {
			return orderId;
		}



		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}



		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhno() {
			return phno;
		}

		public void setPhno(String phno) {
			this.phno = phno;
		}

		public String getFullAdd() {
			return fullAdd;
		}

		public void setFullAdd(String fullAdd) {
			this.fullAdd = fullAdd;
		}

		public String getPaymentType() {
			return paymentType;
		}

		public void setPaymentType(String paymentType) {
			this.paymentType = paymentType;
		}

		@Override
		public String toString() {
			return "Product_Order [id=" + id + ", userName=" + userName + ", email=" + email + ", phno=" + phno
					+ ", fullAdd=" + fullAdd + ", paymentType=" + paymentType + "]";
		}
		
		
		
}
