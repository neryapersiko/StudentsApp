package com.example.studentsapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsapp.model.Model

class StudentDetailsActivity : AppCompatActivity() {

    private var studentPos: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        studentPos = intent.getIntExtra("student_pos", -1)
        
        setupUI()

        findViewById<Button>(R.id.details_student_back_btn).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.details_student_edit_btn).setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("student_pos", studentPos)
            startActivity(intent)
        }

        findViewById<CheckBox>(R.id.details_student_check).setOnClickListener { view ->
            if (studentPos != -1 && studentPos < Model.students.size) {
                Model.students[studentPos].isChecked = (view as CheckBox).isChecked
            }
        }
    }

    override fun onResume() {
        super.onResume()
        setupUI()
    }

    private fun setupUI() {
        if (studentPos != -1 && studentPos < Model.students.size) {
            val student = Model.students[studentPos]
            findViewById<TextView>(R.id.details_student_name).text = student.name
            findViewById<TextView>(R.id.details_student_id).text = student.id
            findViewById<TextView>(R.id.details_student_phone).text = student.phone
            findViewById<TextView>(R.id.details_student_address).text = student.address
            findViewById<CheckBox>(R.id.details_student_check).isChecked = student.isChecked
        } else {
            finish()
        }
    }
}
