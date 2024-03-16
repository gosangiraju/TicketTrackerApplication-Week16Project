package com.gl.service;

import java.util.List;

import com.gl.bean.TicketTracker;

public interface TicketTrackerService {
	public void addTicket(TicketTracker ticket);
	public void updateTicketDetails(TicketTracker ticket, int id);
	public void deleteById(int id);
	public List<TicketTracker> getTicketTrackerList();
	public TicketTracker getById(int id);
	public List<TicketTracker> findByTicketTitleOrTicketDescription(String ticketTitle);
}
