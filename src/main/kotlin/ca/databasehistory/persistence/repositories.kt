package ca.databasehistory.persistence

import ca.databasehistory.models.History
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document
import java.time.Instant

fun getAllHistories(database: MongoDatabase): MongoCollection<Document> {

    return database.getCollection("History")
}

fun getSpecificHistory(database: MongoDatabase, id: Int): Document {

    return TODO()//database.getCollection("History").find()
}

fun getYear(database: MongoDatabase, date: kotlinx.datetime.Instant): MongoCollection<Document> {

    return TODO()//database.getCollection("History").find(date)
}