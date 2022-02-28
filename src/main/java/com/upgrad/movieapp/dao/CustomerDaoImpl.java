package com.upgrad.movieapp.dao;

import com.upgrad.movieapp.entities.Customer;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;


/*@Repository annotation creates a spring bean for the marked class in IOC container.
 * And converts all checked JDBC exceptions into unchecked Spring exceptions.*/

@Repository
public class CustomerDaoImpl implements CustomerDao{

    private SessionFactory sessionFactory; //using it for CRUD operations -> SessionFactory object is alive for whole application

    //EntityManager is wrapper for SessionFactory object
    public CustomerDaoImpl(EntityManager entityManager){
        this.sessionFactory=entityManager.unwrap(SessionFactory.class);
    }

    @Override
    public Customer save(Customer customer) {
        Session session = this.sessionFactory.openSession(); //Sesssion object is alive for one particular transaction

        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();

        return customer;
    }

    @Override
    public Customer findById(int id) {
        Session session = this.sessionFactory.openSession(); //Sesssion object is alive for one particular transaction

        Transaction transaction = session.beginTransaction();
        Customer customer = session.get(Customer.class,id);
        transaction.commit();
        session.close();

        return customer;
    }

    @Override
    public Customer update(Customer customer) {
        Session session = this.sessionFactory.openSession(); //Sesssion object is alive for one particular transaction

        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();

        return customer;
    }

    @Override
    public void delete(Customer customer) {
        Session session = this.sessionFactory.openSession(); //Sesssion object is alive for one particular transaction

        Transaction transaction = session.beginTransaction();
        Customer mergedCustomer = (Customer) session.merge(customer);
        session.delete(customer);
        transaction.commit();
        session.close();

        System.out.println("Resource deleted.");
    }
}
