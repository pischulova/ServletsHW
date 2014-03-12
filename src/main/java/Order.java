import javax.persistence.*;

/**
 * Created by Алена on 21.02.14.
 */
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //    private List<Car> order = new ArrayList<Car>();
    public String name;
    public String color;

    @ManyToOne
    @JoinColumn(name="UserLogin")
    private User user;

    public Order() {
    }

    public Order(String color, String name) {
        this.color = color;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


//    public void addToOrder (Car car) {
//        order.add(car);
//    }
//
//    public int getSize() {
//        return order.size();
//    }

}
