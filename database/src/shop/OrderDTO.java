package shop;

public class OrderDTO {
	private int order_id;
	private int user_id;
	private int product_id;
	@Override
	public String toString() {
		return "OrderDTO [order_id=" + order_id + ", user_id=" + user_id + ", product_id=" + product_id + "]";
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public OrderDTO(int order_id, int user_id, int product_id) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.product_id = product_id;
	}

}
