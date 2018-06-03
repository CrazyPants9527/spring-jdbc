package net.study.spring.jdbc.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import net.study.spring.jdbc.bean.Book;
import net.study.spring.jdbc.dao.BookDao;
@Repository
public class BookDaoImpl extends JdbcDaoSupport implements BookDao{

	@Autowired
	public void ThisSetDataSource(DataSource dataSource){
		this.setDataSource(dataSource);
	}
	public void save(Book book) {
		String sql ="INSERT INTO book (bookname,price,author) VALUES (?,?,?);";
		// TODO Auto-generated method stub
		this.getJdbcTemplate().update(sql,book.getBookName(),book.getPrice(),book.getAuthor());
	}

	public void update(Book book) {
		// TODO Auto-generated method stub
		String sql="UpDATE book set bookname=?,price=?,author=? WHERE bookid=?";
		this.getJdbcTemplate().update(sql,book.getBookName(),book.getPrice(),book.getAuthor(),book.getBookId());
	}

	public Book get(int id) {
		String sql = "select * from book where bookid = ? ";
		Book newbook = this.getJdbcTemplate().queryForObject(sql, new Object[] { id }, new RowMapper<Book>() {
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				Book book = new Book();
				book.setBookId(rs.getInt("bookid"));
				book.setBookName(rs.getString("bookname"));
				book.setPrice(rs.getDouble("price"));
				book.setAuthor(rs.getString("author"));
				return book;
			}
		});
		return newbook;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM book WHERE bookid=?";
		this.getJdbcTemplate().update(sql,Long.valueOf(id));
	}

	public List<Book> list() {
		String sql = "select * from book ";
		List<Book> books = this.getJdbcTemplate().query(sql, new RowMapper<Book>() {
			public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
				Book book = new Book();
				book.setBookId(rs.getInt("bookid"));
				book.setBookName(rs.getString("bookname"));
				book.setPrice(rs.getDouble("price"));
				book.setAuthor(rs.getString("author"));
				return book;
			}
		});
		return books;
	}

	
}
