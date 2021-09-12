package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private static SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdt2 = new SimpleDateFormat("dd/MM/yyyy");
	private Date moment;
	private OrderStatus status;
	private Client client;

	private List<OrderItem> item = new ArrayList<>();

	public Order() {

	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItem() {
		return item;
	}

	public void addItem(OrderItem item) {
		this.item.add(item);
	}

	public void removeItem(OrderItem item) {
		this.item.remove(item);
	}

	public double total() {
		double total = 0.0;
		for (OrderItem order : item) {
			total += order.getPrice();
		}
		return total;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: \n");
		sb.append("Order moment: " + sdt.format(this.getMoment()) + "\n");
		sb.append("Order Status: " + this.getStatus() + "\n");
		sb.append("Client: " + this.getClient().getName() + " (" + sdt2.format(this.getClient().getBirthDate()) + ") - "
				+ this.getClient().getEmail() + "\n");
		sb.append("Order items: ");
		for (OrderItem item : item) {
			sb.append(item.toString());
		}
		return sb.toString();
	}

}
