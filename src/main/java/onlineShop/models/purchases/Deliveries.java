package onlineShop.models.purchases;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public class Deliveries {
    private int idDelivery;
    private int idAddress;
    private int idUser;
    private Timestamp deliveryDataTime;
    private int idEmployee;

    public Deliveries() {
    }

    public Deliveries(int idDelivery, int idAddress, int idUser, Timestamp deliveryDataTime, int idEmployee) {
        this.idDelivery = idDelivery;
        this.idAddress = idAddress;
        this.idUser = idUser;
        this.deliveryDataTime = deliveryDataTime;
        this.idEmployee = idEmployee;
    }

    public int getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(int idDelivery) {
        this.idDelivery = idDelivery;
    }

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Timestamp getDeliveryDataTime() {
        return deliveryDataTime;
    }

    public void setDeliveryDataTime(Timestamp deliveryDataTime) {
        this.deliveryDataTime = deliveryDataTime;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deliveries that = (Deliveries) o;
        return idDelivery == that.idDelivery && idAddress == that.idAddress && idUser == that.idUser && idEmployee == that.idEmployee && Objects.equals(deliveryDataTime, that.deliveryDataTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDelivery, idAddress, idUser, deliveryDataTime, idEmployee);
    }

    @Override
    public String toString() {
        return "Deliveries{" +
                "idDelivery=" + idDelivery +
                ", idAddress=" + idAddress +
                ", idUser=" + idUser +
                ", deliveryDataTime=" + deliveryDataTime +
                ", idEmployee=" + idEmployee +
                '}';
    }
}
