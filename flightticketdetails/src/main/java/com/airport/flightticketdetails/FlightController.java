package com.airport.flightticketdetails;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController()
@RequestMapping("/flightTickets")
public class FlightController {

	@GetMapping("/gettickets")
	public FlightTicketsResource getTickets(@RequestParam(value = "src", required = true) final String src,
			@RequestParam(value = "dest", required = true) final String dest,
			@RequestParam(value = "depDate", required = true) final String depDate,
			@RequestParam(value = "arrDate", required = true) final String arrDate,
			@RequestParam(value = "totalTime", required = true) final String totalTime) throws JSONException {
		RestTemplate rest = new RestTemplate();
		FlightTicketsResource resource = new FlightTicketsResource();
		resource.setSrc(src);
		resource.setDest(dest);
		resource.setDate(depDate);
		resource.getEconomy().addAll(buildResponse(src, dest, depDate, arrDate, totalTime, rest, "E"));
		resource.getBusiness().addAll(buildResponse(src, dest, depDate, arrDate, totalTime, rest, "B"));
		return resource;
	}

	private List<Ticket> buildResponse(final String src, final String dest, final String depDate, final String arrDate,
			final String totalTime, RestTemplate rest, String seatClass) throws JSONException {
		ResponseEntity<String> response = rest
				.getForEntity(createUrl(src, dest, depDate, arrDate, totalTime, seatClass), String.class);
		JSONObject obj = new JSONObject(response.getBody().toString());
		JSONArray objArray = obj.getJSONObject("data").getJSONArray("onwardflights");
		List<Ticket> tickets = new ArrayList<Ticket>();
		int totalMins = timeInMins(totalTime);

		for (int i = 0; i < objArray.length(); i++) {
			Ticket ticket = pipeValues(objArray, i);
			if (timeInMins(ticket.getTotalTravelTime()) <= totalMins) {
				tickets.add(ticket);
			}
		}
		return tickets;
	}

	private Ticket pipeValues(JSONArray objArray, int i) throws JSONException {
		Ticket ticket = new Ticket();
		JSONObject flight = objArray.getJSONObject(i);
		ticket.setTotalTravelTime(flight.getString("duration").toString());
		ticket.setFare("" + flight.getJSONObject("fare").getLong("grossamount"));
		ticket.setSeatClass(flight.getString("seatingclass").toString());
		ticket.setDepartTime(flight.getString("deptime").toString());
		ticket.getRoute().add(flight.getString("origin").toString());

		JSONArray onwardFlights = objArray.getJSONObject(i).getJSONArray("onwardflights");
		if (onwardFlights.length() == 0) {
			ticket.getRoute().add(flight.getString("destination").toString());
			ticket.setArrivalTime(flight.getString("arrtime").toString());
			ticket.setArrivalDate(flight.getString("arrdate").toString());
		} else {
			for (int j = 0; j < onwardFlights.length(); j++) {
				JSONObject flightNext = null;
				try {
					flightNext = onwardFlights.getJSONObject(j);
				} catch (Exception e) {
					System.out.println("error");
				}
				ticket.getRoute().add(flightNext.getString("origin").toString());
				if (j == onwardFlights.length() - 1) {
					ticket.getRoute().add(flightNext.getString("destination").toString());
					ticket.setArrivalTime(flightNext.getString("arrtime").toString());
					ticket.setArrivalDate(flightNext.getString("arrdate").toString());
				}

			}

		}
		return ticket;
	}

	private int timeInMins(String travelTime) {
		return (Integer.parseInt(travelTime.split("h")[0].trim()) * 60)
				+ Integer.parseInt(travelTime.split("h")[1].split("m")[0].trim());
	}

	private String createUrl(final String src, final String dest, final String depDate, final String arrDate,
			final String totalTime, String seatClass) {
		return "https://developer.goibibo.com/api/search/?app_id=16cc9374&app_key=09e420fae6a9d425daf02b42c5f55a11&format=json&source="
				+ src + "&destination=" + dest + "&dateofdeparture=" + depDate + "" + "&dateofarrival=" + arrDate
				+ "&seatingclass=" + seatClass + "&adults=1&children=0&infants=0&counter=100";

	}
}
