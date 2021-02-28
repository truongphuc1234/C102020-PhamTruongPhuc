package com.codegym.cms.repository.impl;

import com.codegym.cms.model.Customer;
import com.codegym.cms.repository.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomerRepository implements Repository<Customer> {

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = em.createQuery("SELECT c from Customer As c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(long id) {
        TypedQuery<Customer> query = em
    }

    @Override
    public void save(Customer model) {

    }

    @Override
    public void remove(long id) {

    }
}
