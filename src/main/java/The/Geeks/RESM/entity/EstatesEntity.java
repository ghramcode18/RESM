package The.Geeks.RESM.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name  = "estates")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class EstatesEntity {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String buyerName;
    private String propertyName;
    private double sellingPrice ;
    private double price ;
    private Integer sharesNumber;
    private Date sale_date;

      
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = UserEntity.class)
    @JoinTable(
    name = "user_estates", 
    joinColumns = @JoinColumn(name = "estate_id"), 
    inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List <UserEntity>users_added_to_estates;
   


    public EstatesEntity() {
    }

    public EstatesEntity(Integer id, String buyerName, String propertyName, double sellingPrice, double price, Integer sharesNumber, Date sale_date, List<UserEntity> users_added_to_estates) {
        this.id = id;
        this.buyerName = buyerName;
        this.propertyName = propertyName;
        this.sellingPrice = sellingPrice;
        this.price = price;
        this.sharesNumber = sharesNumber;
        this.sale_date = sale_date;
        this.users_added_to_estates = users_added_to_estates;
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

    public Date getSale_date() {
        return this.sale_date;
    }

    public void setSale_date(Date sale_date) {
        this.sale_date = sale_date;
    }

    public List<UserEntity> getUsers_added_to_estates() {
        return this.users_added_to_estates;
    }

    public void setUsers_added_to_estates(List<UserEntity> users_added_to_estates) {
        this.users_added_to_estates = users_added_to_estates;
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

    public EstatesEntity sale_date(Date sale_date) {
        setSale_date(sale_date);
        return this;
    }

    public EstatesEntity users_added_to_estates(List<UserEntity> users_added_to_estates) {
        setUsers_added_to_estates(users_added_to_estates);
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
        return Objects.equals(id, estatesEntity.id) && Objects.equals(buyerName, estatesEntity.buyerName) && Objects.equals(propertyName, estatesEntity.propertyName) && sellingPrice == estatesEntity.sellingPrice && price == estatesEntity.price && Objects.equals(sharesNumber, estatesEntity.sharesNumber) && Objects.equals(sale_date, estatesEntity.sale_date) && Objects.equals(users_added_to_estates, estatesEntity.users_added_to_estates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, buyerName, propertyName, sellingPrice, price, sharesNumber, sale_date, users_added_to_estates);
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
            ", sale_date='" + getSale_date() + "'" +
            ", users_added_to_estates='" + getUsers_added_to_estates() + "'" +
            "}";
    }



}
