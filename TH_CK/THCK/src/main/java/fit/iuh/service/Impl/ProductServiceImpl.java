package fit.iuh.service.Impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.iuh.entities.Product;
import fit.iuh.repositories.ProductRepository;
import fit.iuh.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public boolean existsByCategoryAndCode(int categoryId, String code) {
		return productRepository.existsByCategoryAndCode(categoryId, code);
	}

	@Override
	public List<Product> searchProducts(String categoryName, Boolean isActive, LocalDate startDate) {
	    return productRepository.searchProducts(categoryName, isActive, startDate);
	}

}