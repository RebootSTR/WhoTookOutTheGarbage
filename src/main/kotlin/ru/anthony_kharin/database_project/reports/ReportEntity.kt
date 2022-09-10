package ru.anthony_kharin.database_project.reports

import javax.persistence.*

@Entity
@Table(name = "report")
data class ReportEntity(

    @Id
    @SequenceGenerator(name = "reportIdSeq", sequenceName = "report_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reportIdSeq")
    @Column(name = "id", nullable = false)
    val id: Int = 0,

    @Column(name = "text", nullable = false)
    val text: String = "",

    @Column(name = "photo", nullable = true)
    val photo: String = ""
)