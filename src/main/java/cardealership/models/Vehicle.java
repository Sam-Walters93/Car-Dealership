package cardealership.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "makeid", nullable = false)
    private Make make;
    @ManyToOne
    @JoinColumn(name = "modelid", nullable = false)
    private Model model;
    @Column
    private String type;
    @Column
    private String bodyStyle;
    @Column
    private int year;
    @Column
    private String transmission;
    @Column
    private String color;
    @Column
    private String interior;
    @Column
    private int mileage;
    @Column
    private String vin;
    @Column
    private BigDecimal msrp;
    @Column
    private BigDecimal salePrice;
    @Column
    private String description;
    @Column
    private String photo;
    @Column
    private boolean feature;
    @Column
    private boolean sold;


    public Vehicle() {
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

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public BigDecimal getMsrp() {
        return msrp;
    }

    public void setMsrp(BigDecimal msrp) {
        this.msrp = msrp;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isFeature() {
        return feature;
    }

    public void setFeature(boolean feature) {
        this.feature = feature;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;

        if (getId() != vehicle.getId()) return false;
        if (getYear() != vehicle.getYear()) return false;
        if (getMileage() != vehicle.getMileage()) return false;
        if (isFeature() != vehicle.isFeature()) return false;
        if (isSold() != vehicle.isSold()) return false;
        if (!getMake().equals(vehicle.getMake())) return false;
        if (!getModel().equals(vehicle.getModel())) return false;
        if (!getType().equals(vehicle.getType())) return false;
        if (!getBodyStyle().equals(vehicle.getBodyStyle())) return false;
        if (!getTransmission().equals(vehicle.getTransmission())) return false;
        if (!getColor().equals(vehicle.getColor())) return false;
        if (!getInterior().equals(vehicle.getInterior())) return false;
        if (!getVin().equals(vehicle.getVin())) return false;
        if (!getMsrp().equals(vehicle.getMsrp())) return false;
        if (!getSalePrice().equals(vehicle.getSalePrice())) return false;
        if (!getDescription().equals(vehicle.getDescription())) return false;
        return getPhoto().equals(vehicle.getPhoto());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getMake().hashCode();
        result = 31 * result + getModel().hashCode();
        result = 31 * result + getType().hashCode();
        result = 31 * result + getBodyStyle().hashCode();
        result = 31 * result + getYear();
        result = 31 * result + getTransmission().hashCode();
        result = 31 * result + getColor().hashCode();
        result = 31 * result + getInterior().hashCode();
        result = 31 * result + getMileage();
        result = 31 * result + getVin().hashCode();
        result = 31 * result + getMsrp().hashCode();
        result = 31 * result + getSalePrice().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getPhoto().hashCode();
        result = 31 * result + (isFeature() ? 1 : 0);
        result = 31 * result + (isSold() ? 1 : 0);
        return result;
    }
}
