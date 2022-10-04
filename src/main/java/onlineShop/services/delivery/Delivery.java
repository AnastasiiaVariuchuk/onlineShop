package onlineShop.services.delivery;

import onlineShop.dao.idbcMySQL.people.EmployeesDAO;
import onlineShop.dao.idbcMySQL.purchases.DeliveriesDAO;
import onlineShop.models.people.Employees;
import onlineShop.models.people.Users;
import onlineShop.models.places.Addresses;
import onlineShop.models.purchases.Deliveries;
import onlineShop.services.orderService.Payment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;
import java.util.Date;

public class Delivery {
    private static final Logger logger = LogManager.getLogger(Delivery.class);
    public static void createDelivery(Users users) {
        DeliveriesDAO deliveriesDAO = new DeliveriesDAO();
        long count = deliveriesDAO.getAll().stream().count();
        Deliveries deliveries = new Deliveries();
        deliveries.setIdDelivery((int) count + 100);

        Addresses addresses = AddLocation.addAddress(AddLocation.getCity(AddLocation.getCountry()));
        deliveries.setIdAddress(addresses.getIdAddress());

        deliveries.setIdUser(users.getIdUser());

        java.util.Date d1 = new Date();
        Long l1 = d1.getTime();
        Timestamp timestamp = new Timestamp(l1);
        deliveries.setDeliveryDataTime(timestamp);

        EmployeesDAO employeesDAO = new EmployeesDAO();
        int max = (int) employeesDAO.getAll().stream().count();
        int min = 1;
        int range = max - min + 1;
        deliveries.setIdEmployee((int)(Math.random() * range) + min);
        logger.info(employeesDAO.getById(deliveries.getIdEmployee()));
        deliveriesDAO.add(deliveries);
    }
}
