package ca.databasehistory.models

import kotlinx.serialization.Serializable

@Serializable
data class History(val id: Int,
                   val description: String)
