package onlineShop.taskJAXB;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExecutorJAXB {
    private static final Logger logger = LogManager.getLogger(ExecutorJAXB.class);

    public static void main(String[] args) {
        EmployeeJAXB employeeJABX1 = new EmployeeJAXB();
        employeeJABX1.setEmployeeName("Volodymyr");
        employeeJABX1.setEmployeeSurname("Kovalenko");
        employeeJABX1.setEmployeeContact("kovalenko@gmail.com");
        employeeJABX1.setEmployeeSalary(40000);

        EmployeeJAXB employeeJABX2 = new EmployeeJAXB();
        employeeJABX2.setEmployeeName("Eugene");
        employeeJABX2.setEmployeeSurname("Mironenko");
        employeeJABX2.setEmployeeContact("mironenko@gmail.com");
        employeeJABX2.setEmployeeSalary(40000);

        String fileName = "src/main/java/onlineShop/taskJAXB/Employees.xml";
        File file = Paths.get(fileName).toFile();

        //to XML

        List<EmployeeJAXB> employeeJABXList = new ArrayList<EmployeeJAXB>();
        EmployeesJAXB employeesJABX = new EmployeesJAXB();
        employeeJABXList.add(employeeJABX1);
        employeeJABXList.add(employeeJABX2);
        employeesJABX.setEmployeeJABXList(employeeJABXList);

        try {
            convertObjectToXML(employeesJABX, file);
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        //to Object

        EmployeesJAXB employeesJABXUN = new EmployeesJAXB();

        employeesJABXUN = convertXMLToObject(file);
        employeesJABXUN.outLogger();
    }

    private static void convertObjectToXML(EmployeesJAXB employeesJABX, File file) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(EmployeesJAXB.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(employeesJABX, System.out);

        // Write to File
        m.marshal(employeesJABX, file);
    }

    private static EmployeesJAXB convertXMLToObject(File file) {
        EmployeesJAXB employeesJABX = null;
        try {
            JAXBContext context = JAXBContext.newInstance(EmployeesJAXB.class);
            Unmarshaller un = context.createUnmarshaller();
            employeesJABX = (EmployeesJAXB) un.unmarshal(file);
            List<EmployeeJAXB> list = employeesJABX.getEmployeeJABXList();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return employeesJABX;
    }
}
