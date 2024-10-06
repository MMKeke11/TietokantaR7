package entity;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private int id;

    @Version
    private int version;

    @Convert(converter = NumberConverter.class)
    private Double balance;

    public Account() {
    }

    public Account(Double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
