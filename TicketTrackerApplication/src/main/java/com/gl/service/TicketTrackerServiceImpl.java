package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.bean.TicketTracker;
import com.gl.dao.TicketTrackerDAO;


@Service
public class TicketTrackerServiceImpl implements TicketTrackerService {
	
	@Autowired
	TicketTrackerDAO ticketDAO;

	@Override
	public void addTicket(TicketTracker ticket) {
		
		ticketDAO.save(ticket);

	}

	@Override
	public void updateTicketDetails(TicketTracker ticket, int id) {
		
		TicketTracker oldTicket = ticketDAO.findById(id).get();
		
		oldTicket.setTicketTitle(ticket.getTicketTitle());
		
		oldTicket.setTicketDescription(ticket.getTicketDescription());
		
		oldTicket.setContent(ticket.getContent());
		
		ticketDAO.save(oldTicket);
		
	}

	@Override
	public void deleteById(int id) {
		
		ticketDAO.deleteById(id);

	}

	@Override
	public List<TicketTracker> getTicketTrackerList() {
		System.out.println(ticketDAO.findAll());
		return ticketDAO.findAll();
	}

	

	@Override
	public TicketTracker getById(int id) {		
		return ticketDAO.findById(id).get();
	}
	
	@Override
	public List<TicketTracker> findByTicketTitleOrTicketDescription(String query){
		return ticketDAO.findByTicketTitleOrTicketDescription(query,query);
	}
}
