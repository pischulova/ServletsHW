/**
 * Created by Алена on 11.03.14.
 */
public interface OrderDAO {

    public void addOrder(Order order);
    public Order findOrder(int id);
    public void removeOrder(Order order);
    public Order updateOrder(Order order);

}