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

    public int getSize()
    {
        return businessTravelNodeList.getSize();
    }

    @Override
    public int countBusinessTravellers()
    {
        return businessTravelNodeList.getSize();
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
        BusinessTravel[] businessTravels = new BusinessTravel[businessTravelNodeList.getSize()];
        businessTravelNodeList.toArray(businessTravels);
        return businessTravels;
    }

    @Override
    public String toString()
    {

        StringBuilder str = new StringBuilder("");
        str.append(super.toString());
        str.append(premy).append("p. ");
        str.append("Командировки: ");
        for (int i = 0; i < getSize(); i++)
        {
            str.append(businessTravelNodeList.getItem(i).toString());
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object obj)
    {
        StaffEmployee sEmployeeObj = (StaffEmployee)obj;
        BusinessTravel[] busTravListObj = sEmployeeObj.arrayOfBusinessTravel();
        boolean checkHas = true;
        if (super.equals(obj))
        {
            for (int i = 0; i < getSize(); i++) {
                if (!businessTravelNodeList.contains(busTravListObj[i]))
                {
                    checkHas = false;
                }
            }
        }
        return checkHas;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = super.hashCode();
        result ^= this.premy == 0 ? 0 : Double.hashCode(this.premy);
        for (int i = 0; i < getSize(); i++)
        {
            result ^= businessTravelNodeList.getItem(i).hashCode();
        }
        return result;
    }
}