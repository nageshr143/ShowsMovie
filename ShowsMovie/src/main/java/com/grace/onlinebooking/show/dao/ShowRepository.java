package com.grace.onlinebooking.show.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.grace.onlinebooking.show.model.Show;

@Repository//DB connection
public interface ShowRepository extends JpaRepository<Show, Integer> {


	
	
		
}