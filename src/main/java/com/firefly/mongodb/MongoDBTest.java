package com.firefly.mongodb;

import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * 类MongoDBTest.java的实现描述：TODO 类实现描述
 * 
 * @author walter 2016年4月5日 下午5:44:58
 */
public class MongoDBTest {

    public static void main(String[] args) {
        try {
            Mongo mongo = new Mongo("127.0.0.1", 27017);
            List<String> dbNames = mongo.getDatabaseNames();
            for (String name : dbNames) {
                System.out.println("dbNames:" + name);
            }
            DB db = mongo.getDB("test");
            for (String name : db.getCollectionNames()) {
                System.out.println("collections:" + name);
            }

            DBCollection users = db.getCollection("users");
            DBObject user = new BasicDBObject();
            user.put("name", "test2");
            user.put("age", 10);

            System.out.print(users.save(user).getN());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}
