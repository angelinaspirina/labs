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
    double getPremy() {
        return 0;
    }

    @Override
    void setPremy(double premy)
    {
    }
    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder("");
        if (!(secondName.equals(DEFAULT_STRING))) str.append(secondName).append(" ");
        if (!(firstName.equals(DEFAULT_STRING))) str.append(firstName).append(", ");
        if (!(jobTitle.equals(DEFAULT_TITLE))) str.append(jobTitle).append("(внешний совместитель), ");
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
            PartTimeEmployee temp = (PartTimeEmployee) obj;
            if(temp.firstName.equals(this.firstName) && temp.secondName.equals(this.secondName) && temp.jobTitle == this.jobTitle && temp.salary == this.salary)
                return true;
            else
                return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 17, resultfN = 17, resultsN = 17, resultsal = 17, resultjT = 17;
        resultfN = 37 * result + (this.firstName.equals("") ? 0 : this.firstName.hashCode());
        resultsN = 37 * result + (this.secondName.equals("") ? 0 : this.secondName.hashCode());
        resultjT = 37 * result + (this.jobTitle == JobTitlesEnum.NONE ? 0 : this.jobTitle.hashCode());
        long longBits = Double.doubleToLongBits(this.salary);
        resultsal = 37 * result + (int)(longBits - (longBits >>> 32));
        result = resultfN ^ resultsN;
        result ^= resultjT;
        result ^= resultsal;

        return result;
    }
}
