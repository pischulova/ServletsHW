import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Алена on 21.02.14.
 */
@Entity
public class Order {
    @Id
    private int id;
    private List<Car> order = new ArrayList<Car>();

    public Order() {
    }

    public String getDataForWeb() {
        String s="";
        for(Car c: order) {
            s += "<tr><td>"+ c.getModel() +" </td><td>"+ c.getColor()+" </td></tr></br>";
        }
        return s;
    }

    public void addToOrder (Car car) {
        order.add(car);
    }

    public int getSize() {
        return order.size();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
