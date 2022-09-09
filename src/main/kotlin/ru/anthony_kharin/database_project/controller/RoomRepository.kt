package ru.anthony_kharin.database_project.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository
import java.sql.Types

@Repository
class RoomRepository @Autowired constructor(
    private val jdbcOperations: JdbcOperations
) {

    private val insertQuery = "INSERT INTO test (id) VALUES (?)"
    private val searchQuery = "SELECT id FROM test"

    fun save(str: String) {
        val params: Array<Any?> = arrayOf(str)
        val types = intArrayOf(Types.VARCHAR)
        jdbcOperations.queryForRowSet(insertQuery, params, types)
    }

    fun read(): List<String?> {
        val rowSet = jdbcOperations.queryForRowSet(searchQuery)
        return mutableListOf<String?>().apply {
            while (rowSet.next()) {
                add(rowSet.getString(1))
            }
        }
    }

}