package com.example.student_example;

import javax.swing.*;
import java.awt.*;

public class StudentUI extends JFrame{
	JTextField nameField, emailField, courseField, ageField, collegeField;
    JTextField retrieveIdField, updateIdField, deleteIdField, updateNameField, updateEmailField;

    // Buttons
    JButton saveBtn, retrieveBtn, updateBtn, deleteBtn;
	
	StudentFunctions stufunc = new StudentFunctions();
	
	public StudentUI() {
		setTitle("Student Management System = Hibernate+Swing");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel saveLabel = new JLabel("Save Student Details");
		saveLabel.setBounds(20, 10, 200, 30);
		add(saveLabel);
		
		addLabel("Name: ", 20, 50);
		nameField = addTextField(150, 50);
		
		addLabel("Email:", 20, 90);
        emailField = addTextField(150, 90);

        addLabel("Course:", 20, 130);
        courseField = addTextField(150, 130);

        addLabel("Age:", 20, 170);
        ageField = addTextField(150, 170);

        addLabel("College:", 20, 210);
        collegeField = addTextField(150, 210);

        saveBtn = new JButton("SAVE");
        saveBtn.setBounds(150, 250, 100, 30);
        add(saveBtn);

        // ---------------------- RETRIEVE SECTION ----------------------------
        JLabel retrieveLabel = new JLabel("Retrieve Student");
        retrieveLabel.setBounds(20, 300, 200, 30);
        add(retrieveLabel);

        addLabel("Enter ID:", 20, 340);
        retrieveIdField = addTextField(150, 340);

        retrieveBtn = new JButton("RETRIEVE");
        retrieveBtn.setBounds(150, 380, 120, 30);
        add(retrieveBtn);

        // ---------------------- UPDATE SECTION ----------------------------
        JLabel updateLabel = new JLabel("Update Student");
        updateLabel.setBounds(20, 430, 200, 30);
        add(updateLabel);

        addLabel("ID:", 20, 470);
        updateIdField = addTextField(150, 470);

        addLabel("New Name:", 20, 510);
        updateNameField = addTextField(150, 510);

        addLabel("New Email:", 20, 550);
        updateEmailField = addTextField(150, 550);

        updateBtn = new JButton("UPDATE");
        updateBtn.setBounds(150, 590, 120, 30);
        add(updateBtn);

        // ---------------------- DELETE SECTION ----------------------------
        JLabel deleteLabel = new JLabel("Delete Student");
        deleteLabel.setBounds(20, 630, 200, 30);
        add(deleteLabel);

        addLabel("ID:", 20, 670);
        deleteIdField = addTextField(150, 670);

        deleteBtn = new JButton("DELETE");
        deleteBtn.setBounds(150, 710, 120, 30);
        add(deleteBtn);

        // ---------------------- ACTION LISTENERS ----------------------------

        saveBtn.addActionListener(e -> saveStudent());
        retrieveBtn.addActionListener(e -> retrieveStudent());
        updateBtn.addActionListener(e -> updateStudent());
        deleteBtn.addActionListener(e -> deleteStudent());

        setVisible(true);
    }

    // Helper method to add labels
    private void addLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 120, 30);
        add(label);
    }

    // Helper method to add text fields
    private JTextField addTextField(int x, int y) {
        JTextField tf = new JTextField();
        tf.setBounds(x, y, 200, 30);
        add(tf);
        return tf;
    }

    // -------------------- CRUD METHODS -------------------------

    private void saveStudent() {
        try {
            String name = nameField.getText();
            String email = emailField.getText();
            String course = courseField.getText();
            int age = Integer.parseInt(ageField.getText());
            String college = collegeField.getText();

            Student stu = new Student(name, email, course, age, college);
            stufunc.saveStudent(stu);

            JOptionPane.showMessageDialog(this, "Student Saved Successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void retrieveStudent() {
        try {
            int id = Integer.parseInt(retrieveIdField.getText());
            Student s = stufunc.retreiveStudent(id);;

            if (s != null) {
                JOptionPane.showMessageDialog(this,
                        "Name: " + s.getName() +
                        "\nEmail: " + s.getEmail() +
                        "\nCourse: " + s.getCourse() +
                        "\nAge: " + s.getAge() +
                        "\nCollege: " + s.getStudentcol());
            } else {
                JOptionPane.showMessageDialog(this, "Student Not Found!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void updateStudent() {
        try {
            int id = Integer.parseInt(updateIdField.getText());
            String newName = updateNameField.getText();
            String newEmail = updateEmailField.getText();

            stufunc.updateStudent(newName, newEmail, id);
            JOptionPane.showMessageDialog(this, "Student Updated!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void deleteStudent() {
        try {
            int id = Integer.parseInt(deleteIdField.getText());
            stufunc.deleteStudent(id);
            JOptionPane.showMessageDialog(this, "Student Deleted Successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
	}
}
