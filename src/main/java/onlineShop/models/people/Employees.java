package onlineShop.models.people;

import java.util.Objects;

public class Employees {
    private int idEmployee;
    private String employeeName;
    private String employeeSurname;
    private String employeeContact;
    private double employeeSalary;

    public Employees() {
    }

    public Employees(int idEmployee, String employeeName, String employeeSurname, String employeeContact,
                     double employeeSalary) {
        this.idEmployee = idEmployee;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeeContact = employeeContact;
        this.employeeSalary = employeeSalary;
    }

    public Employees(String employeeName, String employeeSurname, String employeeContact,
                     double employeeSalary) {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeeContact = employeeContact;
        this.employeeSalary = employeeSalary;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public String getEmployeeContact() {
        return employeeContact;
    }

    public void setEmployeeContact(String employeeContact) {
        this.employeeContact = employeeContact;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return idEmployee == employees.idEmployee && Double.compare(employees.employeeSalary, employeeSalary) == 0 && employeeName.equals(employees.employeeName) && employeeSurname.equals(employees.employeeSurname) && employeeContact.equals(employees.employeeContact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmployee, employeeName, employeeSurname, employeeContact, employeeSalary);
    }

    @Override
    public String toString() {
        return "Employees{" +
                "idEmployee=" + idEmployee +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSurname='" + employeeSurname + '\'' +
                ", employeeContact='" + employeeContact + '\'' +
                ", employeeSalary=" + employeeSalary +
                '}';
    }
}
