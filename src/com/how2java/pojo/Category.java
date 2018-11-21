package com.how2java.pojo;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable{
	private int id;
    private String name;
    private List<Product> products;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
	public List<Product> getProducts() {
		return products;
	}

	public void setProduct(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name +"]";
	}
	
     
}