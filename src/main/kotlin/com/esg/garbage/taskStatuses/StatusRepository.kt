package com.esg.garbage.taskStatuses

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StatusRepository : CrudRepository<TaskStatusesEntity, Int>