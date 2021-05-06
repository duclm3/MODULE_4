package repository;

import model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class BlogRepository implements IBlogRepository {
    @PersistenceContext //dùng để tiêm EntityManager
    EntityManager entityManager;
    @Override
    public List<Blog> findAll() {
        String queryStr = "select c from Blog as c";
        List<Blog> blogList = entityManager.createQuery(queryStr,Blog.class).getResultList();
        return blogList;
    }

    @Override
    public void save(Blog blog) {
        if(blog!=null){
            entityManager.merge(blog);//save
        } else {
            entityManager.persist(blog);//save
        }
    }

    @Override
    public void delete(Long id) {
        Blog blog = findById(id);
        if(blog!=null){
            entityManager.remove(blog);
        }
    }

    @Override
    public Blog findById(Long id) {
        String queryStr = "select c from Blog as c where c.id =:id";
        Blog blog = entityManager.createQuery(queryStr,Blog.class).setParameter("id",id).getSingleResult();
        return blog;
    }

}
