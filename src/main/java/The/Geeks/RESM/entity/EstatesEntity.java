package The.Geeks.RESM.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Version;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "estates")
@DynamicUpdate
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class EstatesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
     
    private String buyerName;
    private String propertyName;
    private double sellingPrice;
    private double price;
    private Integer sharesNumber;
    

    @Version
    @Column(name="version")
    private Integer version;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date sale_date;

    // @ManyToMany(targetEntity = UserEntity.class)
    // @JoinTable(name = "users_estates", joinColumns = @JoinColumn(name = "estates_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    // private List<UserEntity> list_Estate;

    public EstatesEntity() {
    }

    public EstatesEntity(Integer id, String buyerName, String propertyName, double sellingPrice, double price, Integer sharesNumber, Integer version, Date sale_date) {
        this.id = id;
        this.buyerName = buyerName;
        this.propertyName = propertyName;
        this.sellingPrice = sellingPrice;
        this.price = price;
        this.sharesNumber = sharesNumber;
        this.version = version;
        this.sale_date = sale_date;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuyerName() {
        return this.buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public double getSellingPrice() {
        return this.sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getSharesNumber() {
        return this.sharesNumber;
    }

    public void setSharesNumber(Integer sharesNumber) {
        this.sharesNumber = sharesNumber;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getSale_date() {
        return this.sale_date;
    }

    public void setSale_date(Date sale_date) {
        this.sale_date = sale_date;
    }

    public EstatesEntity id(Integer id) {
        setId(id);
        return this;
    }

    public EstatesEntity buyerName(String buyerName) {
        setBuyerName(buyerName);
        return this;
    }

    public EstatesEntity propertyName(String propertyName) {
        setPropertyName(propertyName);
        return this;
    }

    public EstatesEntity sellingPrice(double sellingPrice) {
        setSellingPrice(sellingPrice);
        return this;
    }

    public EstatesEntity price(double price) {
        setPrice(price);
        return this;
    }

    public EstatesEntity sharesNumber(Integer sharesNumber) {
        setSharesNumber(sharesNumber);
        return this;
    }

    public EstatesEntity version(Integer version) {
        setVersion(version);
        return this;
    }

    public EstatesEntity sale_date(Date sale_date) {
        setSale_date(sale_date);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EstatesEntity)) {
            return false;
        }
        EstatesEntity estatesEntity = (EstatesEntity) o;
        return Objects.equals(id, estatesEntity.id) && Objects.equals(buyerName, estatesEntity.buyerName) && Objects.equals(propertyName, estatesEntity.propertyName) && sellingPrice == estatesEntity.sellingPrice && price == estatesEntity.price && Objects.equals(sharesNumber, estatesEntity.sharesNumber) && Objects.equals(version, estatesEntity.version) && Objects.equals(sale_date, estatesEntity.sale_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, buyerName, propertyName, sellingPrice, price, sharesNumber, version, sale_date);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", buyerName='" + getBuyerName() + "'" +
            ", propertyName='" + getPropertyName() + "'" +
            ", sellingPrice='" + getSellingPrice() + "'" +
            ", price='" + getPrice() + "'" +
            ", sharesNumber='" + getSharesNumber() + "'" +
            ", version='" + getVersion() + "'" +
            ", sale_date='" + getSale_date() + "'" +
            "}";
    }

}
