import com.myshop.entity.Orders;

/**
 * Created by Алена on 11.03.14.
 */
public interface OrderDAO {

    public void addOrder(Orders orders);
    public Orders findOrder(int id);
    public void removeOrder(Orders orders);
    public Orders updateOrder(Orders orders);

}