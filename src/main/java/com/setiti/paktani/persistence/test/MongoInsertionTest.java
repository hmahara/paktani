package com.setiti.paktani.persistence.test;

import static org.junit.Assert.*;

import java.util.List;

import org.bson.Document;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.setiti.paktani.entity.Location;
import com.setiti.paktani.persistence.DbObjectConversion;
import com.setiti.paktani.persistence.MongoResource;

public class MongoInsertionTest {

	@SuppressWarnings("deprecation")
	//@Test
	public void test() {
		MongoResource resource = MongoResource.INSTANCE;
		MongoClient client = resource.getClient();
		List<String> ll = client.getDatabaseNames();
		System.out.println(ll);
	}
	
	//@Test
	public void testInsertRow() {
		MongoResource resource = MongoResource.INSTANCE;
		MongoClient client = resource.getClient();
		MongoDatabase db = client.getDatabase("mydb");
		Location location = new Location();
		location.setLocationLevel(1);
		location.setParentLocationId("Indonesia");
		location.setLocationName("Jawa Tengah");
		location.setLocationLevelString("province");;
		Document d = DbObjectConversion.createDocument(location);
		db.getCollection("locations").insertOne(d);
		//System.out.println(db.getName());
	}
	
	@Test
	public void testInsertTree() {
		MongoResource resource = MongoResource.INSTANCE;
		MongoClient client = resource.getClient();
		MongoDatabase db = client.getDatabase("mydb");
		Location location = new Location();
		location.setLocationLevel(2);
		location.setParentLocationId("Jawa Tengah");
		location.setLocationName("Klaten");
		location.setLocationLevelString("kabupaten");;
		Document d = DbObjectConversion.createDocument(location);
		db.getCollection("locations").insertOne(d);
		
		Location location2 = new Location();
		location2.setLocationLevel(3);
		location2.setParentLocationId("Klaten");
		location2.setLocationName("Delanggu");
		location2.setLocationLevelString("kecamatan");
		Document d2 = DbObjectConversion.createDocument(location2);
		db.getCollection("locations").insertOne(d2);
		
		Location location3 = new Location();
		location3.setLocationLevel(4);
		location3.setParentLocationId("Delanggu");
		location3.setLocationName("Kauman");
		location3.setLocationLevelString("desa");
		Document d3 = DbObjectConversion.createDocument(location3);
		db.getCollection("locations").insertOne(d3);
		//System.out.println(db.getName());
	}
	
	
	
	

}
