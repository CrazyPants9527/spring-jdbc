package net.study.spring.jdbc;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.study.spring.jdbc.bean.Book;
import net.study.spring.jdbc.dao.BookDao;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-jdbc.xml" })
public class BookTest {

	@Autowired
	private BookDao bookdao;
	
	@Test
	public void saveTest(){
		Book book =new Book();
		book.setBookName("C++");
		book.setPrice(53.7);
		book.setAuthor("又是我写的");
		bookdao.save(book);
	}
	
	@Test
	public void updateTest(){
		Book book = new Book();
		book.setBookName("spring-boot");
		book.setPrice(133.2);
		book.setAuthor("li4");
		book.setBookId(3);
		bookdao.update(book);
		System.out.println("数据已经成功更新："+bookdao.get(book.getBookId()));
	}
	
	@Test
	public void getTest(){
		
		Book book= bookdao.get(2);
		System.out.println(book);
	}
	
	@Test
	public void deleteTest(){
		int id=5;
		bookdao.delete(id);
		System.out.println("book表里的bookID为"+id+"数据已成功删除");
	}
	
	@Test
	public void getlistTest(){
		List<Book> list= bookdao.list();
		for (Book book : list) {
			System.out.println(book);
		}
	}
}
