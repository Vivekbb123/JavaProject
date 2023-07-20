import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Student {
	private String studentId;
    private String name;
    private int age;
    private String major;
    private String contactNumber;
    private List<Course> enrolledCourses;
    private Date dateOfJoin;
    private int courseDuration;

    public Student(String studentId, String name, int age, String major, String contactNumber,Date dateOfJoin, int courseDuration) {
    	this.studentId = studentId;
    	this.name = name;
        this.age = age;
        this.major = major;
        this.contactNumber = contactNumber;
        this.dateOfJoin = dateOfJoin;
        this.courseDuration = courseDuration;
        this.enrolledCourses = new ArrayList<>();
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public int getCourseDuration() {
        return courseDuration;
    }

    public void addEnrolledCourse(Course course) {
        enrolledCourses.add(course);
    }
}