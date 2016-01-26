package com.setiti.paktani.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = "com.setiti.repository")
public class MongoConfig extends AbstractMongoConfiguration {
	 
	    @Override
	    protected String getDatabaseName() {
	        return "mydb";
	    }
	 
	    @Override
	    public Mongo mongo() throws Exception {
	        return new MongoClient("127.0.0.1", 27017);
	    }
	 
	    @Override
	    protected String getMappingBasePackage() {
	        return "com.setiti";
	    }
	    
	    public @Bean MongoDbFactory getMongoDbFactory() throws Exception {
	        return new SimpleMongoDbFactory(new MongoClient("localhost",27017), "mydb");
	    }
	 
	    public @Bean MongoTemplate getMongoTemplate() throws Exception {
	        MongoTemplate mongoTemplate = new MongoTemplate(getMongoDbFactory());
	        return mongoTemplate;
	    }
	
}
