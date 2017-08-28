import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dewei Xiang on 8/6/2017.
 */
public class OrderReceiver {
    List<IOrderHandler> orderHandlers = new ArrayList<>();
    public OrderReceiver(){
        orderHandlers.add(new DomesticOrderHandler());
        orderHandlers.add(new InternationalOrderHandler());
        orderHandlers.add(new MostFavoredCustomerOrderHandler());
        orderHandlers.add(new LargeOrderHandler());
    }
    void receiveOrder(Order order){
        for(IOrderHandler orderHandler: orderHandlers){
            orderHandler.handleOrder(order);
        }
    }
}
