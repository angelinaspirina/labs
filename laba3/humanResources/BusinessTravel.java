package humanResources;

public class BusinessTravel
{
    private final String nameCity;
    private final int days;
    private final double compensation;
    private final String description;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_DESCRIPTION = "";
    public static final int DEFAULT_COUNT = 0;
    public static final int DEFAULT_SUMM = 0;

    public BusinessTravel()
    {
        this(DEFAULT_NAME, DEFAULT_COUNT, DEFAULT_SUMM, DEFAULT_DESCRIPTION);
    }

    public BusinessTravel(String nameCity, int days, double compensation, String description)
    {
        this.nameCity = nameCity;
        this.days = days;
        this.compensation = compensation;
        this.description = description;
    }

    public String getNameCity() {
        return nameCity;
    }

    public int getDays() {
        return days;
    }

    public double getCompensation() {
        return compensation;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder("");
        if (!(nameCity.equals(""))) str.append(nameCity).append(" ");
        if (days != 0) str.append(days).append(" ");
        if (compensation != 0) str.append("(").append(compensation).append(") ");
        if (!(description.equals(""))) str.append(description).append(" ");
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
            BusinessTravel temp = (BusinessTravel) obj;
            if(temp.nameCity.equals(this.nameCity) && temp.days == this.days && temp.compensation == this.compensation && temp.description.equals(this.description))
                return true;
            else
                return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = this.nameCity.isEmpty() ? 0 : this.nameCity.hashCode();
        result ^= this.description.isEmpty() ? 0 : this.description.hashCode();
        result ^= this.days == 0 ? 0 : Integer.hashCode(this.days);
        result ^= this.compensation == 0 ? 0 : Double.hashCode(this.compensation);
        return result;
    }
}
