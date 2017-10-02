package com.airport.flightticketdetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Test {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub
		
		RestTemplate rest = new RestTemplate();
		FlightTicketsResource resource = new FlightTicketsResource();
		ResponseEntity<String> response = rest.getForEntity(
				"https://developer.goibibo.com/api/search/?app_id=16cc9374&app_key=09e420fae6a9d425daf02b42c5f55a11&format=json&source=CJB&destination=MAA&dateofdeparture=20171103&dateofarrival=20171104&seatingclass=E&adults=1&children=0&infants=0&counter=100",
				String.class);
		JSONObject obj = new JSONObject(response.getBody().toString());
		JSONArray objArray = obj.getJSONObject("data").getJSONArray("onwardflights");
		
		String travelTime = "10h 5m";
		int totalMins = timeInMins(travelTime);

		for (int i = 0; i < objArray.length(); i++) {
			Ticket ticket = pipeValues(objArray, i);
			if(timeInMins(ticket.getTotalTravelTime()) <= totalMins){
				resource.getEconomy().add(ticket);
			}
			
			//http://localhost:8080/flightTickets/gettickets?src=CJB&dest=MAA&depDate=20171103&arrDate=20171104&totalTime=5h 0m
		}
	}

	private static Ticket pipeValues(JSONArray objArray, int i) throws JSONException {
		Ticket ticket = new Ticket();
		JSONObject flight = objArray.getJSONObject(i);
		ticket.setTotalTravelTime(flight.getString("duration").toString());
		ticket.setFare(""+flight.getJSONObject("fare").getLong("grossamount"));
		ticket.setSeatClass(flight.getString("seatingclass").toString());
		ticket.setDepartTime(flight.getString("deptime").toString());
		ticket.getRoute().add(flight.getString("origin").toString());
		
		
		JSONArray onwardFlights = objArray.getJSONObject(i).getJSONArray("onwardflights");
		if(onwardFlights.length() == 0){
			ticket.getRoute().add(flight.getString("destination").toString());
			ticket.setArrivalTime(flight.getString("arrdate").toString());
			ticket.setArrivalDate(flight.getString("arrtime").toString());
		}else{
			for (int j = 0; j < onwardFlights.length(); j++) {
				JSONObject flightNext = null;
				try{
				 flightNext = onwardFlights.getJSONObject(j);
				}catch(Exception e){
					System.out.println("error");
				}
				ticket.getRoute().add(flightNext.getString("origin").toString());
				if(j == onwardFlights.length()-1){
					ticket.getRoute().add(flightNext.getString("destination").toString());
					ticket.setArrivalTime(flightNext.getString("arrdate").toString());
					ticket.setArrivalDate(flightNext.getString("arrtime").toString());
				}
				
			}
			
		}
		return ticket;
	}

	private static int timeInMins(String travelTime) {
		return (Integer.parseInt(travelTime.split("h")[0].trim())*60)+
				Integer.parseInt(travelTime.split("h")[1].split("m")[0].trim());
	}

}
