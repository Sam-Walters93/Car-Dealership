package cardealership.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "makeid", nullable = false)
    private Make make;
    @Column
    private String name;
    @Column
    private Date dateAdded;
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    public Model() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Model model)) return false;

        if (getId() != model.getId()) return false;
        if (!getMake().equals(model.getMake())) return false;
        if (!getName().equals(model.getName())) return false;
        if (!getDateAdded().equals(model.getDateAdded())) return false;
        return getUser().equals(model.getUser());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getMake().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDateAdded().hashCode();
        result = 31 * result + getUser().hashCode();
        return result;
    }
}
