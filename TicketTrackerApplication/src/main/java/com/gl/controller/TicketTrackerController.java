package com.gl.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.bean.TicketTracker;
import com.gl.service.TicketTrackerService;




@Controller
@RequestMapping("/admin")
public class TicketTrackerController {
	
	@Autowired
	TicketTrackerService ticketService;
	
	@RequestMapping("/tickets")
	public String goToHome(Model model) {
		model.addAttribute("list",ticketService.getTicketTrackerList());
		return "home";
	}
	
	@RequestMapping("/addTicket")
	public String goToAddTicket(Model model) {
		model.addAttribute("ticket", new TicketTracker());
		return "addTicket";
	}
	
	@RequestMapping("/saveTicket")
	public String goTosaveTicket(@ModelAttribute("ticket") TicketTracker ticket) {
		ticketService.addTicket(ticket);
		return "redirect:/admin/tickets";
	}
	
	@RequestMapping("/delete")
	public String goToDelete(@RequestParam("id") int id) {
		ticketService.deleteById(id);
		return "redirect:/admin/tickets";
	}
	
	@RequestMapping("/edit")
	public String goToEdit(@RequestParam("id") int id, Model model) {
		TicketTracker ticket=ticketService.getById(id);
		model.addAttribute("ticket", ticket);
		return "editForm";
	}
	
	@RequestMapping("/saveEdit")
	public String goToEditById(@RequestParam("id") int id,@ModelAttribute("ticket") TicketTracker ticket ) {
		ticketService.updateTicketDetails(ticket, id);
		return "redirect:/admin/tickets";
	}
	
	@RequestMapping("/view")
	public String goToView(@RequestParam("id") int id, Model model) {
		TicketTracker ticket=ticketService.getById(id);
		model.addAttribute("ticket", ticket);
		return "viewForm";
	}
	
	@RequestMapping("/search")
	public String goToSearch(@RequestParam("query") String query, Model model) {
	    List<TicketTracker> searchResults = ticketService.findByTicketTitleOrTicketDescription(query);
	    model.addAttribute("list", searchResults);
	    return "home"; 
	}

	

}
