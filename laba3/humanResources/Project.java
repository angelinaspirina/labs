package humanResources;

public class Project implements EmployeeGroup
{
    private String name;
    private nodeList<Employee> employees;
    public Project(String name)
    {
        this.name = name;
        employees = new nodeList<Employee>();
    }

    public Project(String name, Employee[] employees)
    {
        this.name = name;
        this.employees = new nodeList<Employee>(employees);
    }

    public int getSize()
    {
        return employees.getSize();
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
        employees.add(employee);
    }

    @Override
    public Employee getEmployee(String fName, String sName)
    {
        Employee employee;
        for(int i = 0; i < getSize(); i++)
        {
            employee = employees.getItem(i);
            if(employee.getFirstName().equals(fName) && employee.getSecondName().equals(sName))
            {
                return employees.getItem(i);
            }
        }
        return null;
    }

    @Override
    public void remove(String fName, String sName)
    {
        Employee employee;
        for(int i = 0; i < getSize(); i++)
        {
            employee = employees.getItem(i);
            if(employee.getFirstName().equals(fName) && employee.getSecondName().equals(sName))
            {
                employees.remove(i);
            }
        }
    }

    @Override
    public void remove(Employee employee) {
        employees.remove(employee);
    }

    @Override
    public Employee bestEmployee()
    {
        double maxSalary = 0;
        int bestIndex = 0;
        Employee employee;
        for(int i = 0; i < getSize(); i++)
        {
            employee = employees.getItem(i);
            if(employee.getSalary() > maxSalary)
            {
                maxSalary = employee.getSalary();
                bestIndex = i;
            }
        }
        return employees.getItem(bestIndex);
    }

    @Override
    public Employee[] getEmployees()
    {
        Employee[] employees = new Employee[getSize()];
        this.employees.toArray(employees);
        return employees;
    }

    @Override
    public Employee[] getSortedEmployeesBySalary() {
        Employee swapBuf;
        Employee[] tempSortedArray = getEmployees();
        for (int j = 0; j < getSize(); j++) {
            for (int k = 0; k < getSize() - 1 - j; k++) {
                if (tempSortedArray[k].getSalary() > tempSortedArray[k + 1].getSalary()) {
                    swapBuf = tempSortedArray[k];
                    tempSortedArray[k] = tempSortedArray[k + 1];
                    tempSortedArray[k + 1] = swapBuf;
                }
            }
        }
        return tempSortedArray;
    }

    @Override
    public int amountEmployees() {
        return getSize();
    }

    @Override
    public int amountEmployeesByJobTitle(JobTitlesEnum jTitle)
    {
        int amount = 0;
        Employee employee;
        for (int i = 0; i < getSize(); i++) {
            employee = employees.getItem(i);
            if (employee.getJobTitle().equals(jTitle)) {
                amount++;
            }
        }
        return amount;
    }

    @Override
    public boolean hasEmployee(String fName, String sName)
    {
        Employee employee;
        for(int i = 0; i < getSize(); i++)
        {
            employee = employees.getItem(i);
            if(employee.getFirstName().equals(fName) && employee.getSecondName().equals(sName))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString()
    {
        Employee employee;
        StringBuilder str = new StringBuilder("");
        str.append("Project ").append(name).append(": ").append(getSize()).append("\n");
        for(int i = 0; i < getSize(); i++)
        {
            employee = employees.getItem(i);
            str.append(employee.toString()).append("\n");
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
            Project project = (Project) obj;
            Employee thisEmployee, objEmployee;
            int checkSize = 0;
            if(this.name.equals(project.getName()) && this.getSize() == project.amountEmployees())
            {
                for(int i = 0; i < getSize(); i++)
                {
                    thisEmployee = employees.getItem(i);
                    for (int j = 0; j < getSize(); j++)
                    {
                        objEmployee = project.getEmployees()[j];
                        if(thisEmployee.equals(objEmployee))
                        {
                            checkSize++;
                            break;
                        }
                    }
                }
                if(checkSize == getSize()) {
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
        result ^= this.getSize() == 0 ? 0 : Integer.hashCode(this.getSize());
        for(int i = 0; i < getSize(); i++)
        {
            result ^= employees.getItem(i).hashCode();
        }
        return result;
    }
}
