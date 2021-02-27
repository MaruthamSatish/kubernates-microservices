/**
 * 
 */
package com.easytobuy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author SatishReddy
 *
 */
@CrossOrigin("http://localhost:8088")
@RepositoryRestResource(collectionResourceRel ="category",path = "category")
public interface CategoryRepository  extends JpaRepository<Category,Long>{
	List<Category> findByCategoryName(String categoryName);
}
