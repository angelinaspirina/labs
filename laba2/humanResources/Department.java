package humanResources;

public class Department
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

    public String getName() {
        return name;
    }

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
    public boolean remove(String firstName, String secondName)
    {
        for (int i = 0; i < size; i++)
        {
            if (employees[i].getFirstName().equals(firstName) && employees[i].getSecondName().equals(secondName))
            {
                System.arraycopy(employees, i+1, employees, i, size - (i+1));
                employees[size -1] = null;
                size--;
                return true;
            }
        }
        return false;
    }
    public int countEmployees()
    {
        return size;
    }
    public Employee[] getEmployees()
    {
        Employee[] newEmployees = new Employee[size];
        System.arraycopy(employees, 0, newEmployees, 0, size);
        return newEmployees;
    }

    public Employee[] getEmployeesByJobTitle(String jobTitle)
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
    public int amountEmployeesByJobTitle(String jobTitle)
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
}