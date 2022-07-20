package cardealership.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    private String email;
    private String phone;
    private String street1;
    private String street2;
    private String city;
    @ManyToOne
    @JoinColumn(name = "stateid", nullable = false)
    private State stateId;
    private String zipcode;
    private BigDecimal purchasePrice;
    private String purchaseType;
    private Date purchaseDate;
    @ManyToOne
    @JoinColumn(name = "vehicleid", nullable = false)
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    public Purchase() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public State getState() {
        return stateId;
    }

    public void setState(State stateId) {
        this.stateId = stateId;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
        if (!(o instanceof Purchase purchase)) return false;

        if (getId() != purchase.getId()) return false;
        if (!getName().equals(purchase.getName())) return false;
        if (!getEmail().equals(purchase.getEmail())) return false;
        if (!getPhone().equals(purchase.getPhone())) return false;
        if (!getStreet1().equals(purchase.getStreet1())) return false;
        if (getStreet2() != null ? !getStreet2().equals(purchase.getStreet2()) : purchase.getStreet2() != null)
            return false;
        if (!getCity().equals(purchase.getCity())) return false;
        if (!stateId.equals(purchase.stateId)) return false;
        if (!getZipcode().equals(purchase.getZipcode())) return false;
        if (!getPurchasePrice().equals(purchase.getPurchasePrice())) return false;
        if (!getPurchaseType().equals(purchase.getPurchaseType())) return false;
        if (!getPurchaseDate().equals(purchase.getPurchaseDate())) return false;
        if (!getVehicle().equals(purchase.getVehicle())) return false;
        return getUser().equals(purchase.getUser());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPhone().hashCode();
        result = 31 * result + getStreet1().hashCode();
        result = 31 * result + (getStreet2() != null ? getStreet2().hashCode() : 0);
        result = 31 * result + getCity().hashCode();
        result = 31 * result + stateId.hashCode();
        result = 31 * result + getZipcode().hashCode();
        result = 31 * result + getPurchasePrice().hashCode();
        result = 31 * result + getPurchaseType().hashCode();
        result = 31 * result + getPurchaseDate().hashCode();
        result = 31 * result + getVehicle().hashCode();
        result = 31 * result + getUser().hashCode();
        return result;
    }
}
