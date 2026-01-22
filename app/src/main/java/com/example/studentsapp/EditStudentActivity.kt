package com.example.studentsapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsapp.model.Model

class EditStudentActivity : AppCompatActivity() {

    private var studentPos: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        studentPos = intent.getIntExtra("student_pos", -1)

        val nameEt: EditText = findViewById(R.id.edit_student_name)
        val idEt: EditText = findViewById(R.id.edit_student_id)
        val phoneEt: EditText = findViewById(R.id.edit_student_phone)
        val addressEt: EditText = findViewById(R.id.edit_student_address)
        val checkCb: CheckBox = findViewById(R.id.edit_student_check)
        val saveBtn: Button = findViewById(R.id.edit_student_save_btn)
        val cancelBtn: Button = findViewById(R.id.edit_student_cancel_btn)
        val deleteBtn: Button = findViewById(R.id.edit_student_delete_btn)

        // Load existing student data
        if (studentPos != -1 && studentPos < Model.students.size) {
            val student = Model.students[studentPos]
            nameEt.setText(student.name)
            idEt.setText(student.id)
            phoneEt.setText(student.phone)
            addressEt.setText(student.address)
            checkCb.isChecked = student.isChecked // This sets the initial state
        } else {
            finish()
        }

        cancelBtn.setOnClickListener {
            finish()
        }

        deleteBtn.setOnClickListener {
            if (studentPos != -1 && studentPos < Model.students.size) {
                Model.students.removeAt(studentPos)
            }
            val intent = android.content.Intent(this, StudentListActivity::class.java)
            intent.addFlags(android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        saveBtn.setOnClickListener {
            if (studentPos != -1 && studentPos < Model.students.size) {
                val student = Model.students[studentPos]
                student.name = nameEt.text.toString()
                student.id = idEt.text.toString()
                student.phone = phoneEt.text.toString()
                student.address = addressEt.text.toString()
                student.isChecked = checkCb.isChecked // This saves the updated state
            }
            finish()
        }
    }
}
