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

import com.how2java.pojo.Product;

public class TestMybatis2 {

	public static void main(String[] args) throws IOException {
		String resource="mybatis-config.xml";
		InputStream inputstream=Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession session=sqlSessionFactory.openSession();
		
		System.out.println("查询所有：");
		List<Product> ps=session.selectList("listProduct");
		for(Product p:ps){
			System.out.println(p);
		}
		
		System.out.println("模糊查询：");
		Map<String,Object> pamas=new HashMap<String, Object>();
		pamas.put("name","a");
		List<Product> ps2=session.selectList("listProductByName",pamas);
		for(Product p:ps2){
			System.out.println(p);
		}
		session.commit();
		session.close();
	}

}
