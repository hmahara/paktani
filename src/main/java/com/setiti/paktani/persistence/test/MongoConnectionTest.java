package com.setiti.paktani.persistence.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.setiti.paktani.persistence.MongoResource;

public class MongoConnectionTest {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		MongoResource resource = MongoResource.INSTANCE;
		MongoClient client = resource.getClient();
		List<String> ll = client.getDatabaseNames();
		System.out.println(ll);
	}
	
	@Test
	public void testInsertRow() {
		MongoResource resource = MongoResource.INSTANCE;
		MongoClient client = resource.getClient();
		MongoDatabase db = client.getDatabase("mydb");
		System.out.println(db.getName());
	}
	
	

}
