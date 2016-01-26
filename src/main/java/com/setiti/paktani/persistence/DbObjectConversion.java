package com.setiti.paktani.persistence;

import org.bson.Document;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.setiti.paktani.entity.Location;

public class DbObjectConversion {

	public static DBObject createObject(Location location){
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		
		docBuilder.append("_id", location.getLocationName());
		docBuilder.append("name", location.getLocationName());
		docBuilder.append("location_level", location.getLocationLevel());
		docBuilder.append("parent_location", location.getParentLocationId());
		return docBuilder.get();
	}
	
	public static Document createDocument(Location location){
		Document doc = new Document("location", new Document()
		.append("_id", location.getLocationName())
		.append("name", location.getLocationName())
		.append("location_level", location.getLocationLevel())
		.append("parent_location", location.getParentLocationId()));
		return doc;
	}
	
	public static Document createDocument(Location location, String latitude, String longitude){
		Document doc = new Document("location", new Document()
		.append("_id", location.getLocationName())
		.append("name", location.getLocationName())
		.append("location_level", location.getLocationLevel())
		.append("latitude", latitude)
		.append("longitude", longitude)
		.append("parent_location", location.getParentLocationId()));
		return doc;
	}
}
