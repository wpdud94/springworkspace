package com.encore.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.rest.dao.BookDAO;
import com.encore.rest.vo.Book;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDAO bookDAO;
	
	
	@Override
	public List<Book> getAllBook() throws Exception {
		return bookDAO.getAllBook();
	}

	@Override
	public Book getBook(String isbn) throws Exception {
		return bookDAO.getBook(isbn);
	}

	@Override
	public boolean insertBook(Book book) throws Exception {
		return bookDAO.insertBook(book);
	}

	@Override
	public boolean updateBook(Book book) throws Exception {
		return bookDAO.updateBook(book);
	}

	@Override
	public boolean deleteBook(String isbn) throws Exception {
		return bookDAO.deleteBook(isbn);
	}
}
