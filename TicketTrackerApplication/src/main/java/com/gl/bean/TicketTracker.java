package com.gl.bean;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TicketTracker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String ticketTitle;

	String ticketDescription;
	
	String Content;

	LocalDate date=LocalDate.now();


	

	public TicketTracker(int id, String ticketTitle, String ticketDescription, String content) {
		super();
		this.id = id;
		this.ticketTitle = ticketTitle;
		this.ticketDescription = ticketDescription;
		this.Content = content;
		this.date = LocalDate.now();
	}

	public TicketTracker() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTicketTitle() {
		return ticketTitle;
	}

	public void setTicketTitle(String ticketTitle) {
		this.ticketTitle = ticketTitle;
	}

	public String getTicketDescription() {
		return ticketDescription;
	}

	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String toString() {
		return "TicketTracker [id=" + id + ", ticketTitle=" + ticketTitle + ", ticketDescription=" + ticketDescription
				+ ", Content=" + Content + ", date=" + date + "]";
	}

	

	

	
	

}
