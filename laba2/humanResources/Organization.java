package humanResources;

public class Organization
{
    private String name;
    private Department[] departments;
    private int size;
    private final static int DEFAULT_LENGHT = 8;

    public Organization()
    {
        this("");
    }
    public Organization(String name)
    {
        this.name = name;
        departments = new Department[DEFAULT_LENGHT];
        size = 0;
    }
    public Organization(String name, Department[] departments)
    {
        this.name = name;
        Department[] newDepartments = new Department[departments.length];
        System.arraycopy(departments, 0, newDepartments, 0, departments.length);
        this.departments = newDepartments;
        size = departments.length;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void add(Department department)
    {
        if(size == departments.length)
        {
            Department[] newDepartments = new Department[size * 2];
            System.arraycopy(departments, 0, newDepartments, 0, size);
            departments = newDepartments;
        }
        departments[size] = department;
        size++;
    }

    public void remove(String name)
    {
        for (int i = 0; i < size; i++)
        {
            if (departments[i].getName().equals(name))
            {
                System.arraycopy(departments, i+1, departments, i, size - (i+1));
                departments[size -1] = null;
                size--;
            }
        }
    }
    public Department getDepartment(String name)
    {
        for (int i = 0; i < size; i++)
        {
            if(departments[i].getName().equals(name))
            {
                return departments[i];
            }
        }
        return null;
    }
    public Department[] getDepartments()
    {
        Department[] newDepartments = new Department[size];
        System.arraycopy(departments, 0, newDepartments, 0, size);
        return newDepartments;
    }
    public int countDepartments()
    {
        return size;
    }
    public int countEmployees()
    {
        int count = 0;
        for (int i = 0; i < size; i++)
        {
            count += departments[i].countEmployees();
        }
        return count;
    }
    public int countEmployeesByJobTitle(String jobTitle)
    {
        int count = 0;
        for (int i = 0; i < size; i++)
        {
            count += departments[i].amountEmployeesByJobTitle(jobTitle);
        }
        return count;
    }
    public Employee bestEmployee()
    {
        double maxSalary = 0;
        Employee employee, bestEmployee = null;
        Department department;
        for (int i = 0; i < size; i++)
        {
            department = departments[i];
            employee = department.bestEmployee();
            if (employee.getSalary() > maxSalary)
            {
                maxSalary = employee.getSalary();
                bestEmployee = employee;
            }
        }
        return bestEmployee;
    }

    public Department getDepartmentHasEmployee(String firstName, String secondName) {
        Department department;
        for (int i = 0; i < size; i++) {
            department = departments[i];
            if (department.hasEmployee(firstName, secondName))
            {
                return department;
            }
        }
        return null;
    }
}