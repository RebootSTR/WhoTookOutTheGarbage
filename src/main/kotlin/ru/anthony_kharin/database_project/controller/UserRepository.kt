package ru.anthony_kharin.database_project.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcOperations
import org.springframework.stereotype.Repository
import java.sql.Types

@Repository
class UserRepository @Autowired constructor(
    private val jdbcOperations: JdbcOperations
) {

    private val insertQuery = "INSERT INTO users (id, firstname, secondname, score) VALUES (?, ?, ?, ?) RETURNING id"
    private val searchQuery = "SELECT firstname FROM users"

    fun save(userEntity: UserEntity) {
        val params = arrayOf(userEntity.id, userEntity.firstname, userEntity.secondname, userEntity.score)
        val types = intArrayOf(Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.INTEGER)
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