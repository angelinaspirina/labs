package humanResources;

public class PartTimeEmployee extends Employee
{
    private String firstName;
    private String secondName;
    private JobTitlesEnum jobTitle;
    private double salary;
    private final static String DEFAULT_STRING = "";
    private final static double DEFAULT_SALARY = 0;
    private final static JobTitlesEnum DEFAULT_TITLE = JobTitlesEnum.NONE;
    public PartTimeEmployee()
    {
        this(DEFAULT_STRING, DEFAULT_STRING, DEFAULT_TITLE, DEFAULT_SALARY);
    }
    public PartTimeEmployee(String firstName, String secondName)
    {
        this(firstName, secondName, DEFAULT_TITLE, DEFAULT_SALARY);
    }
    public PartTimeEmployee(String firstName, String secondName, JobTitlesEnum jobTitle, double salary)
    {
        this.firstName = firstName;
        this.secondName = secondName;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    @Override
    public int countBusinessTravellers() {
        return 0;
    }

    @Override
    double getPremy() {
        return 0;
    }

    @Override
    void setPremy(double premy)
    {
    }
}
