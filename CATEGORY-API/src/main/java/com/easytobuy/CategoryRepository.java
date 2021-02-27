/**
 * 
 */
package com.easytobuy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author SatishReddy
 *
 */
public interface CategoryRepository  extends JpaRepository<Category,Long>{
	List<Category> findByCategoryName(String categoryName);
}
