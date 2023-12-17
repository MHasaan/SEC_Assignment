class Course 
{
    //Course Name
    String name;
    //Registered Students
    Student[] students;
    int totalStudents;
    
    //Students marks
    int[] marks;
    //Student attendence    
    int[] attendance;

    Course(String name) 
    {
        this.name = name;
        this.students = new Student[40]; // Maximum students
        this.marks = new int[40];
        this.attendance = new int[40];
        this.totalStudents = 0;
    }

    String getName() 
    {
        return this.name;
    }
    
    // Register student in the course
    void registerStudent(Student student) 
    {
        students[totalStudents++] = student;
    }

    // Upload marks of a specific student
    void uploadMarks(int index, int mark)
    {
        this.marks[index] = mark;
    }

    // View marks of a specific student
    int viewMarks(int index)
    {
        return this.marks[index];
    }

    // Record attendance of a specific student
    void recordAttendance(int index, int attendance) 
    {
        this.attendance[index] = attendance;
    }

    // View attendance for a specific student
    int viewAttendance(int index) 
    {
        return this.attendance[index];
    }

    void displayStudentsReport()
    {
        System.out.println("Students Report:");
        for (int i = 0; i < totalStudents; i++) 
        {
            System.out.println("Name: " + students[i].getName() + " Marks: " + marks[i] + " Attendance: " + attendance[i]);
        }
    }

    void displayStudents() 
    {
        System.out.println("Students:");
        int counter = 1;
        for (Student student : students) 
        {
            if (student != null) 
            {
                System.out.println(counter++ + "." + student.getName());
            }
        }
    }
}
