package onlineShop.services.orderService;

import onlineShop.dao.idbcMySQL.people.CustomersDAO;
import onlineShop.dao.idbcMySQL.purchases.PaymentsDAO;
import onlineShop.models.people.Customers;
import onlineShop.models.people.Users;
import onlineShop.models.purchases.Payments;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;
import java.util.Date;

public class Payment {
    private static final Logger logger = LogManager.getLogger(Payment.class);
    public static void createPayment(Users users) {
        CustomersDAO customersDAO = new CustomersDAO();
        Customers customers = customersDAO.getById(users.getIdCustomer());
        PaymentsDAO paymentsDAO = new PaymentsDAO();
        Payments payments = new Payments();

        //payments.setIdPayment();

        java.util.Date d1 = new Date();
        Long l1 = d1.getTime();
        Timestamp timestamp = new Timestamp(l1);
        payments.setPaymentDateTime(timestamp);

        payments.setIdCustomer(customers.getIdCustomer());
        payments.setPaymentStatus(true);

        paymentsDAO.add(payments);
    }
}
