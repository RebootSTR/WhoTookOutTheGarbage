package com.esg.garbage.reports

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.esg.garbage.reports.dto.AddReportDto

@RestController
@RequestMapping("/reports")
class ReportController @Autowired constructor(
    private val reportService: ReportService
) {

    @PostMapping(value = ["/new"])
    fun addTask(@RequestBody addReportDto: AddReportDto): ResponseEntity<Int> {
        val id = reportService.addReport(addReportDto)
        return ResponseEntity(id, HttpStatus.OK)
    }

    @GetMapping(value = ["/getAll"])
    fun getAll(): ResponseEntity<List<ReportEntity>> {
        val reports = reportService.getAll()
        return ResponseEntity(reports, HttpStatus.OK)
    }

    @GetMapping(value = ["/getById"])
    fun updateTask(id: Int): ResponseEntity<ReportEntity> {
        val report = reportService.getById(id)
        return ResponseEntity(report, HttpStatus.OK)
    }
}