package products;

/**
 * Created by Dewei Xiang on 9/17/2017.
 */
public class InventoryService implements IInventoryService{
    public int getNumberInStock(int productNumber) {
        return productNumber-200;
    }
}
