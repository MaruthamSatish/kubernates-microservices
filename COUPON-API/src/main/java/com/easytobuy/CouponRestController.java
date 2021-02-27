package com.easytobuy;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CouponRestController {
	@Autowired
	private CouponRepository couponRepository;

	@RequestMapping(value = "/coupons/{couponCode}", method = RequestMethod.GET)
	public ResponseEntity<List<Coupon>> findByCouponCode(@PathVariable("couponCode") String couponCode) {
		List<Coupon> getCoupons = couponRepository.findByCouponCode(couponCode);
		if (getCoupons.isEmpty()) {
			System.out.println("Updated");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Coupon>>(getCoupons, HttpStatus.OK);
	}

	@GetMapping("/coupons")
	public ResponseEntity<List<Coupon>> getAllCoupons() {
		List<Coupon> getAllCoupons = couponRepository.findAll().stream().collect(Collectors.toList());
		return new ResponseEntity<List<Coupon>>(getAllCoupons, HttpStatus.OK);

	}

	@PostMapping("/coupons")
	public ResponseEntity<Coupon> saveCoupon(@RequestBody Coupon coupons) {
		try {
			couponRepository.save(coupons);
			return new ResponseEntity<Coupon>(coupons, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/coupons/{couponId}")
	public HttpStatus deleteCoupon(@PathVariable("couponId") Integer couponId) {
		Optional<Coupon> coupon = couponRepository.findById(couponId);
		if (coupon.isPresent()) {
			couponRepository.deleteById(couponId);
			return HttpStatus.NO_CONTENT;
		} else {
			return HttpStatus.NOT_FOUND;
		}
	}
}
