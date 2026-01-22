package com.example.studentsapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsapp.model.Model
import com.example.studentsapp.model.Student

class AddStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        val nameEt: EditText = findViewById(R.id.add_student_name)
        val idEt: EditText = findViewById(R.id.add_student_id)
        val phoneEt: EditText = findViewById(R.id.add_student_phone)
        val addressEt: EditText = findViewById(R.id.add_student_address)
        val checkCb: CheckBox = findViewById(R.id.add_student_check)
        val saveBtn: Button = findViewById(R.id.add_student_save_btn)
        val cancelBtn: Button = findViewById(R.id.add_student_cancel_btn)

        cancelBtn.setOnClickListener {
            finish()
        }

        saveBtn.setOnClickListener {
            val student = Student(
                id = idEt.text.toString(),
                name = nameEt.text.toString(),
                phone = phoneEt.text.toString(),
                address = addressEt.text.toString(),
                isChecked = checkCb.isChecked
            )
            Model.students.add(student)
            finish()
        }
    }
}
