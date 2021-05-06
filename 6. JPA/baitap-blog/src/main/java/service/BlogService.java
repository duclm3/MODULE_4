package service;

import model.Blog;
import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IBlogRepository;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog customer) {
        blogRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        blogRepository.delete(id);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

}
