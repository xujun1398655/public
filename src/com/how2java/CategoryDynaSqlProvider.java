package com.how2java;

import org.apache.ibatis.jdbc.SQL;

/**
 * sql类，用以进行动态sql生成
 * @author Administrator
 *
 */
public class CategoryDynaSqlProvider {
	    public String list() {
	         return new SQL()
	                 .SELECT("*")
	                 .FROM("category_")
	                 .toString();
	         
	    }
	    public String get() {
	        return new SQL()
	                .SELECT("*")
	                .FROM("category_")
	                .WHERE("id=#{id}")
	                .toString();
	    }
	     
	    public String add(){
	        return new SQL()
	                .INSERT_INTO("category_")
	                .VALUES("name", "#{name}")
	                .toString();
	    }
	    public String update(){
	        return new SQL()
	                .UPDATE("category_")
	                .SET("name=#{name}")
	                .WHERE("id=#{id}")
	                .toString();
	    }
	    public String delete(){
	        return new SQL()
	                .DELETE_FROM("category_")
	                .WHERE("id=#{id}")
	                .toString();
	    }
	     
	}
//查询方式与以前一样
//@InsertProvider(type=CategoryDynaSqlProvider.class,method="add") 
//public int add(Category category); 
//    
//@DeleteProvider(type=CategoryDynaSqlProvider.class,method="delete")
//public void delete(int id); 
//    
//@SelectProvider(type=CategoryDynaSqlProvider.class,method="get") 
//public Category get(int id); 
//  
//@UpdateProvider(type=CategoryDynaSqlProvider.class,method="update") 
//public int update(Category category);  
//    
//@SelectProvider(type=CategoryDynaSqlProvider.class,method="list")     
//public List<Category> list(); 

