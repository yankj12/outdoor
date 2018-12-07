package com.yan.outdoor.config;


import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@EnableMongoRepositories(basePackages = "com.yan.outdoor")
public class MongoConfig extends AbstractMongoConfiguration {
  
    @Override
    protected String getDatabaseName() {
        return "manage";
    }
  
    @Override
    public MongoClient mongoClient() {
    	MongoCredential credential = MongoCredential.createCredential("username", "userDefinedDatabase", "password".toCharArray());
		MongoClient mongoClient = new MongoClient(new ServerAddress("localhost", 27017),
		                                         Arrays.asList(credential));
		return mongoClient;
    }
  
    @Override
    protected String getMappingBasePackage() {
        return "com.yan.outdoor";
    }
}