package onlineShop.models.purchases;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public class Payments {
    private int idPayment;
    private int idCustomer;
    private Timestamp paymentDateTime;
    private boolean paymentStatus;

    public Payments() {
    }

    public Payments(int idPayment, int idCustomer, Timestamp paymentDateTime, boolean paymentStatus) {
        this.idPayment = idPayment;
        this.idCustomer = idCustomer;
        this.paymentDateTime = paymentDateTime;
        this.paymentStatus = paymentStatus;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Timestamp getPaymentDateTime() {
        return paymentDateTime;
    }

    public void setPaymentDateTime(Timestamp paymentDateTime) {
        this.paymentDateTime = paymentDateTime;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payments payments = (Payments) o;
        return idPayment == payments.idPayment && idCustomer == payments.idCustomer && paymentStatus == payments.paymentStatus && Objects.equals(paymentDateTime, payments.paymentDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPayment, idCustomer, paymentDateTime, paymentStatus);
    }

    @Override
    public String toString() {
        return "Payments{" +
                "idPayment=" + idPayment +
                ", idCustomer=" + idCustomer +
                ", paymentDateTime=" + paymentDateTime +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
