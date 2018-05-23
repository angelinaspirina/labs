package humanResources;

public class Department implements EmployeeGroup
{
    private String name;
    private Employee[] employees;
    private int size;
    private final static int DEFAULT_LENGHT = 8;
    public Department(String name)
    {
        this(name, DEFAULT_LENGHT);
        size = 0;
    }
    public Department(String name, int lenght)
    {
        this.name = name;
        employees = new Employee[lenght];
        size = 0;
    }
    public Department(String name, Employee[] employees)
    {
        this.name = name;
        Employee[] newEmployees = new Employee[employees.length];
        System.arraycopy(employees, 0, newEmployees, 0, employees.length);
        this.employees = newEmployees;
        size = employees.length;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void add(Employee employee)
    {
        if(size == employees.length)
        {
            Employee[] newEmployees = new Employee[size * 2];
            System.arraycopy(employees, 0, newEmployees, 0, size);
            employees = newEmployees;
        }
        employees[size] = employee;
        size++;
    }
    @Override
    public void remove(String firstName, String secondName)
    {
        for (int i = 0; i < size; i++)
        {
            if (employees[i].getFirstName().equals(firstName) && employees[i].getSecondName().equals(secondName))
            {
                System.arraycopy(employees, i+1, employees, i, size - (i+1));
                employees[size -1] = null;
                size--;
            }
        }
    }
    @Override
    public void remove(Employee employee)
    {
        for (int i = 0; i < size; i++)
        {
            if (employees[i].equals(employee))
            {
                System.arraycopy(employees, i+1, employees, i, size - (i+1));
                employees[size -1] = null;
                size--;
            }
        }
    }
    public void removeAllByJobTitle(JobTitlesEnum jTitle)
    {
        for (int i = 0; i < size; i++)
        {
            if (employees[i].getJobTitle().equals(jTitle))
            {
                System.arraycopy(employees, i+1, employees, i, size - (i+1));
                employees[size -1] = null;
                size--;
            }
        }
    }
    @Override
    public int amountEmployees()
    {
        return size;
    }
    @Override
    public Employee[] getEmployees()
    {
        Employee[] newEmployees = new Employee[size];
        System.arraycopy(employees, 0, newEmployees, 0, size);
        return newEmployees;
    }
    @Override
    public Employee getEmployee(String fName, String sName)
    {
        for (int i = 0; i < size; i++)
        {
            if (employees[i].getFirstName().equals(fName) && employees[i].getSecondName().equals(sName))
            {
                return employees[i];
            }
        }
        return null;
    }

    public Employee[] getEmployeesByJobTitle(JobTitlesEnum jobTitle)
    {
        int newSize = 0;
        Employee[] newEmployees = new Employee[amountEmployeesByJobTitle(jobTitle)];
        for (int i = 0; i < size; i++)
        {
            if (employees[i].getJobTitle().equals(jobTitle))
            {
                newEmployees[newSize++] = employees[i];
            }
        }
        return newEmployees;
    }
    @Override
    public int amountEmployeesByJobTitle(JobTitlesEnum jobTitle)
    {
        int amount = 0;
        for (int i = 0; i < size; i++)
        {
            if (employees[i].getJobTitle().equals(jobTitle))
            {
                amount++;
            }
        }
        return amount;
    }

    public Employee[] getSortedEmployeesBySalary()
    {
        Employee swapBuf;
        Employee[] sortedArray = getEmployees();
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size - 1 - i; j++)
            {
                if (sortedArray[j].getSalary() > sortedArray[j + 1].getSalary())
                {
                    swapBuf = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = swapBuf;
                }
            }
        }
        return sortedArray;
    }
    public Employee bestEmployee()
    {
        double maxSalary = 0;
        Employee bestEmployee = null;
        for (int i = 0; i < size; i++)
        {
            if (employees[i].getSalary() > maxSalary)
            {
                maxSalary = employees[i].getSalary();
                bestEmployee = employees[i];
            }
        }
        return bestEmployee;
    }
    public boolean hasEmployee(String firstName, String secondName)
    {
        Employee employee;
        for (int i = 0; i < size; i++)
        {
            employee = employees[i];
            if (employee.getFirstName().equals(firstName) && employee.getSecondName().equals(secondName))
            {
                return true;
            }
        }
        return false;
    }
    public JobTitlesEnum[] getJobTitles()
    {
        int sizeTitles = 0;
        boolean check;
        JobTitlesEnum[] titles = new JobTitlesEnum[size];
        for (int i = 0; i < size; i++)
        {
            check = true;
            for (int j = 0; j < size; j++)
            {
                if(titles[j] != null && titles[j] == employees[i].getJobTitle())
                {
                    check = false;
                }
            }
            if(check)
            {
                titles[sizeTitles++] = employees[i].getJobTitle();
            }
        }
        JobTitlesEnum[] titlesRetutn = new JobTitlesEnum[sizeTitles];
        System.arraycopy(titles, 0, titlesRetutn, 0, sizeTitles);
        return titlesRetutn;
    }
    public Employee[] getEmployeesByBusinessTravelAtLeastOnce()
    {
        Employee[] employees = new Employee[size];
        int timeSize = 0;
        for (int i = 0; i < size; i++)
        {
            if (this.employees[i] instanceof BusinessTraveller && this.employees[i].countBusinessTravellers() > 0)
            {
                employees[timeSize++] = this.employees[i];

            }
        }
        Employee[] employeesReturn = new Employee[timeSize];
        System.arraycopy(employees, 0, employeesReturn, 0, timeSize);
        return employeesReturn;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        str.append("Department ").append(name).append(": ").append(size).append("\n");
        for (int i = 0; i < size; i++) {
            str.append(employees[i].toString()).append("\n");
        }
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
            Department department = (Department) obj;
            Employee thisEmployee, objEmployee;
            int checkSize = 0;
            if(this.name.equals(department.getName()) && this.size == department.getSize())
            {
                for(int i = 0; i < size; i++)
                {
                    thisEmployee = employees[i];
                    for (int j = 0; j < size; j++)
                    {
                        objEmployee = department.getEmployees()[j];
                        if(thisEmployee.equals(objEmployee))
                        {
                            checkSize++;
                            break;
                        }
                    }
                }
                if(checkSize == size) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else
                return false;
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = this.name.isEmpty() ? 0 : this.name.hashCode();
        result ^= this.size == 0 ? 0 : Integer.hashCode(this.size);
        for(int i = 0; i < size; i++)
        {
            result ^= employees[i].hashCode();
        }
        return result;
    }
}