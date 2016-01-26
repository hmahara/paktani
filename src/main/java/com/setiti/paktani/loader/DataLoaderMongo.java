package com.setiti.paktani.loader;

import java.util.Date;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.setiti.paktani.entity.Location;
import com.setiti.paktani.persistence.MongoResource;

public class DataLoaderMongo {
	private static final String DB_NAME = "mydb";
	private static final String LOCATIONS_COLLECTION = "location";
	public static void main(String[] args) {
		MongoResource res = MongoResource.INSTANCE;
		MongoClient mongo = res.getClient();
		///MongoClient mongo = new MongoClient(
        ///        MONGO_HOST, MONGO_PORT);
		MongoOperations mongoOps = new MongoTemplate(mongo, DB_NAME);
		mongoOps.dropCollection(LOCATIONS_COLLECTION);
		mongoOps.getCollection(LOCATIONS_COLLECTION);
		
		for (int i=0; i < 25; i++){
			Location loc = new Location();
			loc.setLocationId(new Date().getTime());
	        loc.setLocationName("DIY"+i);
	        loc.setLocationLevel(1);
	        loc.setLatitude("7");
	        loc.setLongitude("110");
	        loc.setParentLocationId("Indonesia");
	      //build query
	        Query query = new Query(Criteria.where("locationName").is(loc.getLocationName()));

	        //build update
	        DBObject dbDoc = new BasicDBObject();
	        mongoOps.getConverter().write(loc, dbDoc); //it is the one spring use for convertions.
	        Update update = Update.fromDBObject(dbDoc);
	        mongoOps.upsert(query, update, "location");
		}
		

	}

}
