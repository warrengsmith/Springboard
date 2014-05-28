package com.wgs.virago;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.usg.ssg1.common.dao.BookDAO;
import com.usg.ssg1.common.dto.Book;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private BookDAO bookDAO;
		
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/allBooks", method = RequestMethod.GET)
	public String home(Model model) {
		List<Book> bookList = this.bookDAO.findAllBooks();
		model.addAttribute("bookList", bookList);
		model.addAttribute("title", "The full list of books available");
		return "bookList";
	}
	
	@RequestMapping(value = "/bookSearch", method = RequestMethod.GET)
	public String bookSearch(@RequestParam("bookArg") String bookPart, Model model) {
		List<Book> bookList = this.bookDAO.searchByTitle(bookPart);
		model.addAttribute("bookList", bookList);
		model.addAttribute("title", "The list of books that match search phrase \"" + bookPart + "\"");
		return "bookList";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
    public String searchForm(Model model) {
        model.addAttribute("book", new Book());
        return "search";
    }
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchSubmit(@ModelAttribute Book book, Model model) {
		List<Book> bookList = this.bookDAO.searchByTitle(book.getTitle());
		model.addAttribute("bookList", bookList);
		if (book.getTitle().isEmpty()) {
			model.addAttribute("title", "The full list of books available");
		} else {
			model.addAttribute("title", "The list of books that match search phrase \"" + book.getTitle() + "\"");
		}
		return "bookList";
	}
}
