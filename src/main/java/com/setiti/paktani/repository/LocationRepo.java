package com.setiti.paktani.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.setiti.paktani.entity.Location;

public interface LocationRepo extends CrudRepository<Location, Long> {

	@Query("{'locationName' : ?0}")
	public Iterable<Location> searchByName(String locationName);
}
