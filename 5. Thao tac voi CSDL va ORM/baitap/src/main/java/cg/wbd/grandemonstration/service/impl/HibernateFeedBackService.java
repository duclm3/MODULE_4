package cg.wbd.grandemonstration.service.impl;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.model.FeedBack;
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
public class HibernateFeedBackService {
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

    public FeedBack findOne(Long id) {
        String queryStr = "SELECT f FROM FeedBack AS f WHERE f.id = :id";
        TypedQuery<FeedBack> query = entityManager.createQuery(queryStr, FeedBack.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<FeedBack> findAll() {
        String queryStr = "SELECT f FROM FeedBack AS f";
        TypedQuery<FeedBack> query = entityManager.createQuery(queryStr, FeedBack.class);
        return query.getResultList();
    }


    public FeedBack save(FeedBack feedBack) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(feedBack);
            transaction.commit();
            return feedBack;
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
    public FeedBack update(FeedBack feedBack) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            FeedBack origin = findOne(feedBack.getId());
            origin.setQuantityLike(feedBack.getQuantityLike());
            origin.setRate(feedBack.getRate());
            origin.setContent(feedBack.getContent());
            origin.setNameAuthor(feedBack.getNameAuthor());
            session.update(origin);
            transaction.commit();
            System.out.println(origin);
            return origin;
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
}
