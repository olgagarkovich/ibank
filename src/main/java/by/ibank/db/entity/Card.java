package by.ibank.db.entity;


/**
 * Created by Olga on 18.01.2017.
 */
public class Card implements Entity{

        private long id;
        private int department;
        private int status;
        private int balance;

    public Card(long id, int department, int status, int balance) {
        this.id = id;
        this.department = department;
        this.status = status;
        this.balance = balance;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
