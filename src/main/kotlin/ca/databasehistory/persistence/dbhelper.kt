package ca.databasehistory.persistence

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoDatabase

fun createConnection(): MongoDatabase {

    val password: String = System.getenv("password")
    val uri = ConnectionString("mongodb+srv://SamMarrello:<$password>@databasehistory.8gluluc." +
            "mongodb.net/?retryWrites=true&w=majority")

    val settings: MongoClientSettings = MongoClientSettings.builder()
        .applyConnectionString(uri)
        .build();

    val mongoClient: com.mongodb.client.MongoClient = MongoClients.create(settings)
    val database: MongoDatabase = mongoClient.getDatabase("test")

    return database
}
