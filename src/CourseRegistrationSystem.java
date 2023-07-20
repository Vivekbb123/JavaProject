import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CourseRegistrationSystem {
    private static List<Student> students = new ArrayList<>();
    private static List<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        printTitle();
        initializeCourses();

        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        while (choice != 3) {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerStudent(scanner);
                    break;
                case 2:
                    displayAllRecords();
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }

    private static void printTitle() {
        System.out.println("*********************");
        System.out.println("Course Registration System");
        System.out.println("*********************");
    }

    private static void displayMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Register a student");
        System.out.println("2. Display all records");
        System.out.println("3. Exit");
    }

    private static void initializeCourses() {
        courses.add(new Course("Java Programming", 20));
        courses.add(new Course("Database Management", 15));
        courses.add(new Course("Web Development", 10));
        courses.add(new Course("Data Structures", 25));
    }

    private static void registerStudent(Scanner scanner) {
        
    	System.out.print("\nEnter student Id: ");
        String studentId = scanner.nextLine();
        
    	System.out.print("\nEnter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter student major: ");
        String major = scanner.nextLine();


        System.out.print("Enter student contact number: ");
        String contactNumber = scanner.nextLine();

        System.out.print("Enter date of joining (MM/dd/yyyy): ");
        String dateStr = scanner.nextLine();
        Date dateOfJoin = parseDate(dateStr);

        System.out.print("Enter duration of the course (in months): ");
        int courseDuration = scanner.nextInt();
        scanner.nextLine();

        Student student = new Student(studentId, name, age, major, contactNumber,dateOfJoin, courseDuration);
        students.add(student);

        displayAvailableCourses();

        System.out.print("Select a course (1 to " + courses.size() + "): ");
        int courseChoice = scanner.nextInt();
        scanner.nextLine();

        if (courseChoice < 1 || courseChoice > courses.size()) {
            System.out.println("Invalid choice! Skipping course enrollment for " + student.getName());
            return;
        }

        Course selectedCourse = courses.get(courseChoice - 1);

        selectedCourse.enrollStudent();
        student.addEnrolledCourse(selectedCourse);

        System.out.println("Enrollment details for " + student.getName() + ":");
        System.out.println("Course: " + selectedCourse.getName());
        System.out.println("Enrolled Students: " + selectedCourse.getEnrolledStudents());
    }

    private static Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Using current date instead.");
            return new Date();
        }
    }

    private static void displayAvailableCourses() {
        System.out.println("\nAvailable Courses:");
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            System.out.println((i + 1) + ". " + course.getName() + " (Capacity: " + course.getCapacity() + ")");
        }
    }

    private static void displayAllRecords() {
        System.out.println("\nRegistered Students:");
        for (Student student : students) {
        	System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Major: " + student.getMajor());
            System.out.println("Contact Number: " + student.getContactNumber());
            System.out.println("Date of Joining: " + formatDate(student.getDateOfJoin()));
            System.out.println("Duration of Course: " + student.getCourseDuration() + " months");
            System.out.println("Enrolled Courses:");
            if (student.getEnrolledCourses().isEmpty()) {
                System.out.println("No enrolled courses");
            } else {
                for (Course course : student.getEnrolledCourses()) {
                    System.out.println("- " + course.getName());
                }
            }
            System.out.println("--------------------");
        }
    }
    
    private static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(date);
    }
}