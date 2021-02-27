/**
 * 
 */
package com.easytobuy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author chiru
 *
 */
@Entity
@Table(name="coupon")
public class Coupon {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private Integer couponId;
	@Column(name="couponCode")
	private String couponCode;
	@Column(name="couponDiscount")
	private Double discount;
	public Integer getCouponId() {
		return couponId;
	}
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	
	
	

}
