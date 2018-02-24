
package com.mongo;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class QueryDriver
{

	public static void main(String[] args)
	{
		/*
		 * @SuppressWarnings({ "resource", "deprecation" }) DB db = (new
		 * MongoClient("localhost", 27017)).getDB("test"); DBCollection
		 * collection = db.getCollection("Channel"); BasicDBObject bdo =new
		 * BasicDBObject(); bdo.put("name", "suresh"); bdo.put("id", 2);
		 * collection.insert(bdo);
		 */
		//use dbname , show collections , db.Channel.find(), db.Channel.find().pretty()
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

		MongoDatabase database = mongoClient.getDatabase("test");
		List<Integer> books = Arrays.asList(1251, 2512);
		Document person = new Document("_id", "ABHSIHEK").append("name", "java roots")
						.append("address", new BasicDBObject("street", "sad java").append("city", "mongos").append("state", "mongod").append("zip", 5151))
						.append("books", books);

		MongoCollection<Document> collection = database.getCollection("people");
		collection.insertOne(person);
		mongoClient.close();

	}

}
