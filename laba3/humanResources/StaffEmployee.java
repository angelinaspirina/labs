package humanResources;

public class StaffEmployee extends Employee implements BusinessTraveller
{
    private static final double DEFAULT_PREMY = 0;
    private String firstName;
    private String secondName;
    private JobTitlesEnum jobTitle;
    private double premy;
    private double salary;
    private cycleNodeList<BusinessTravel> businessTravelNodeList;
    public static final BusinessTravel[] DEFAULT_NODE = null;
    public static final JobTitlesEnum DEFAULT_TITLE = JobTitlesEnum.NONE;
    public static final double DEFAULT_SALARY = 0;
    public StaffEmployee(String firstName, String secondName)
    {
        this(firstName, secondName, DEFAULT_TITLE, DEFAULT_SALARY, DEFAULT_NODE);
        this.premy = DEFAULT_PREMY;
        businessTravelNodeList = new cycleNodeList<>();
    }
    public StaffEmployee(String firstName, String secondName, JobTitlesEnum jobTitle, double salary)
    {
        this(firstName, secondName, jobTitle, salary, DEFAULT_NODE);
        this.premy = DEFAULT_PREMY;
        businessTravelNodeList = new cycleNodeList<>();
    }
    public StaffEmployee(String firstName, String secondName, JobTitlesEnum jobTitle, double salary, BusinessTravel[] businessTravels)
    {
        this.firstName = firstName;
        this.secondName = secondName;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.premy = DEFAULT_PREMY;
        businessTravelNodeList = new cycleNodeList<>(businessTravels);
    }

    @Override
    double getPremy()
    {
        return premy;
    }

    @Override
    void setPremy(double premy)
    {
        this.premy = premy;
    }

    @Override
    public void addInfoOfBusinessTravel(BusinessTravel businessTravel)
    {
        businessTravelNodeList.add(businessTravel);
    }

    @Override
    public BusinessTravel[] arrayOfBusinessTravel() {
        BusinessTravel[] businessTravels = new BusinessTravel[businessTravelNodeList.length()];
        businessTravelNodeList.toArray(businessTravels);
        return businessTravels;
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder("");
        if (!(secondName.equals(""))) str.append(secondName).append(" ");
        if (!(firstName.equals(""))) str.append(firstName).append(", ");
        if (jobTitle != JobTitlesEnum.NONE) str.append(jobTitle).append(", ");
        if (salary != 0) str.append(salary).append("p., ");
        str.append(premy).append("p. ");
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
            if(temp.getFirstName().equals(this.firstName) && temp.getSecondName().equals(this.secondName) && temp.getJobTitle() == this.jobTitle && temp.getSalary() == this.salary)
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