package fit.iuh.services;

import java.time.LocalDate;
import java.util.List;

import fit.iuh.entities.Product;

public interface ProductService {
	public List<Product> findAll();
	
	public void addProduct(Product product);
	
	boolean existsByCategoryAndCode(int categoryId, String code);
	
	List<Product> searchProducts(String categoryName, Boolean isActive, LocalDate startDate);

}