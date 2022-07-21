package cardealership.models;

import javax.persistence.*;

@Entity
public class Special {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String description;

    public Special() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Special special)) return false;

        if (getId() != special.getId()) return false;
        if (!getTitle().equals(special.getTitle())) return false;
        return getDescription().equals(special.getDescription());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }
}
