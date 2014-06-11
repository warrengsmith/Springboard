package com.jalamor.simpleproject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<Book> bookList = getBookList();
		model.addAttribute("bookList", bookList);
		return "home";
	}

	private List<Book> getBookList() {
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
		
		Book book13 = new Book();
		book13.setId(13);
		book13.setTitle("Paris");
		book13.setAuthor("Edward Rutherfurd");
		book13.setPrice(new BigDecimal("14.49"));
		bookList.add(book13);
		
		Book book14 = new Book();
		book14.setId(14);
		book14.setTitle("Orphan Train");
		book14.setAuthor("Christina Baker Kline");
		book14.setPrice(new BigDecimal("6.99"));
		bookList.add(book14);
		
		Book book15 = new Book();
		book15.setId(15);
		book15.setTitle("Remember me like this");
		book15.setAuthor("Bret Anthony Johnston");
		book15.setPrice(new BigDecimal("10.99"));
		bookList.add(book15);
			
		Book book16 = new Book();
		book16.setId(16);
		book16.setTitle("The Kitchen House");
		book16.setAuthor("");
		book16.setPrice(new BigDecimal("8.62"));
		bookList.add(book16);
		
		Book book17 = new Book();
		book17.setId(17);
		book17.setTitle("Finding Pride");
		book17.setAuthor("Jill Sanders");
		book17.setPrice(new BigDecimal("11.59"));
		bookList.add(book17);
		
		Book book18 = new Book();
		book18.setId(18);
		book18.setTitle("Paris");
		book18.setAuthor("Edward Rutherfurd");
		book18.setPrice(new BigDecimal("14.49"));
		bookList.add(book18);
		
		Book book19 = new Book();
		book8.setId(19);
		book19.setTitle("Orphan Train");
		book19.setAuthor("Christina Baker Kline");
		book19.setPrice(new BigDecimal("6.99"));
		bookList.add(book19);
		
		Book book20 = new Book();
		book20.setId(20);
		book20.setTitle("Remember me like this");
		book20.setAuthor("Bret Anthony Johnston");
		book20.setPrice(new BigDecimal("10.99"));
		bookList.add(book20);
		
		Book book21 = new Book();
		book21.setId(21);
		book21.setTitle("The Kitchen House");
		book21.setAuthor("Kathleen Grissom");
		book21.setPrice(new BigDecimal("8.62"));
		bookList.add(book21);
		
		Book book22 = new Book();
		book22.setId(22);
		book22.setTitle("The Kitchen House");
		book22.setAuthor("");
		book22.setPrice(new BigDecimal("8.62"));
		bookList.add(book22);
		
		Book book23 = new Book();
		book23.setId(23);
		book23.setTitle("Finding Pride");
		book23.setAuthor("Jill Sanders");
		book23.setPrice(new BigDecimal("11.59"));
		bookList.add(book23);
		
		Book book24 = new Book();
		book24.setId(24);
		book24.setTitle("The Kitchen House");
		book24.setAuthor("Kathleen Grissom");
		book24.setPrice(new BigDecimal("8.62"));
		bookList.add(book24);
		return bookList;
	}
	
}
