package com.how2java;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.pojo.Category;
import com.how2java.pojo.Order;
import com.how2java.pojo.OrderItem;
import com.how2java.pojo.Product;

public class TestMybatis {
	public static void main(String[] args) throws IOException {
		String resource="mybatis-config.xml";//ָ���ļ�����
		InputStream inputstream=Resources.getResourceAsStream(resource);//��ָ�����ļ����н���
		//ͨ��SqlSessionFactory����һ����ָ�����ݿ����ӵĶ���
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputstream);
		//����һ���µ�session
		SqlSession session=sqlSessionFactory.openSession();
		SqlSession session2=sqlSessionFactory.openSession();
		//��֤2��������sessionFactory�ϣ�1��������session��
		Category c1 = session.selectOne("getCategory", 129);
        System.out.println(c1);
        Category c2 = session.selectOne("getCategory", 129);
        System.out.println(c2);
 
        session.commit();
        session.close();
         
       
        Category c3 = session2.selectOne("getCategory", 129);
        System.out.println(c3);    
        session2.commit();
        session2.close();
//		List<Category> cs=session.selectList("listCategory");
//		for(Category c:cs){
//			System.out.println(c.getName());
//		}
//		 
//		List<Product> ps=session.selectList("listProduct");
//		for(Product p:ps){
//			System.out.println(p.getName()+"  "+p.getPrice());
//		}
		/**
		 * ���Ԫ��
		 */
//		Category c=new Category();
//		c.setName("���ǵ�1��");
//		session.insert("addCategory",c);
		/**
		 * ɾ��Ԫ��
		 */
//		Category c2=new Category();
//		c2.setId(3);
//		session.delete("deleteCategory",c2);
//		ListAll(session);
//		
		/**
		 * ͨ��id���в���
//		 */
//		Category c3=session.selectOne("getCategory",3);
//		if(c3!=null){
//			System.out.println(c3.getName());
//		}else{
//			System.out.println("Ϊ��");
//		}
//		ListAll(session);
		/**
		 * �޸�����
		 */
//		Category c4=session.selectOne("getCategory",1);
//		c4.setName("�����޸ĵ�����");
//		session.update("updateCategory",c4);
//		
//		ListAll(session);
		
		
		/**
		 * ģ����ѯ
		 */
		
//		List<Category> cs=session.selectList("listCategoryByName","category");
//		for(Category s:cs){
//			System.out.println(s.getName());
//		}
//		session.commit();
//		session.close();
//	}
		/**
		 * ��������ѯ
		 */
//		Map<String,Object> pamas=new HashMap<String, Object>();
//		pamas.put("id", 2);
//		pamas.put("name", "��1");
//		List<Category> cs=session.selectList("listCategoryByIdAndName",pamas);
//		for(Category c:cs){
//			System.out.println(c.getName());}
//		}
//		
		/**
		 * һ�Զ�������ѯ
		 * @param session
		 */
//		List<Category> cs=session.selectList("listCategory");
//		for(Category c:cs){
//			System.out.println(c);
//			List<Product> ps=c.getProducts();
//			for(Product p:ps){
//				System.out.println("\t"+p);
//			}
//		}
		/**
		 * ���һ������ѯ
		 */
//		List<Product> ps=session.selectList("listProduct");
//		for(Product p:ps){
//			System.out.println(p+" ��Ӧ�ķ�����  \t "+p.getCategory());
//			
//		}
		/**
		 * ��Զ��ѯ
		 */
//		deleteOrderItem(session);
//		ListOrder(session);
//		deleteOrderAnd(session);
//		xmlway(session);
//		listbyhelp(session);
//		session.commit();
//		session.close();
	}
	private static void ListAll(SqlSession session){
		List<Category> cs=session.selectList("listCategory");
		for(Category s:cs){
			System.out.println(s.getName());
		}
	}
	private static void ListOrder(SqlSession session){
		List<Order> os=session.selectList("listOrder");
		for(Order o:os){
			System.out.println(o.getCode());
			List<OrderItem> ois=o.getOrderItem();
			for(OrderItem oi:ois){
				 System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(),oi.getProduct().getPrice(),oi.getNumber());
			}
		}
	}
	private static void addOrderItem(SqlSession session){
		Order o1=session.selectOne("getOrder",1);
		Product p6=session.selectOne("getProduct",6);
		OrderItem oi=new OrderItem();
		oi.setOrder(o1);
		oi.setProduct(p6);
		oi.setNumber(200);
		session.insert("addOrderItem", oi);
	}
	
	 private static void deleteOrderItem(SqlSession session) {
	        Order o1 = session.selectOne("getOrder",1);
	        Product p6 = session.selectOne("getProduct",6);
	        OrderItem oi = new OrderItem();
	        oi.setProduct(p6);
	        oi.setOrder(o1);
	        session.delete("deleteOrderItem", oi);     
	    }
	 private static void deleteOrderAnd(SqlSession session){
		 Order o1=session.selectOne("getOrder",1);
		 session.delete("deleteOrder", o1);
		 OrderItem oi=new OrderItem();
		 oi.setOrder(o1);
		 session.delete("deleteOrderItemWithOrder", oi);
		 
	 }
	 private static void xmlway(SqlSession session){
		 Map<String,Object> pamas=new HashMap<String, Object>();
		 pamas.put("start", 0);
		 pamas.put("count", 5);
		 List<Category> cs=session.selectList("listCategory",pamas);
		 for(Category c:cs){
			 System.out.println(c);
		 }
	 }
	 private static void listbyhelp(SqlSession session){
		 PageHelper.offsetPage(20, 5);
		 List<Category> cs=session.selectList("listCategory");
		 for(Category c:cs){
			 System.out.println(c); 
		 }
		PageInfo<Category> pageInfo=new PageInfo<Category>(cs);
		System.out.println("������"+pageInfo.getTotal());
		System.out.println(pageInfo);
		 
	 }
}

