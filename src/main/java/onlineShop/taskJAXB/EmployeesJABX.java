package onlineShop.taskJAXB;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "employees")
public class EmployeesJABX {
    @XmlElement(name = "employee", type = EmployeeJABX.class)
    private List<EmployeeJABX> employeeJABXList = new ArrayList<EmployeeJABX>();

    public EmployeesJABX() {}

    public EmployeesJABX(List<EmployeeJABX> employeeJABXList) {
        this.employeeJABXList = employeeJABXList;
    }

    public List<EmployeeJABX> getEmployeeJABXList() {
        return employeeJABXList;
    }

    public void setEmployeeJABXList(List<EmployeeJABX> employeeJABXList) {
        this.employeeJABXList = employeeJABXList;
    }
}
