import java.io.Serializable;
import java.util.*;

/**
 * Created by Алена on 21.02.14.
 */
public class Order {
    List<Car> order = new ArrayList<Car>();

    public String getDataForWeb() {
        String s="";
        for(Car c: order) {
            s += "<tr><td>"+ c.getModel() +" </td><td>"+ c.getColor()+" </td></tr>";
        }
        return s;
    }
}
