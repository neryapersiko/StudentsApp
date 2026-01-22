package com.example.studentsapp.model

object Model {
    val students: MutableList<Student> = mutableListOf()

    init {
        // Adding some dummy data for initial testing
        for (i in 0..10) {
            students.add(Student(i.toString(), "Student $i", "050123456$i", "Address $i", false))
        }
    }
}
