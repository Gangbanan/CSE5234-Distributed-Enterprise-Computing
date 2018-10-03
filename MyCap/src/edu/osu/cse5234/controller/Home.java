package edu.osu.cse5234.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.model.Item;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.model.PaymentInfo;
import edu.osu.cse5234.model.ShippingInfo;

@Controller
@RequestMapping(path="/")
public class Home {
	Order totalOrder;
	
	@RequestMapping(method = RequestMethod.GET)
	public String homePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ... instantiate and set order object with items to display
		if (totalOrder == null) {
			Item item1 = new Item("Cap1", "15", "10");
			Item item2 = new Item("Cap1", "16", "20");
			Item item3 = new Item("Cap1", "17", "30");
			Item item4 = new Item("Cap1", "18", "40");
			Item item5 = new Item("Cap1", "19", "50");
			List<Item> orderList = Arrays.asList(item1, item2, item3, item4, item5);
			totalOrder = new Order();
			totalOrder.setItems(orderList);
		}
		request.setAttribute("totalOrder", totalOrder);
		return "home"; 
	}
	
	@RequestMapping(path="aboutUs", method = RequestMethod.GET)
	public String aboutUs(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ... instantiate and set order object with items to display
		return "AboutUs"; 
	}
	
	@RequestMapping(path="contact", method = RequestMethod.GET)
	public String contact(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ... instantiate and set order object with items to display
		return "contact"; 
	}
}
