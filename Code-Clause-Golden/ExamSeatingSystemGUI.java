import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ExamSeatingSystemGUI extends JFrame {
    private ArrayList<Student> students = new ArrayList<Student>();
    private int totalStudents;
    private int availableClasses;
    private int seatsPerClass;
    private JTextField totalStudentsField;
    private JTextField availableClassesField;
    private JTextField seatsPerClassField;
    private JTextArea outputArea;

    public ExamSeatingSystemGUI() {
        // Set up the JFrame
        super("Exam Seating System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Total number of students:"));
        totalStudentsField = new JTextField();
        inputPanel.add(totalStudentsField);
        inputPanel.add(new JLabel("Number of available classes:"));
        availableClassesField = new JTextField();
        inputPanel.add(availableClassesField);
        inputPanel.add(new JLabel("Number of seats per class:"));
        seatsPerClassField = new JTextField();
        inputPanel.add(seatsPerClassField);
        JButton generateButton = new JButton("Generate seating arrangement");
        generateButton.addActionListener(e -> generateSeatingArrangement());
        inputPanel.add(generateButton);

        // Create the output panel
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane outputScrollPane = new JScrollPane(outputArea);

        // Add the panels to the JFrame
        add(inputPanel, BorderLayout.NORTH);
        add(outputScrollPane, BorderLayout.CENTER);

        // Make the JFrame visible
        setVisible(true);
    }

    // Generate seating arrangement
    public void generateSeatingArrangement() {
        // Get input values from text fields
        totalStudents = Integer.parseInt(totalStudentsField.getText());
        availableClasses = Integer.parseInt(availableClassesField.getText());
        seatsPerClass = Integer.parseInt(seatsPerClassField.getText());

        // Clear the output area
        outputArea.setText("");

        // Get student input
        for (int i = 1; i <= totalStudents; i++) {
            String name = JOptionPane.showInputDialog("Enter name of student " + i + ":");
            String rollNumber = JOptionPane.showInputDialog("Enter roll number of student " + i + ":");
            String branch = JOptionPane.showInputDialog("Enter branch of student " + i + ":");
            int semester = Integer.parseInt(JOptionPane.showInputDialog("Enter semester of student " + i + ":"));
            int year = Integer.parseInt(JOptionPane.showInputDialog("Enter year of student " + i + ":"));
            students.add(new Student(rollNumber, name, semester, branch, year));
        }

        // Generate seating arrangement
        int totalSeats = availableClasses * seatsPerClass;
        if (totalStudents > totalSeats) {
            outputArea.append("Error: Not enough seats available\n");
            return;
        }

        // Sort students by roll number
        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return s1.getRollNumber().compareTo(s2.getRollNumber());
            }
        });

        int seatCount = 0;
        int rowNumber = 1;
        for (Student student : students) {
            int seatNumber = seatCount % seatsPerClass + 1;
            student.setSeatNumber(seatNumber);
            student.setRowNumber(rowNumber);
            seatCount++;
            if (seatCount % seatsPerClass == 0) {
                rowNumber++;
            }
        }

        outputArea.append("Seating arrangement generated:\n");
        for (int classNumber = 1; classNumber <= availableClasses; classNumber++) {
            outputArea.append("Class " + classNumber + ":\n");
            for (int seatNumber = 1; seatNumber <= seatsPerClass; seatNumber++) {
                outputArea.append("Seat " + seatNumber + ": ");
                for (Student student : students) {
                    if (student.getSeatNumber() == seatNumber && student.getRowNumber() == classNumber) {
                        outputArea.append(student.getName() + " (" + student.getRollNumber() + ")");
                    }
                }
                outputArea.append("\n");
            }
        }
    }

    public static void main(String[] args) {
        new ExamSeatingSystemGUI();
    }
}
