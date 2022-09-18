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
    private static final Logger LOGGER = LogManager.getLogger(EmployeeJABX.class);

    public static void main(String[] args) {
        EmployeeJABX employeeJABX1 = new EmployeeJABX();
        employeeJABX1.setEmployeeName("Volodymyr");
        employeeJABX1.setEmployeeSurname("Kovalenko");
        employeeJABX1.setEmployeeContact("kovalenko@gmail.com");
        employeeJABX1.setEmployeeSalary(40000);

        EmployeeJABX employeeJABX2 = new EmployeeJABX();
        employeeJABX2.setEmployeeName("Eugene");
        employeeJABX2.setEmployeeSurname("Mironenko");
        employeeJABX2.setEmployeeContact("mironenko@gmail.com");
        employeeJABX2.setEmployeeSalary(40000);

        List<EmployeeJABX> employeeJABXList = new ArrayList<EmployeeJABX>();
        List<EmployeeJABX> employeeJABXListUN = new ArrayList<EmployeeJABX>();
        employeeJABXList.add(employeeJABX1);
        employeeJABXList.add(employeeJABX1);

        try {
            marshal(employeeJABXList, new File("src/main/java/onlineShop/taskJAXB/Employees.xml"));
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        String fileName = "./Employees.xml";
        File file = Paths.get(fileName).toFile();

        try {
            employeeJABXListUN = unmarshal(file);
            employeeJABXListUN.forEach(LOGGER::info);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void marshal(List<EmployeeJABX> employeeJABXList, File selectedFile) throws IOException, JAXBException {
        JAXBContext context;
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(selectedFile));
        context = JAXBContext.newInstance(EmployeesJABX.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(new EmployeesJABX(employeeJABXList), writer);
        writer.close();
    }

    public static List<EmployeeJABX> unmarshal(File importFile) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(EmployeesJABX.class);
        try {
            return (List<EmployeeJABX>) context.createUnmarshaller().unmarshal(new FileReader(importFile));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
