package cardealership.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Make {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column(name = "dateadded")
    private Date dateAdded;
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    public Make() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (!(o instanceof Make make)) return false;

        if (getId() != make.getId()) return false;
        if (!getName().equals(make.getName())) return false;
        if (!getDateAdded().equals(make.getDateAdded())) return false;
        return getUser().equals(make.getUser());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDateAdded().hashCode();
        result = 31 * result + getUser().hashCode();
        return result;
    }
}
