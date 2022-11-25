package ca.databasehistory.models

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class History(val id: Int,
                   val title: String,
                   val body: String,
                   val footer: String,
                   val date: Instant)
