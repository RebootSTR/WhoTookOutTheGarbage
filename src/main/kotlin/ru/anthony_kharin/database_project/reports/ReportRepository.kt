package ru.anthony_kharin.database_project.reports

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ReportRepository : CrudRepository<ReportEntity, Int>