import javax.persistence.*;

/**
 * Created by Алена on 21.02.14.
 */
@Entity
@Table
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //    private List<Car> orders = new ArrayList<Car>();
    public String name;
    public String color;

    @ManyToOne
    @JoinColumn(name="userId")
    private Users users;

    public Orders() {
    }

    public Orders(String color, String name) {
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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }


//    public void addToOrder (Car car) {
//        orders.add(car);
//    }
//
//    public int getSize() {
//        return orders.size();
//    }

}
