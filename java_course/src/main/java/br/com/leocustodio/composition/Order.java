package br.com.leocustodio.composition;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    LocalDateTime moment;
    OrderStatus status;

    Client client;
    List<OrderItem> listOrderItem = new ArrayList<>();

    public Order(){

    }

    public Order(LocalDateTime moment, OrderStatus status, Client client, List<OrderItem> listOrderItem) {
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.listOrderItem = listOrderItem;
    }

    public Order(LocalDateTime now, int value, Client client, List<OrderItem> listOrderItem) {
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Client getClient() {
        return client;
    }

    public List<OrderItem> getListOrderItem() {
        return listOrderItem;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(){
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(10);
        //orderItem.getProduct().
        //listOrderItem.add(orderItem);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY %n");
        sb.append("Order moment: ").append(moment).append("%n");

        return sb.toString();
    }
}
