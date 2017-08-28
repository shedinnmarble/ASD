/**
 * Created by Dewei Xiang on 8/6/2017.
 */
public class DomesticOrderHandler implements IOrderHandler {
    @Override
    public boolean handleOrder(Order order) {
        if(!order.isInternational()){
            System.out.println("DomesticOrderHandler executed");
            return true;
        }
        return false;
    }
}
