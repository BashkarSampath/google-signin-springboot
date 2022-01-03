package com.bashkarsampath.app.services.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bashkarsampath.app.entities.Product;
import com.bashkarsampath.app.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;

	public List<Product> listAll() {
		return repo.findAll();
	}

	public void save(Product product) {
		repo.save(product);
	}

	public Product get(Long id) {
		Optional<Product> product = repo.findById(id);
		if (product.isPresent())
			return product.get();
		else
			return null;
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
}