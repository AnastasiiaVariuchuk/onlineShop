package onlineShop.taskJAXB;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "employees")
public class EmployeesJAXB {
    @XmlElement(name = "employee", type = EmployeeJAXB.class)
    private List<EmployeeJAXB> employeeJABXList = new ArrayList<EmployeeJAXB>();
    private static final Logger logger = LogManager.getLogger(EmployeesJAXB.class);

    public EmployeesJAXB() {}

    public void outLogger() {
        for(EmployeeJAXB employeeJABX: employeeJABXList){
            logger.info (employeeJABX.toString());
        }
    }

    public EmployeesJAXB(List<EmployeeJAXB> employeeJABXList) {
        this.employeeJABXList = employeeJABXList;
    }

    public List<EmployeeJAXB> getEmployeeJABXList() {
        return employeeJABXList;
    }

    public void setEmployeeJABXList(List<EmployeeJAXB> employeeJABXList) {
        this.employeeJABXList = employeeJABXList;
    }
}
