package application;

import dao.Dao;

public class app {

    public static void main(String[] args) {

        Dao dao = new Dao();
        dao.makeAccount(123.45);
        dao.makeAccount(100.00);
        dao.searchAccount(1);
        dao.transfer(1, 2, 50.00);

    }

}
