/**
 * 
 */
package com.easytobuy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * @author SatishReddy
 *
 */
@FeignClient(name = "COUPON-API")
public interface CouponProxy {
	@RequestMapping(value = "/api/coupons/{couponCode}", method = RequestMethod.GET)
	List<Coupon> findByCouponCode(@PathVariable("couponCode")String couponCode);
}
