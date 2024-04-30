package com.grace.onlinebooking.show.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.grace.onlinebooking.show.model.Show;
import com.grace.onlinebooking.show.service.ShowsService;



@RestController

public class ShowController {

  @Autowired
  private ShowsService showsService;

  
   

  @GetMapping(value="/allShows")
  public Iterable<Show>getAllShows(){
	  System.out.println(" All shows in cntroller************");
		return showsService.findAllShows();
	}
  
  @PostMapping(value="/createShow")
  public ResponseEntity<Show> createCity(@RequestBody Show shows) {
	  Show createdThetre = showsService.createShows(shows);
    return new ResponseEntity<>(createdThetre, HttpStatus.CREATED);
  }
  
  @GetMapping(value="/getShowStartTiming")
  public String getShowStartTiming(@RequestParam String showId) {
  	System.out.println("thetreId:::in controller:::"+showId);
  	int number = Integer.parseInt(showId);
  	return showsService.getShowStartTiming(number);
	}
  
  // Update an existing show
  @PutMapping("/{showId}")
  public ResponseEntity<Show> updateShow(@PathVariable int showId, @RequestBody Show show) {
	  System.out.println("Updating the show **************");
	  Show updatedShow = showsService.updateShow(showId, show);
      return ResponseEntity.ok(updatedShow);
  }
  
//Delete a show
  @DeleteMapping("/{showId}")
  public ResponseEntity<Void> deleteShow(@PathVariable int showId) {
	  showsService.deleteShow(showId);
	
      return ResponseEntity.noContent().build();
  }
  
}





	