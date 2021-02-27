/**
 * 
 */
package com.easytobuy;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SatishReddy
 *
 */
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class CategoryRestController {
	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getCategories() {
		List<Category> getCategories = categoryRepository.findAll().stream().collect(Collectors.toList());
		return new ResponseEntity<List<Category>>(getCategories, HttpStatus.OK);

	}

	@PostMapping("/categories")
	public ResponseEntity<Category> saveCoupon(@RequestBody Category category) {
		try {
			categoryRepository.save(category);
			return new ResponseEntity<Category>(category, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/categories/{categoryName}", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> findByCouponCode(@PathVariable("categoryName") String categoryName) {
		List<Category> getCategories = categoryRepository.findByCategoryName(categoryName);
		if (getCategories.isEmpty()) {
			System.out.println("Updated");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Category>>(getCategories, HttpStatus.OK);
	}
	@DeleteMapping("/categories/{categoryId}")
	public HttpStatus deleteCoupon(@PathVariable("categoryId") Integer categoryId) {
		Optional<Category> category = categoryRepository.findById(Long.valueOf(categoryId));
		if (category.isPresent()) {
			categoryRepository.deleteById(Long.valueOf(categoryId));
			return HttpStatus.NO_CONTENT;
		} else {
			return HttpStatus.NOT_FOUND;
		}
	}
}
