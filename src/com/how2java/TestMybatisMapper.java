package com.how2java;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import Util.Util;

import com.how2java.mapper.CategoryMapper;
import com.how2java.mapper.OrderMapper;
import com.how2java.mapper.ProductMapper;
import com.how2java.pojo.Category;
import com.how2java.pojo.Order;
import com.how2java.pojo.OrderItem;
import com.how2java.pojo.Product;

public class TestMybatisMapper {
	
	public static void main(String[] args) throws IOException {
		
//		String resource="mybatis-config.xml";
//		InputStream inputStream=Resources.getResourceAsStream(resource);
//		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=Util.getSqlSessionFactory().openSession();
		
		
		
		CategoryMapper cmapper=session.getMapper(CategoryMapper.class);
		ProductMapper pmapper=session.getMapper(ProductMapper.class);
		OrderMapper omapper=session.getMapper(OrderMapper.class);
//		listAll(mapper);
//		listPWC(pmapper);
		//在延时加载的情况下没有执行连接的sql语句
		listOrder(omapper);
//		add(cmapper);
//		listPage(cmapper);
		  
//		session.commit();
//		session.close();
	}
	
	private static void update(CategoryMapper mapper){
		Category c=mapper.get(1);
		c.setName("我是新的Category");
		mapper.updateCategory(c);
		listAll(mapper);
	}
	private static void delete(CategoryMapper mapper){
		mapper.delete(1);
		listAll(mapper);
	}
	private static void add(CategoryMapper mapper){
		for(int i=1;i<100;i++){
			Category c=new Category();
			c.setName("Category"+i);
			mapper.addCategory(c);
			}
	
	}
	private static void get(CategoryMapper mapper){
		Category c=mapper.get(2);
		System.out.println(c);
	}
	private static void listAll(CategoryMapper mapper){
		List<Category> cs=mapper.list();
		for(Category c:cs){
			System.out.println(c.getName()+"  "+c.getProducts());
			List<Product> ps=c.getProducts();
			for(Product p:ps){
				System.out.println("\t"+p.getName());
			}
		}
	}
	private static void listPWC(ProductMapper pmapper){
		List<Product> ps=pmapper.list();
		for(Product p:ps){
			System.out.println(p+"\t的分类是：\t"+p.getCategory().getName());
		}
	}
	
	private static void listOrder(OrderMapper omapper){
		List<Order> os=omapper.listOrder();
		for(Order o:os){
			System.out.println(o.getCode());
			List<OrderItem> ois=o.getOrderItem();
			if(ois!=null){
			for(OrderItem oi:ois){
				System.out.println(oi.getProduct().getName()+"  "+oi.getProduct().getPrice()+oi.getNumber());
				
				}
			}
		}	
	}	
	private static void listPage(CategoryMapper mapper){
		List<Category> cs=mapper.listByPage(0, 5);
		for(Category c:cs){
			System.out.println(c);
		}
	}
	
	
}

