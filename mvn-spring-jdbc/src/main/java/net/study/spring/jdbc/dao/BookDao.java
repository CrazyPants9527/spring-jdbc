package net.study.spring.jdbc.dao;

import java.util.List;

import net.study.spring.jdbc.bean.Book;

public interface BookDao {

	public void save(Book book);

	public void update(Book book);

	public Book get(int id);

	public void delete(int id);

	public List<Book> list();
}
