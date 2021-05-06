package service;

import model.Blog;
import model.Customer;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void save(Blog blog);
    void delete(Long id);
    Blog findById(Long id);
//    boolean insertWithStoredProcedure(Customer customer);

}
