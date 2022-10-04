package onlineShop.services.identification;

import onlineShop.models.people.Users;

public class EntryResult {
    private Users users;
    private boolean status;

    public EntryResult() {
    }

    public EntryResult(Users users, boolean status) {
        this.users = users;
        this.status = status;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
