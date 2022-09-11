package com.esg.garbage.reports

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ReportRepository : CrudRepository<ReportEntity, Int>