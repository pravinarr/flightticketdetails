package com.airport.flightticketdetails;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
	
	private List<String> route = new ArrayList<String>();
	
	private String seatClass;
	
	private String departTime;
	
	private String arrivalDate;
	
	private String arrivalTime ; 
	
	private String totalTravelTime;
	
	private String fare;

	public String getSeatClass() {
		return seatClass;
	}
	
	public String getTotalTravelTime() {
		return totalTravelTime;
	}

	public void setTotalTravelTime(String totalTravelTime) {
		this.totalTravelTime = totalTravelTime;
	}

	public List<String> getRoute() {
		return route;
	}

	public void setRoute(List<String> route) {
		this.route = route;
	}
	
	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	public String getDepartTime() {
		return departTime;
	}

	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
	

}
