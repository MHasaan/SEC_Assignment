import java.util.Scanner;

class Teacher extends User 
{
    // Courses assigned to teacher
    Course[] courses;
    int totalCourses;

    Teacher(String name, String password) 
    {
        super(name, password);
        courses = new Course[5]; // Maximum courses assigned
        totalCourses = 0;
    }

    // Assign a course to the teacher
    void assignCourse(Course course)        //used by Department only
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

///////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

// Teacher portal
    void teacherPortal(Department department)
    {
        Scanner input = new Scanner(System.in);
        boolean condition = true;
        while (condition)
        {
            System.out.println("===========================================");
            System.out.println("|               MENU SELECTION            |");
            System.out.println("===========================================");
            System.out.println("| Options:                                |");
            System.out.println("|        1. View Assigned Courses         |");
            System.out.println("|        2. View Marks and Attendence     |");
            System.out.println("|        3. Upload Marks                  |");
            System.out.println("|        4. Upload Attendence             |");
            System.out.println("|        5. Exit                          |");
            System.out.println("===========================================");
            System.out.print("Select option: ");
            int selection = input.nextInt();
            switch (selection) 
            {
                case 1:
                    displayAssignedCourses();
                    break;
                case 2:
                    dispalyStudentsReport();
                    break;
                case 3:
                    uploadMarks();
                    break;
                case 4:
                    upoadAttendence();
                    break;
                case 5:
                    System.out.println("Exit selected");
                    condition = true;
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        }
        input.close();
    }


    void displayAssignedCourses() 
    {
        System.out.println("Assigned Courses:");
        int counter = 1;
        for (Course course : courses) 
        {
            if (course != null) 
            {
                System.out.println(counter++ + "." + course.getName());
            }
        }
    }

    void dispalyStudentsReport()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Select course: \n Press 0 to Select All Courses");
        displayAssignedCourses();
        int courseIndex = input.nextInt();
        input.close();
        for (Course course : courses) 
        {
            if (course != null && ( courseIndex == 0 || course == courses[courseIndex - 1] ) )
            {
                course.displayStudentsReport();
                break;
            }
        }
    }

    void uploadMarks()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Select course: \n Press 0 to Select All Courses");
        displayAssignedCourses();
        int courseIndex = input.nextInt();

        for (Course course : courses) 
        {
            if (course != null && ( courseIndex == 0 || course == courses[courseIndex - 1] ) )
            {
                System.out.println("course: " + course.getName());
                System.out.println("Select student: \n Press 0 to Enter Marks for All Students");
                course.displayStudents();
                int studentIndex = input.nextInt();

                for (int i = 0; i < course.totalStudents; i++) 
                {
                    if (studentIndex == 0 || i == studentIndex - 1) 
                    {
                        System.out.print("Name: " + course.students[i].getName() + "Enter marks: ");
                        int marks = input.nextInt();
                        course.uploadMarks(i, marks);
                    }
                }
            }
        }
        input.close();
    }

    void upoadAttendence()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Select course: \n Press 0 to Select All Courses");
        displayAssignedCourses();
        int courseIndex = input.nextInt();

        for (Course course : courses) 
        {
            if (course != null && ( courseIndex == 0 || course == courses[courseIndex - 1] ) )
            {
                System.out.println("course: " + course.getName());
                System.out.println("Select student: \n Press 0 to Enter Attendence for All Students");
                course.displayStudents();
                int studentIndex = input.nextInt();

                for (int i = 0; i < course.totalStudents; i++) 
                {
                    if (studentIndex == 0 || i == studentIndex - 1) 
                    {
                        System.out.print("Name: " + course.students[i].getName() + "Enter attendence: ");
                        int attendence = input.nextInt();
                        course.recordAttendance(i, attendence);
                    }
                }
            }
        }
        input.close();
    }

}
