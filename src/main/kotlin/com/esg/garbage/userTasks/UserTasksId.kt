package com.esg.garbage.userTasks

import java.io.Serializable

data class UserTasksId(
    val userId: String = "",
    val taskId: Int = 0
): Serializable