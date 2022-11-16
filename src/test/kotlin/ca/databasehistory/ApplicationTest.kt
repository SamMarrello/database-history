package ca.databasehistory

import ca.databasehistory.persistence.createConnection
import ca.databasehistory.persistence.getAllHistories
import ca.databasehistory.persistence.getSpecificHistory
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.locations.*
import io.ktor.server.plugins.cachingheaders.*
import io.ktor.http.content.*
import io.ktor.server.plugins.compression.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.plugins.httpsredirect.*
import io.ktor.server.plugins.callloging.*
import org.slf4j.event.*
import io.ktor.server.request.*
import io.ktor.server.plugins.callid.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.auth.*
import io.ktor.util.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlin.test.*
import io.ktor.server.testing.*
import ca.databasehistory.plugins.*
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document
import kotlin.reflect.typeOf

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }
    @Test
    fun testDBConnection() = testApplication {
        application {
            val result = createConnection()
            assert(result == typeOf<MongoDatabase>())
        }
    }
    @Test
    fun testRepo() = testApplication {
        application {
            val db = createConnection()
            val result = getAllHistories(db)
            assert(result == typeOf<MongoCollection<Document>>())
        }
        application {
            val db = createConnection()
            val arr = IntArray(10) { i -> (i + 1) }

            for (item in arr) {
                val result = getSpecificHistory(db, item)
                assert(result == typeOf<Document>())
            }
        }
    }
}