package repository;

import model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext //dùng để tiêm EntityManager
    EntityManager entityManager;
    @Override
    public List<Customer> findAll() {
        String queryStr = "select c from Customer as c";
        List<Customer> customerList = entityManager.createQuery(queryStr,Customer.class).getResultList();
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        if(customer!=null){
            entityManager.merge(customer);//save
        } else {
            entityManager.persist(customer);//save
        }
    }

    @Override
    public void delete(Long id) {
        Customer customer = findById(id);
        if(customer!=null){
            entityManager.remove(customer);
        }
    }

    @Override
    public Customer findById(Long id) {
        String queryStr = "select c from Customer as c where c.id =:id";
        Customer customer = entityManager.createQuery(queryStr,Customer.class).setParameter("id",id).getSingleResult();
        return customer;
    }

    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        String sql = "CALL Insert_Customer(:nameInput, :addressInput)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("nameInput", customer.getName());
        query.setParameter("addressInput", customer.getAddress());
        return query.executeUpdate() == 0;
    }
}
