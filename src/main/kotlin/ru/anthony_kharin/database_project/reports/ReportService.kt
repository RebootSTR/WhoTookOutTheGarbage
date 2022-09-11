package ru.anthony_kharin.database_project.reports

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.anthony_kharin.database_project.reports.dto.AddReportDto
import ru.anthony_kharin.database_project.taskStatuses.Statuses
import ru.anthony_kharin.database_project.user.UserRepository
import ru.anthony_kharin.database_project.userTasks.UserTasksId
import ru.anthony_kharin.database_project.userTasks.UserTasksRepository

@Service
class ReportService @Autowired constructor(
    private val reportRepository: ReportRepository,
    private val userRepository: UserRepository,
    private val userTasksRepository: UserTasksRepository
) {
    fun addReport(dto: AddReportDto): Int {
        val user = userRepository.findById(dto.userId).get()
        val task = user.tasks.first { it.id == dto.taskId }

        // add points to user
        val newUser = user.copy(
            score = user.score + task.cost
        )

        // change status
        val userTask = userTasksRepository.findById(UserTasksId(user.id, task.id)).get()
        val newUserTask = userTask.copy(
            statusId = Statuses.SUCCESS.id
        )

        // save user and userTask
        userTasksRepository.save(newUserTask)
        userRepository.save(newUser)

        // saving report
        val r = ReportEntity(
            text = dto.text,
            photo = "${dto.photo1},${dto.photo1}"
        )
        return reportRepository.save(r).id
    }

    fun getAll() = reportRepository.findAll().toList()
    fun getById(id: Int) = reportRepository.findById(id).get()
}