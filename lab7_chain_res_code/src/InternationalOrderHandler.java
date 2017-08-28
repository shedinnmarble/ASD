/**
 * Created by Dewei Xiang on 8/6/2017.
 */
public class InternationalOrderHandler implements IOrderHandler {
    @Override
    public boolean handleOrder(Order order) {
        if(order.isInternational() && order.getTotalAmount() < 30000){
            System.out.println("InternationalOrderHandler executed");
            return true;
        }
        return false;
    }
}
