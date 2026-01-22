package com.example.studentsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentsapp.model.Student

class StudentAdapter(
    private var students: List<Student>,
    private val onStudentClick: (Int) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTv: TextView = itemView.findViewById(R.id.student_row_name)
        val idTv: TextView = itemView.findViewById(R.id.student_row_id)
        val checkBox: CheckBox = itemView.findViewById(R.id.student_row_check)
        val image: ImageView = itemView.findViewById(R.id.student_row_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_list_row, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.nameTv.text = student.name
        holder.idTv.text = "ID: ${student.id}"
        holder.checkBox.isChecked = student.isChecked

        holder.checkBox.setOnClickListener {
            student.isChecked = holder.checkBox.isChecked
        }

        holder.itemView.setOnClickListener {
            onStudentClick(position)
        }
    }

    override fun getItemCount(): Int = students.size

    fun updateData(newStudents: List<Student>) {
        students = newStudents
        notifyDataSetChanged()
    }
}
