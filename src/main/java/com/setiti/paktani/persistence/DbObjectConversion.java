package com.setiti.paktani.persistence;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.setiti.paktani.entity.Location;

public class DbObjectConversion {

	public static DBObject createObject(Location location){
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		
		docBuilder.append("_id", location.getLocationName());
		docBuilder.append("name", location.getLocationName());
		docBuilder.append("location_level", location.getLocationLevel());
		docBuilder.append("parent_location", location.getPare);
		return docBuilder.get();
	}
}
