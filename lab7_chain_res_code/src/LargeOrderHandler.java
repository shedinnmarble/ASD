/**
 * Created by Dewei Xiang on 8/6/2017.
 */
public class LargeOrderHandler implements IOrderHandler {
    @Override
    public boolean handleOrder(Order order) {
        if(order.getTotalAmount() >= 30000){
            System.out.println("LargeOrderHandler executed");
            return true;
        }
        return false;
    }
}
