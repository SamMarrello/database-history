package ca.databasehistory.persistence

import ca.databasehistory.models.History
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document

fun getAllHistories(database: MongoDatabase): MongoCollection<Document> {

    return database.getCollection("History")
}

fun getSpecificHistory(database: MongoDatabase, id: Int): Document {

    return database.getCollection("History").find(id)
}