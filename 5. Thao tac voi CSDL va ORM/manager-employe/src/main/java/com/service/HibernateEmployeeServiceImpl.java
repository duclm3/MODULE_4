package com.service;

import com.model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class HibernateEmployeeServiceImpl implements IEmployeeService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Employee> findAll() {
        String queryStr = "SELECT e FROM Employee AS e";
        TypedQuery<Employee> query = entityManager.createQuery(queryStr, Employee.class);
        return query.getResultList(); //Lấy ra danh sách
    }

    @Override
    public Employee findById(Long id) {
        String queryStr = "SELECT e FROM Employee AS e WHERE e.id = :id";
        TypedQuery<Employee> query = entityManager.createQuery(queryStr, Employee.class);
        query.setParameter("id", id);
        try {
            Employee employee = query.getSingleResult();
            return employee;
        }catch (Exception e){ return null;}
    }

    @Override
    public Employee saveOrUpdate(Employee employee) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Employee origin = findById(employee.getId());
            System.out.println(origin);
            if(origin != null){
                origin.setName(employee.getName());
                origin.setAvatar(employee.getAvatar());
                origin.setDate(employee.getDate());
                origin.setGender(employee.getGender());
                session.update(origin);
                transaction.commit();
                return origin;
            }
            session.save(employee);
            transaction.commit();
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }


    @Override
    public void update(int id, Employee employee) {

    }

    @Override
    public void remove(Long id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Employee employee = findById(id);
            session.remove(employee);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
