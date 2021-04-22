package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> productList;

    static {

        productList = new HashMap<>();
        productList.put(1, new Product(1, "Pro 1",10, "this is product", "Hanoi"));
        productList.put(2, new Product(2, "Pro 2",11, "this is product", "Danang"));
        productList.put(3, new Product(3, "Pro 3",12, "this is product", "Saigon"));
        productList.put(4, new Product(4, "Pro 4",13, "this is product", "Beijin"));
        productList.put(5, new Product(5, "Pro 5",14, "this is product", "Miami"));
        productList.put(6, new Product(6, "Pro 6",15, "this is product", "Newyork"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> listSearch = new ArrayList<>();
        for(Product product : findAll()){
            if(product.getName().contains(name)){
                listSearch.add(product);
            }
        }
        return listSearch;
    }
}
