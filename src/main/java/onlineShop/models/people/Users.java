package onlineShop.models.people;

import java.util.Objects;

public class Users {
    private int idUser;
    private String userName;
    private String userEmail;
    private String userPassword;
    private int idCustomer;

    public Users() {
    }

    public Users(int idUser, String userName, String userEmail, String userPassword, int idCustomer) {
        this.idUser = idUser;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.idCustomer = idCustomer;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return idUser == users.idUser && idCustomer == users.idCustomer && userName.equals(users.userName) && userEmail.equals(users.userEmail) && userPassword.equals(users.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, userName, userEmail, userPassword, idCustomer);
    }

    @Override
    public String toString() {
        return "Users{" +
                "idUser=" + idUser +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", idCustomer=" + idCustomer +
                '}';
    }
}
