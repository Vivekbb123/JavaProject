

class Course {
    private String name;
    private int capacity;
    private int enrolledStudents;

    public Course(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.enrolledStudents = 0;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent() {
        if (enrolledStudents < capacity) {
            enrolledStudents++;
            System.out.println("Enrollment successful!");
        } else {
            System.out.println("Enrollment failed. The course is already full.");
        }
    }
}

