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
@RequestMapping(path="/purchase")
public class Purchase {
	
	Order totalOrder;
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewOrderEntryPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ... instantiate and set order object with items to display
		if (totalOrder == null) {
			Item item1 = new Item("New York Yankees '47 MLB Black Series MVP Cap", "15", "10");
			Item item2 = new Item("Melin The Bar Inlay Cap", "16", "20");
			Item item3 = new Item("Cap1", "17", "30");
			Item item4 = new Item("Cap1", "18", "40");
			Item item5 = new Item("Cap1", "19", "50");
			List<Item> orderList = Arrays.asList(item1, item2, item3, item4, item5);
			totalOrder = new Order();
			totalOrder.setItems(orderList);
		}
		request.setAttribute("totalOrder", totalOrder);
		return "OrderEntryForm"; 
	}
	
	@RequestMapping(path = "/submitItems", method = RequestMethod.POST)
	public String submitItems(@ModelAttribute("order") Order order, HttpServletRequest request) {
		List<Item> totalOrderItems = totalOrder.getItems();
		List<Item> orderItems = order.getItems();
		if (totalOrderItems.size() != orderItems.size()) {
			return "redirect:/purchase";
		}
		for (int i = 0; i < totalOrderItems.size(); i++) {
			Item totalI = totalOrderItems.get(i);
			Item orderI = orderItems.get(i);
			if (Integer.valueOf(totalI.getQuantity()) < Integer.valueOf(orderI.getQuantity())) {
				return "redirect:/purchase";
			}
			orderI.setName(totalI.getName());
			orderI.setPrice(totalI.getPrice());
		}
		request.getSession().setAttribute("order", order);
		return "redirect:/purchase/paymentEntry";
	}
	
	@RequestMapping(path = "/paymentEntry", method = RequestMethod.GET)
	public String viewPaymentEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("payment", new PaymentInfo());
		return "PaymentEntryForm"; 
	}
	
	@RequestMapping(path = "/submitPayment", method = RequestMethod.POST)
	public String submitPayment(@ModelAttribute("payment") PaymentInfo payment, HttpServletRequest request) {
		request.getSession().setAttribute("payment", payment);
		return "redirect:/purchase/shippingEntry";
	}
	
	@RequestMapping(path = "/shippingEntry", method = RequestMethod.GET)
	public String viewShippingEntryPage(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("shipping", new ShippingInfo());
		return "ShippingEntryForm"; 
	}
	
	@RequestMapping(path = "/submitShipping", method = RequestMethod.POST)
	public String submitShipping(@ModelAttribute("shipping") ShippingInfo shipping, HttpServletRequest request) {
		request.getSession().setAttribute("shipping", shipping);
		return "redirect:/purchase/viewOrder";
	}
	
	@RequestMapping(path = "/viewOrder", method = RequestMethod.GET)
	public String viewOrderPage(HttpServletRequest request, HttpServletResponse response) {
		return "ViewOrder";
	}
	
	@RequestMapping(path = "/confirmOrder", method = RequestMethod.POST)
	public String confirmOrder(HttpServletRequest request) {
		Order order = (Order) request.getSession().getAttribute("order");
		List<Item> totalOrderItems = totalOrder.getItems();
		List<Item> orderItems = order.getItems();
		if (totalOrderItems.size() != orderItems.size()) {
			return "redirect:/purchase";
		}
		for (int i = 0; i < totalOrderItems.size(); i++) {
			Item totalI = totalOrderItems.get(i);
			Item orderI = orderItems.get(i);
			if (Integer.valueOf(totalI.getQuantity()) < Integer.valueOf(orderI.getQuantity())) {
				return "redirect:/purchase";
			}
		}
		order.confirm();
		for (int i = 0; i < totalOrderItems.size(); i++) {
			Item totalI = totalOrderItems.get(i);
			Item orderI = orderItems.get(i);
			int left = Integer.valueOf(totalI.getQuantity()) - Integer.valueOf(orderI.getQuantity());
			totalI.setQuantity(Integer.toString(left));
		}
		return "redirect:/purchase/viewConfirmation";
	}
	
	@RequestMapping(path = "/viewConfirmation", method = RequestMethod.GET)
	public String viewConfirmation(HttpServletRequest request, HttpServletResponse response) {
		return "Confirmation";
	}
	
	
	
}