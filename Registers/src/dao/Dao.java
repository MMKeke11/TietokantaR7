package dao;

import entity.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Dao {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbteht");


    public void makeAccount(double balance) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Account account = new Account();
        account.setBalance(balance);
        em.persist(account);

        em.getTransaction().commit();
        em.close();
    }
    //search account by id
    public void searchAccount(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Account account = em.find(Account.class, id);

        em.getTransaction().commit();
        em.close();

        System.out.println(account.getBalance());
    }

    public void transfer(int fromId, int toId, double amount) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Account sender = em.find(Account.class, fromId);
        Account receiver = em.find(Account.class, toId);

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        em.getTransaction().commit();
        em.close();
    }

}
