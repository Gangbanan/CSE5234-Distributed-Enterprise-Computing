package edu.osu.cse5234.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

@Controller
@RequestMapping(path="/")
public class Home {
	Order totalOrder;
	
	@RequestMapping(method = RequestMethod.GET)
	public String homePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		InventoryService invSer = ServiceLocator.getInventoryService();
		Inventory inventory = invSer.getAvailableInventory();
		request.setAttribute("inventory", inventory);
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
