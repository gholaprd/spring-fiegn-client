package com.rd;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://192.168.1.4.:9090", name ="FLIGHT-CLIENT")
public interface FlightClient {

	@GetMapping("/getAllFlightDetails")
	public List<FlightDetails> getFlightDetails();
	
	@GetMapping("/findFlightByMasterId")
	public FlightDetails findFlightByMasterId(@RequestParam int flightMasterId);
	@PostMapping(value = "/createFlight", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<FlightDetails> createFlight(@RequestBody FlightDetails flightDetails);

}
