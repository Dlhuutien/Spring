package fit.iuh.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fit.iuh.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	@Query(value = "SELECT * FROM category c where c.name like %:keyword% ", nativeQuery = true)
	List<Category> search(@Param("keyword") String keyword);
}