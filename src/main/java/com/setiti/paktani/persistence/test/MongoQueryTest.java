package com.setiti.paktani.persistence.test;

import static org.junit.Assert.*;

import java.util.List;

import org.bson.Document;
import org.junit.Test;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.setiti.paktani.entity.Location;
import com.setiti.paktani.persistence.DbObjectConversion;
import com.setiti.paktani.persistence.MongoResource;

public class MongoQueryTest {

	@SuppressWarnings("deprecation")
	
	
	@Test
	public void testQuery() {
		MongoResource resource = MongoResource.INSTANCE;
		MongoClient client = resource.getClient();
		MongoDatabase db = client.getDatabase("mydb");
		Location location = new Location();
		//location.setLocationLevel(2);
		//location.setParentLocationId("Jawa Tengah");
		//location.setLocationName("Klaten");
		//location.setLocationLevelString("kabupaten");;
		Document d = DbObjectConversion.createDocument(location);
		FindIterable<Document> docs = db.getCollection("locations").find(new Document("location.name", "Klaten"));
		docs.forEach(new Block<Document>() {
		    @Override
		    public void apply(final Document document) {
		        System.out.println(document);
		    }
		});
		
		//System.out.println(db.getName());
	}
	
	
	
	

}
