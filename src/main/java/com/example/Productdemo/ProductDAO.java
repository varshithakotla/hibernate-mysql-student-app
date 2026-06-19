package com.example.Productdemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProductDAO {

    // Built once and reused for the whole application
    private static final SessionFactory factory =
            new Configuration().configure().buildSessionFactory();

    // CREATE
    public void saveProduct(Product product) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(product);
        tx.commit();
        session.close();
    }

    // READ ALL
    public List<Product> getAllProducts() {
        Session session = factory.openSession();
        List<Product> products =
                session.createQuery("FROM Product", Product.class).list();
        session.close();
        return products;
    }

    // READ ONE (used by update)
    public Product getProduct(int id) {
        Session session = factory.openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    // UPDATE
    public void updateProduct(Product product) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(product);
        tx.commit();
        session.close();
    }

    // DELETE
    public void deleteProduct(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Product product = session.get(Product.class, id);
        if (product != null) {
            session.remove(product);
        }
        tx.commit();
        session.close();
    }
}

