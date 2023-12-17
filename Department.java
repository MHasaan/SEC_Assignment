import java.util.Scanner;

class Department 
{
    String Name;

    // Array to store teachers in the department
    Teacher[] teachers;
    int totalTeachers;
    // Array to store students in the department
    Student[] students;
    int totalStudents;
    // Array to store courses offered in the department
    Course[] courses;
    int totalCourses;

    // Constructor to initialize department data structures
    Department()
    {
        this.teachers = new Teacher[20]; // Maximum teachers
        this.students = new Student[500]; // Maximum students
        this.courses = new Course[50]; // Maximum courses
        this.totalTeachers = 0;
        this.totalStudents = 0;
        this.totalCourses = 0;
    }

    Department(String name)
    {
        this.Name = name;
        this.teachers = new Teacher[50]; // Maximum teachers
        this.students = new Student[500]; // Maximum students
        this.courses = new Course[100]; // Maximum courses
        this.totalTeachers = 0;
        this.totalStudents = 0;
        this.totalCourses = 0;
    }

    public void setName(String name)
    {
        Name = name;
    }
    public String getName()
    {
        return Name;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////


    void departmentTeacherManagment()
    {
        Scanner input = new Scanner(System.in);
        boolean condition = true;
        while (condition)
        {
            System.out.println("===========================================");
            System.out.println("|               MENU SELECTION            |");
            System.out.println("===========================================");
            System.out.println("| Options:                                |");
            System.out.println("|        1. Add Teacher                   |");
            System.out.println("|        2. View Registered Teachers      |");
            System.out.println("|        3. Manage Teacher                |");
            System.out.println("|        4. Exit                          |");
            System.out.println("===========================================");
            System.out.print("Select option: ");
            int selection = input.nextInt();
            switch (selection) 
            {
                case 1:
                    addTeacher();
                    break;
                case 2:
                    displayTeachers();
                    break;
                case 3:
                    manageTeacher();
                    break;
                case 4:
                    System.out.println("Exit selected");
                    condition = false;
                    break;
                default:
                    System.out.println("Invalid selection");
                    break; // This break is not really necessary
            }
        }
    }

    void addTeacher()
    {
        Scanner input = new Scanner(System.in);
        String name, password;
        System.out.println("Enter name: ");
        name = input.nextLine();
        System.out.println("Enter password: ");
        password = input.nextLine();
        Teacher teacher = new Teacher(name, password);
        registerTeacher(teacher);
        
    }

    void registerTeacher(Teacher teacher) 
    {
        if (totalTeachers == teachers.length)
        {
            System.out.println("Maximum teachers reached");
            return;
        }
        else
        {
            this.teachers[totalTeachers++] = teacher;
        }
    }

    void displayTeachers()
    {
        boolean flag = false;
        System.out.println();
        for(int i = 0; i < totalTeachers; i++)
        {
            flag=true;
            System.out.println(i+1 + ". "+ teachers[i].name);
        }
        System.out.println();
        if(!flag)
            System.out.println("No Teachers Registered so far");
    }

    void manageTeacher()
    {
        Scanner input = new Scanner(System.in);
        int index = 0;
        System.out.println("Select the teacher: \nPress");
        displayTeachers();
        index = input.nextInt();
        System.out.println(teachers[index-1].name + " selected");
        boolean condition = true;
        while (condition) 
        {
            System.out.println("===========================================");
            System.out.println("|               MENU SELECTION            |");
            System.out.println("===========================================");
            System.out.println("| Options:                                |");
            System.out.println("|        1. Assign Course                 |");
            System.out.println("|        2. View Assigned Courses         |");
            System.out.println("|        2. Exit                          |");
            System.out.println("===========================================");
            System.out.print("Select option: ");
            int selection = input.nextInt();
            switch (selection) 
            {
                case 1:
                    assignCourseToTeacher(teachers[index-1]);
                    break;
                case 2:
                    teachers[index-1].displayAssignedCourses();
                    break;
                case 3:
                    System.out.println("Exit selected");
                    condition = false;
                    break;
                default:
                    System.out.println("Invalid selection");
                    break; // This break is not really necessary
            }
        }
        input.close();
    }

    void assignCourseToTeacher(Teacher teacher)
    {
        Scanner input = new Scanner(System.in);
        int index = 0;
        System.out.println("Select the course: \nPress");
        displayCourses();
        index = input.nextInt();
        System.out.println(courses[index-1].name + " selected");
        teacher.assignCourse(courses[index-1]);
        input.close();
    }


    //////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////


    void manageStudents()
    {
        Scanner input = new Scanner(System.in);
        boolean condition = true;
        while (condition) 
        {
 
            System.out.println("===========================================");
            System.out.println("|               MENU SELECTION            |");
            System.out.println("===========================================");
            System.out.println("| Options:                                |");
            System.out.println("|        1. Register Student              |");
            System.out.println("|        2. View Registered Students      |");
            System.out.println("|        2. Exit                          |");
            System.out.println("===========================================");
            System.out.print("Select option: ");
            int selection = input.nextInt();
            switch (selection) 
            {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    System.out.println("Exit selected");
                    condition = false;
                    break;
                default:
                    System.out.println("Invalid selection");
                    break; // This break is not really necessary
            }
        }
        input.close();
    }

    void addStudent()
    {
        Scanner input = new Scanner(System.in);
        String name, password;
        System.out.println("Enter name: ");
        name = input.nextLine();
        System.out.println("Enter password: ");
        password = input.nextLine();
        Student student = new Student(name, password);
        registerStudent(student);
        input.close();
    }

    void registerStudent(Student student)
    {
        if (totalStudents == students.length) 
        {
            System.out.println("Maximum students reached");
            return;    
        }
        else
        {
            this.students[totalStudents++] = student;
        }
    }

    void displayStudents()
    {
        for(int i = 0; i < totalStudents; i++)
        {
            System.out.println(i+1 + ". "+ students[i].name);
        }
    }
    

    /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////

    void manageCourse()
    {
        boolean condition = true;
        while (condition) 
        {
            Scanner input = new Scanner(System.in);
            System.out.println("===========================================");
            System.out.println("|               MENU SELECTION            |");
            System.out.println("===========================================");
            System.out.println("| Options:                                |");
            System.out.println("|        1. Add Course                    |");
            System.out.println("|        2. View Courses                  |");
            System.out.println("|        3. Exit                          |");
            System.out.println("===========================================");
            System.out.print("Select option: ");
            int selection = input.nextInt();
            switch (selection) 
            {
                case 1:
                    addCourse();
                    break;
                case 2:
                    displayCourses();
                    break;
                case 3:
                    System.out.println("Exit selected");
                    condition = false;
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        }
        // input.close();
    }

    void addCourse()
    {
        Scanner input = new Scanner(System.in);
        String name;
        System.out.println("Enter name: ");
        name = input.nextLine();
        Course course = new Course(name);
        registerCourse(course);
    }

    void registerCourse(Course course)
    {
        if (totalCourses == courses.length) 
        {
            System.out.println("Maximum courses reached");
            return;    
        }
        else
        {
            this.courses[totalCourses++] = course;
            
        }
    }

    void displayCourses()
    {
        boolean flag=false;
        for(int i = 0; i < totalCourses; i++)
        {
            flag=true;
            System.out.println(i+1 + ". "+ courses[i].name);
        }
        if(!flag){
            System.out.println("No Courses Offered by "+this.getName()+" Department at the Moment");
        }
    }
}
