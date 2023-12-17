import java.util.Scanner;

public class Student extends User 
{
    // Courses registered by the student
    Course[] courses;
    int totalCourses;

    // Constructor to initialize student details
    Student(String name, String password) 
    {
        super(name, password);
        courses = new Course[5];
        totalCourses = 0;
    }

 
///////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////


    void studentPortal(Department department)
    {
        Scanner input = new Scanner(System.in);
        boolean condition = true;
        while (condition)
        {
            System.out.println("===========================================");
            System.out.println("|               MENU SELECTION            |");
            System.out.println("===========================================");
            System.out.println("| Options:                                |");
            System.out.println("|        1. Register Course               |");
            System.out.println("|        2. View Registered Courses       |");
            System.out.println("|        3. View Results                  |");
            System.out.println("|        4. Exit                          |");
            System.out.println("===========================================");
            System.out.print("Select option: ");
            int selection = input.nextInt();
            switch (selection) 
            {
                case 1:
                    registerCourseToStudent(department);
                    break;
                case 2:
                    displayRegisteredCourses();
                    break;
                case 3:
                    viewResults();
                    break;
                case 4:
                    System.out.println("Exit selected");
                    condition = false;
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        }
        input.close();
    }


    void registerCourseToStudent(Department department)
    {
        Scanner input = new Scanner(System.in);
        int index = 0;
        department.displayCourses();
        System.out.println("Select the course: \n Press");
        index = input.nextInt();
        System.out.println(courses[index-1].name + " selected");
        registerCourse(courses[index-1]);
        input.close();
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
            course.registerStudent(this); // Add student to the course
        }
    }


    void displayRegisteredCourses()
    {
        for(int i = 0; i < totalCourses; i++)
        {
            System.out.println("Course: " + courses[i].name);
        }
    }

    // View student's results for all registered courses
    void viewResults() 
    {
        for (int i = 0; i < totalCourses; i++) 
        {
                System.out.println("===========================================");
                System.out.println("Course: " + courses[i].name);
                System.out.println("Marks: " + courses[i].viewMarks(i));
                System.out.println("Attendance: " + courses[i].viewAttendance(i));
        }
    }
}
