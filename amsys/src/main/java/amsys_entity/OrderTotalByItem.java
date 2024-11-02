/**
 * OrderTotalByItem.java
 *
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 */

package amsys_entity;

/**
 *
 * @author FLM
 * @version 1.0.0
 */
public class OrderTotalByItem {
	private String itemCode;
	private String itemName;
	private int totalAmount;
	private int price;
	private int totalPrice;
	/**
	 *
	 */
	public OrderTotalByItem() {
		super();
	}
	/**
	 * @param itemCode
	 * @param itemName
	 * @param totalAmount
	 * @param price
	 * @param totalPrice
	 */
	public OrderTotalByItem(String itemCode, String itemName, int totalAmount,
			int price, int totalPrice) {
		super();
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.totalAmount = totalAmount;
		this.price = price;
		this.totalPrice = totalPrice;
	}
	/**
	 * itemCodeのGetter
	 * @return itemCode
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * itemCodeのSetter
	 * @param itemCode
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	/**
	 * itemNameのGetter
	 * @return itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * itemNameのSetter
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * totalAmountのGetter
	 * @return totalAmount
	 */
	public int getTotalAmount() {
		return totalAmount;
	}
	/**
	 * totalAmountのSetter
	 * @param totalAmount
	 */
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * priceのGetter
	 * @return price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * priceのSetter
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * totalPriceのGetter
	 * @return totalPrice
	 */
	public int getTotalPrice() {
		return totalPrice;
	}
	/**
	 * totalPriceのSetter
	 * @param totalPrice
	 */
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


}
