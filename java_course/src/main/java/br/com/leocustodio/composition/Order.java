package br.com.leocustodio.composition;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime moment;
    private OrderStatus status;
    private Double totalOrder = 0.0;

    private Client client;
    private static List<OrderItem> items = new ArrayList<OrderItem>();

    DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Order(){

    }

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }


//    public static List<> addItem(){
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Product name: ");
//        String prodName = sc.nextLine();
//        System.out.print("Product price: ");
//        double prodPrice = sc.nextDouble();
//        sc.nextLine();
//        System.out.print("Quantity: ");
//        int prodQuantity = sc.nextInt();
//        Product prod = new Product(prodName, prodPrice);
//        //OrderItem orderAux = new OrderItem(prodQuantity, prod);
//        //listOrderItem.add(orderAux);
//    }

    public Double totalOrder(){
        return totalOrder;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY \n");
        sb.append("Order moment: ");
        sb.append(dtf1.format(getMoment())).append("\n");
        sb.append("Order status: ").append(status).append("\n");
        sb.append(client);
        sb.append("\n");
        //sb.append("Cliente: ").append(client.getName()).append(" (").append(dtf2.format(client.getBirthDate())).append(") ").append(client.getEmail()).append("\n");
        sb.append("Order items: ").append("\n");
        for (OrderItem item : items){
            sb.append(item.toString());
            sb.append("\n");
            totalOrder += item.subTotal();
        }
        sb.append("TOTAL ORDER: $");
        sb.append(String.format("%.2f", totalOrder));
        return sb.toString();
    }
}
