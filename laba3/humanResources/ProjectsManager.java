package humanResources;

public class ProjectsManager implements GroupsManager
{
    private nodeList<EmployeeGroup> groupNodeList;

    public ProjectsManager()
    {
        groupNodeList = new nodeList<EmployeeGroup>();
    }

    public ProjectsManager(EmployeeGroup[] employeeGroups)
    {
        groupNodeList = new nodeList<EmployeeGroup>(employeeGroups);
    }

    public int getSize()
    {
        return groupNodeList.getSize();
    }

    @Override
    public void add(EmployeeGroup employeeGroup)
    {
        groupNodeList.add(employeeGroup);
    }

    @Override
    public int amountGroups()
    {
        return getSize();
    }

    @Override
    public int remove(EmployeeGroup employeeGroup)
    {
        EmployeeGroup group;
        int count = 0;
        for(int i = 0; i < getSize(); i++)
        {
            group = groupNodeList.getItem(i);
            if(group.equals(employeeGroup))
            {
                groupNodeList.remove(i);
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean remove(String name)
    {
        EmployeeGroup group;
        for(int i = 0; i < getSize(); i++)
        {
            group = groupNodeList.getItem(i);
            if(group.getName().equals(name))
            {
                groupNodeList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public EmployeeGroup getGroup(String name)
    {
        EmployeeGroup group;
        for(int i = 0; i < getSize(); i++)
        {
            group = groupNodeList.getItem(i);
            if(group.getName().equals(name))
            {
                return groupNodeList.getItem(i);
            }
        }
        return null;
    }

    @Override
    public EmployeeGroup[] getEmployeeGroups()
    {
        EmployeeGroup[] employeeGroups = new EmployeeGroup[getSize()];
        groupNodeList.toArray(employeeGroups);
        return employeeGroups;
    }



    @Override
    public int amountEmployees()
    {
        int amount = 0;
        EmployeeGroup employeeGroup;
        for(int i = 0; i < getSize(); i++)
        {
            employeeGroup = groupNodeList.getItem(i);
            amount += employeeGroup.amountEmployees();
        }
        return amount;
    }

    @Override
    public int amountEmployeesByJobTitle(JobTitlesEnum title)
    {
        int amount = 0;
        EmployeeGroup employeeGroup;
        for(int i = 0; i < getSize(); i++)
        {
            employeeGroup = groupNodeList.getItem(i);
            amount += employeeGroup.amountEmployeesByJobTitle(title);
        }
        return amount;
    }

    @Override
    public Employee bestEmployee()
    {
        double maxSalary = 0;
        Employee employee, bestEmployee = null;
        EmployeeGroup employeeGroup;
        for (int i = 0; i < getSize(); i++) {
            employeeGroup = groupNodeList.getItem(i);
            employee = employeeGroup.bestEmployee();
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                bestEmployee = employee;
            }
        }
        return bestEmployee;
    }

    @Override
    public EmployeeGroup getGroupOfAnEmployee(String fName, String sName)
    {
        EmployeeGroup employeeGroup;
        for (int i = 0; i < getSize(); i++) {
            employeeGroup = groupNodeList.getItem(i);
            if(employeeGroup.hasEmployee(fName,sName))
            {
                return employeeGroup;
            }
        }
        return null;
    }
}
