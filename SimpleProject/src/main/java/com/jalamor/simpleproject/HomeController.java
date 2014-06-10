package com.jalamor.simpleproject;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		List<Book> bookList = new ArrayList<Book>();
		Book book1 = new Book();
		book1.setId(1);
		book1.setTitle("Paris");
		book1.setAuthor("Edward Rutherfurd");
		book1.setPrice(new BigDecimal("14.49"));
		bookList.add(book1);
		
		Book book2 = new Book();
		book2.setId(2);
		book2.setTitle("Orphan Train");
		book2.setAuthor("Christina Baker Kline");
		book2.setPrice(new BigDecimal("6.99"));
		bookList.add(book2);
		
		Book book3 = new Book();
		book3.setId(3);
		book3.setTitle("Remember me like this");
		book3.setAuthor("Bret Anthony Johnston");
		book3.setPrice(new BigDecimal("10.99"));
		bookList.add(book3);
		
		Book book4 = new Book();
		book4.setId(4);
		book4.setTitle("The Kitchen House");
		book4.setAuthor("Kathleen Grissom");
		book4.setPrice(new BigDecimal("8.62"));
		bookList.add(book4);
		
		Book book5 = new Book();
		book5.setId(5);
		book5.setTitle("The Kitchen House");
		book5.setAuthor("");
		book5.setPrice(new BigDecimal("8.62"));
		bookList.add(book5);
		
		Book book6 = new Book();
		book6.setId(6);
		book6.setTitle("Finding Pride");
		book6.setAuthor("Jill Sanders");
		book6.setPrice(new BigDecimal("11.59"));
		bookList.add(book6);
		
		Book book7 = new Book();
		book7.setId(7);
		book7.setTitle("Paris");
		book7.setAuthor("Edward Rutherfurd");
		book7.setPrice(new BigDecimal("14.49"));
		bookList.add(book7);
		
		Book book8 = new Book();
		book8.setId(8);
		book8.setTitle("Orphan Train");
		book8.setAuthor("Christina Baker Kline");
		book8.setPrice(new BigDecimal("6.99"));
		bookList.add(book8);
		
		Book book9 = new Book();
		book9.setId(9);
		book9.setTitle("Remember me like this");
		book9.setAuthor("Bret Anthony Johnston");
		book9.setPrice(new BigDecimal("10.99"));
		bookList.add(book9);
		
		Book book10 = new Book();
		book10.setId(10);
		book10.setTitle("The Kitchen House");
		book10.setAuthor("Kathleen Grissom");
		book10.setPrice(new BigDecimal("8.62"));
		bookList.add(book10);
		
		Book book11 = new Book();
		book11.setId(11);
		book11.setTitle("The Kitchen House");
		book11.setAuthor("");
		book11.setPrice(new BigDecimal("8.62"));
		bookList.add(book11);
		
		Book book12 = new Book();
		book12.setId(12);
		book12.setTitle("Finding Pride");
		book12.setAuthor("Jill Sanders");
		book12.setPrice(new BigDecimal("11.59"));
		bookList.add(book12);
		
		model.addAttribute("bookList", bookList);
		
		return "home";
	}
	
}
