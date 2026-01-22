# Students App - Android Assignment

A simple and intuitive Android application for managing student records, built as part of a mobile application development course.

## Features

- **Student List:** View all students in a `RecyclerView` with their name, ID, and status.
- **In-Memory Storage:** Uses a Singleton Model to handle data, ensuring speed and simplicity (resets on app close).
- **Add Student:** Easily add new students with details like Name, ID, Phone, and Address.
- **Student Details:** View comprehensive information about a specific student.
- **Edit & Delete:** Update existing student records or remove them from the system.
- **Dynamic Updates:** The list automatically refreshes whenever changes are made.

## Technical Implementation

- **Language:** Kotlin
- **UI:** XML Layouts (ConstraintLayout, LinearLayout)
- **Architecture:** Multiple Activities (no Fragments)
- **Data Pattern:** Singleton Model (In-memory "DB")
- **List View:** `RecyclerView` with a custom Adapter and ViewHolder pattern.
- **Navigation:** Intent-based navigation between 4 main activities.

## Screens

1. **Students List:** The main entry point showing all students.
2. **New Students:** Form to create a new student entry.
3. **Student Details:** Displays full data of a selected student.
4. **Edit Students:** Allows modification of student data or deletion.

## Requirements Met

- [x] Use of Activities only (no Fragments).
- [x] Implementation of a Singleton Model for data management.
- [x] Use of RecyclerView for the student list.
- [x] In-memory persistence (data resets on app restart).
- [x] Full CRUD operations (Create, Read, Update, Delete).

## How to Run

1. Clone the repository: `git clone https://github.com/neryapersiko/StudentsApp.git`
2. Open the project in **Android Studio**.
3. Build and run on an Emulator or a physical Android device.

---
Developed as part of a Mobile App Development course.
