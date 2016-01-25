package com.setiti.paktani.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;



import com.mongodb.MongoClient;
import com.sun.istack.Nullable;

public enum MongoResource {

	INSTANCE;
    private MongoClient mongoClient;
    private Properties properties;
 
    private MongoResource() {
        try {
            if (properties == null) {
                try {
                    properties = loadProperties();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
 
            if (mongoClient == null)
                mongoClient = getClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    private static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream =
          MongoResource.class.getResourceAsStream("/mongodb.properties");
        if (inputStream == null) {
            throw new FileNotFoundException("not loaded!");
        }
        properties.load(inputStream);
        return properties;
    }
 
    @Nullable
    public MongoClient getClient() {
        try {
            return new MongoClient(
                properties.getProperty("host"),
                Integer.valueOf(properties.getProperty("port")));
        } catch (Exception uh) {
            uh.printStackTrace();
        }
        return null;
    }
 
    
}
