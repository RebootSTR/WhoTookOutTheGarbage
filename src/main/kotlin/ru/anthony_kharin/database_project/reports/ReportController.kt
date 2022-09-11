package ru.anthony_kharin.database_project.reports

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.anthony_kharin.database_project.reports.dto.AddReportDto

@RestController
@RequestMapping("/reports")
class ReportController @Autowired constructor(
    private val reportService: ReportService
) {

    @PostMapping(value = ["/new"])
    fun addTask(@RequestBody addReportDto: AddReportDto): ResponseEntity<Int> {
        val id = reportService.addReport(addReportDto)
        ResponseEntity(id, HttpStatus.OK)
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }

    @GetMapping(value = ["/getAll"])
    fun getAll(): ResponseEntity<List<ReportEntity>> {
        val reports = reportService.getAll()
        ResponseEntity(reports, HttpStatus.OK)
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }

    @GetMapping(value = ["/getById"])
    fun updateTask(id: Int): ResponseEntity<ReportEntity> {
        val report = reportService.getById(id)
        ResponseEntity(report, HttpStatus.OK)
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }
}