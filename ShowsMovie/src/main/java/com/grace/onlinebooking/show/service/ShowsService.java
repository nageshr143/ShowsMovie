package com.grace.onlinebooking.show.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.grace.onlinebooking.show.dao.ShowRepository;
import com.grace.onlinebooking.show.model.Show;




@Service
public class ShowsService {

  @Autowired
  private ShowRepository showsRepository;


  public Iterable<Show> findAllShows() {
		return showsRepository.findAll();
	}

  public Show createShows(Show thetreobj) {
		return showsRepository.save(thetreobj);
	}
	
  public String getShowStartTiming(int showId) {
      // Implement logic to retrieve movie name by movieId from the repository
		
		
		@SuppressWarnings("deprecation")
		Show movie = showsRepository.getById(showId);
		System.out.println(" Entered  the service layer"+movie.getStartTime());
      return (movie != null) ? movie.getStartTime() : null;
  }

  public Show updateShow(int showId, Show updatedShow) {
	  System.out.println(" Entered  the service layer"+showId);
	  Show existingShow = showsRepository.getById(showId);
	  System.out.println(" Entered  the existingShow layer");
      existingShow.setStartTime(updatedShow.getStartTime());
      System.out.println(" Entered  setStartTime layer");
      // Save the updated show to the database
      return showsRepository.save(existingShow);
  }
  
  public String  deleteShow(int showId) {
	  Show existingShow = showsRepository.getById(showId);
	  showsRepository.delete(existingShow);
	  return "Successfully deleted::"+showId;
  }
  
}
