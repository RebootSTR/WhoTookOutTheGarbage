package ru.anthony_kharin.database_project.reports

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.anthony_kharin.database_project.reports.dto.AddReportDto
import ru.anthony_kharin.database_project.task.TaskRepository
import ru.anthony_kharin.database_project.user.UserRepository

@Service
class ReportService @Autowired constructor(
    private val reportRepository: ReportRepository,
    private val userRepository: UserRepository,
    private val taskRepository: TaskRepository
) {
    fun addReport(report: AddReportDto): Int {
        // add points to user
        val task = taskRepository.findById(report.taskId).get()
        val user = userRepository.findById(report.userId).get()
        val newUser = user.copy(
            score = user.score + task.cost
        )
        userRepository.save(newUser)

        // saving report
        val r = ReportEntity(
            text = report.text,
            photo = "${report.photo1},${report.photo1}"
        )
        return reportRepository.save(r).id
    }

    fun getAll() = reportRepository.findAll().toList()
    fun getById(id: Int) = reportRepository.findById(id).get()
}