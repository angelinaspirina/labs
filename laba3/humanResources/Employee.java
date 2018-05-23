package humanResources;

public abstract class Employee {
    private String firstName;
    private String secondName;
    private JobTitlesEnum jobTitle;
    private double salary;
    private final static String DEFAULT_STRING = "";
    private final static double DEFAULT_SALARY = 0;
    private final static JobTitlesEnum DEFAULT_TITLE = JobTitlesEnum.NONE;
    protected Employee()
    {
        this(DEFAULT_STRING, DEFAULT_STRING, DEFAULT_TITLE, DEFAULT_SALARY);
    }
    protected Employee(String firstName, String secondName)
    {
        this(firstName, secondName, DEFAULT_TITLE, DEFAULT_SALARY);
    }
    protected Employee(String firstName, String secondName, JobTitlesEnum jobTitle, double salary)
    {
        this.firstName = firstName;
        this.secondName = secondName;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public abstract int countBusinessTravellers();

    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public JobTitlesEnum getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(JobTitlesEnum jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    abstract double getPremy();
    abstract void setPremy(double premy);

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder("");
        if (!(secondName.equals(DEFAULT_STRING))) str.append(secondName).append(" ");
        if (!(firstName.equals(DEFAULT_STRING))) str.append(firstName).append(", ");
        if (!(jobTitle.equals(DEFAULT_TITLE))) str.append(jobTitle).append(", ");
        if (salary != DEFAULT_SALARY) str.append(salary).append("p. ");
        return str.toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj == this)
            return true;

        if(obj == null)
            return false;

        if(!(getClass() == obj.getClass()))
            return false;
        else
        {
            Employee temp = (Employee) obj;
            if(temp.firstName.equals(this.firstName) && temp.secondName.equals(this.secondName) && temp.jobTitle == this.jobTitle && temp.salary == this.salary)
                return true;
            else
                return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 31;
        result = this.firstName.isEmpty() ? 0 : this.firstName.hashCode();
        result ^= this.secondName.isEmpty() ? 0 : this.secondName.hashCode();
        result ^= this.jobTitle == JobTitlesEnum.NONE ? 0 : this.jobTitle.hashCode();
        result ^= this.salary == 0 ? 0 : Double.hashCode(this.salary);
        return result;
    }
}