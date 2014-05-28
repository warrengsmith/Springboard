package com.wgs.virago;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<Book> bookList = this.bookDAO.findAllBooks();
		model.addAttribute("bookList", bookList);
		return "home";
	}
}
