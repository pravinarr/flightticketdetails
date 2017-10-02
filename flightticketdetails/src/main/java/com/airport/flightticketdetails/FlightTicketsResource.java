package com.airport.flightticketdetails;

import java.util.ArrayList;
import java.util.List;

public class FlightTicketsResource {
	
	private String src;
	
	private String dest;
	
	private String date;
	
	private String departureTime;
	
	private List<Ticket> economy = new ArrayList<Ticket>();
	
	private List<Ticket> business = new ArrayList<Ticket>();
	
	private List<Ticket> first = new ArrayList<Ticket>();

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public List<Ticket> getEconomy() {
		return economy;
	}

	public void setEconomy(List<Ticket> economy) {
		this.economy = economy;
	}

	public List<Ticket> getBusiness() {
		return business;
	}

	public void setBusiness(List<Ticket> business) {
		this.business = business;
	}

	public List<Ticket> getFirst() {
		return first;
	}

	public void setFirst(List<Ticket> first) {
		this.first = first;
	}

}
