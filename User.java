public class User 
{
    // Name of the user
    String name;
    // Password for authentication
    String password;

    // Constructor to initialize user details
    User(String name, String password) 
    {
        this.name = name;
        this.password = password;
    }

    public String getName() 
    {
        return name;
    }
}
