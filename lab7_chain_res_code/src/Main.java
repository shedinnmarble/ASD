public class Main {

    public static void main(String[] args) {
        OrderReceiver orderReceiver = new OrderReceiver();
        Customer customer = new Customer("dewei");
        Order o1 = new Order(1,10000, true, customer);
        Order o2 = new Order(2, 40000, false, customer);
        orderReceiver.receiveOrder(o1);
        orderReceiver.receiveOrder(o2);
    }
}
