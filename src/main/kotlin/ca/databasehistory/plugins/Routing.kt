package ca.databasehistory.plugins

import ca.databasehistory.persistence.createConnection
import ca.databasehistory.persistence.getAllHistories
import ca.databasehistory.persistence.getSpecificHistory
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.locations.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    routing {

        get("/History") {
            val db = createConnection()
            val result = getAllHistories(db)

            call.respond {
                TODO()//result.toJson()
                HttpStatusCode.OK
            }
        }
        get("/History/{id}") {
            val db = createConnection()

            val id = call.parameters["id"]

            if (id == null) {
                call.respond(HttpStatusCode.BadRequest)
            }
            else {

                val history = id.toInt()
                val result = getSpecificHistory(db, history)

                call.respond {
                    result.toJson()
                    HttpStatusCode.OK
                }
            }
        }
    }
}
