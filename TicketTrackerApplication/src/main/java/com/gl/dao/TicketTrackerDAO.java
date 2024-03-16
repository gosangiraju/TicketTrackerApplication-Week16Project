package com.gl.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.bean.TicketTracker;

public interface TicketTrackerDAO extends JpaRepository<TicketTracker, Integer> {
	
	
	public List<TicketTracker> findByTicketTitleOrTicketDescription(String ticketTitle,String ticketDescription);

}
