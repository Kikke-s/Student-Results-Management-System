# Student Results Management System

A Java console-based application for managing students, teachers, subjects, scores, and academic results.

## About the Project

The Student Results Management System was developed as a Java project to demonstrate object-oriented programming, user input handling, data management, validation, and result processing.

The application allows users to add and manage students and teachers, assign subject scores, calculate student averages, and determine grades.

## Features

- Add students
- Add teachers
- Assign subject scores to students
- Display student records
- Display teacher records
- Remove students
- Remove teachers
- Calculate student averages
- Calculate student grades
- Prevent duplicate student and teacher IDs
- Validate scores between 0 and 100
- Prevent duplicate subject scores for a student
- Clear stored data
- Console-based menu system

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Java Collections
- File Handling
- IntelliJ IDEA
- Git
- GitHub

## OOP Concepts Demonstrated

The project demonstrates:

- Classes and Objects
- Encapsulation
- Inheritance
- Constructors
- Methods
- Polymorphism
- Inheritance through the `Person`, `Student`, and `Teacher` classes

## Project Structure

```text
Student-Results-Management-System/
│
├── src/
│   ├── Main.java
│   ├── Person.java
│   ├── Student.java
│   ├── Teacher.java
│   └── ResultManager.java
│
├── students.txt
├── teachers.txt
└── .gitignore

## How to Run

1. Download or clone this repository.
2. Open the project in IntelliJ IDEA.
3. Make sure Java is installed on your computer.
4. Open `Main.java` from the `src` folder.
5. Click the green Run button next to the `main()` method.
6. The Student Results Management System will start in the console.
7. Follow the menu options displayed on the screen.

## Example Workflow

A typical workflow is:

1. Add a student.
2. Add a teacher.
3. Assign a subject and score to the student.
4. Display the student's result.
5. View the student's average and grade.

## Validation

The system checks user input to help prevent invalid data.

- Student and teacher IDs cannot be duplicated.
- Scores must be between 0 and 100.
- A student cannot have two scores for the same subject.
- Student information cannot be left empty.

## Future Improvements

Possible future improvements include:

- Graphical user interface
- Database integration
- Student and teacher login systems
- More detailed result reports
- PDF result export
- Search and filtering features

## Author

**Osinfade Azeezat Omolola**

Computer Science Student  
Olabisi Onabanjo University

