package com.setiti.query;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;

import com.mongodb.MongoClient;
import com.setiti.paktani.config.MongoConfig;
import com.setiti.paktani.entity.Location;
import com.setiti.paktani.persistence.MongoResource;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoConfig.class)
public class MongoTemplateQueryTest {

	//@Autowired
    private MongoTemplate mongoTemplate;
    public  final String DB_NAME = "mydb";
    public  final String LOCATIONS_COLLECTION = "locations";
    public  final String MONGO_HOST = "localhost";
    public  final int MONGO_PORT = 27017;
    MongoOperations mongoOps;
	@Before
	public void setUp() throws Exception {
		//System.out.println(mongoTemplate);
		MongoResource res = MongoResource.INSTANCE;
		MongoClient mongo = res.getClient();
		///MongoClient mongo = new MongoClient(
        ///        MONGO_HOST, MONGO_PORT);
        mongoOps = new MongoTemplate(mongo, DB_NAME);
        //Person p = new Person("113", "PankajKr", "Bangalore, India");
        //mongoOps.insert(p, PERSON_COLLECTION);

        //Person p1 = mongoOps.findOne(
         //       new Query(Criteria.where("name").is("PankajKr")),
         //       Person.class, PERSON_COLLECTION);

        System.out.println(mongoOps);
         
        mongoOps.createCollection(LOCATIONS_COLLECTION);
		//if (mongoTemplate!=null || !mongoTemplate.collectionExists(Location.class)) {
        //    mongoTemplate.createCollection(Location.class);
       // }
	}

	@After
	public void tearDown() throws Exception {
		mongoOps.dropCollection(LOCATIONS_COLLECTION);
	}
	
	@Test
    public void givenUsersExist_whenFindingUserWithNameStartWithA_thenUsersAreFound() {
		Location loc = new Location();
        loc.setLocationName("DIY");
        loc.setLocationLevel(1);
        loc.setLatitude("7");
        loc.setLongitude("109");
        loc.setParentLocationId("Indonesia");
        mongoOps.insert(loc);

        

        Query query = new Query();
        query.addCriteria(Criteria.where("locationName").regex("^D"));

        List<Location> users = mongoOps.find(query, Location.class);
        //assertThat(users.size(), 2);
        System.out.println(users.size());
        
    }

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
