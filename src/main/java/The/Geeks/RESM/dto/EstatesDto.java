package The.Geeks.RESM.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class EstatesDto implements Serializable {
    private Integer id;
    private String buyerName;
    private String propertyName;
    private double sellingPrice;
    private double price;
    private Integer sharesNumber;
    private Date sale_date;

    public EstatesDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstatesDto(String buyerName, String propertyName, double sellingPrice, double price, Integer sharesNumber,
            Date sale_date) {
        this.buyerName = buyerName;
        this.propertyName = propertyName;
        this.sellingPrice = sellingPrice;
        this.price = price;
        this.sharesNumber = sharesNumber;
        this.sale_date = sale_date;
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

    public EstatesDto buyerName(String buyerName) {
        setBuyerName(buyerName);
        return this;
    }

    public EstatesDto propertyName(String propertyName) {
        setPropertyName(propertyName);
        return this;
    }

    public EstatesDto sellingPrice(double sellingPrice) {
        setSellingPrice(sellingPrice);
        return this;
    }

    public EstatesDto price(double price) {
        setPrice(price);
        return this;
    }

    public EstatesDto sharesNumber(Integer sharesNumber) {
        setSharesNumber(sharesNumber);
        return this;
    }

    public EstatesDto sale_date(Date sale_date) {
        setSale_date(sale_date);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof EstatesDto)) {
            return false;
        }
        EstatesDto estatesDto = (EstatesDto) o;
        return Objects.equals(buyerName, estatesDto.buyerName) && Objects.equals(propertyName, estatesDto.propertyName)
                && sellingPrice == estatesDto.sellingPrice && price == estatesDto.price
                && Objects.equals(sharesNumber, estatesDto.sharesNumber)
                && Objects.equals(sale_date, estatesDto.sale_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buyerName, propertyName, sellingPrice, price, sharesNumber, sale_date);
    }

    @Override
    public String toString() {
        return "{" +
                " buyerName='" + getBuyerName() + "'" +
                ", propertyName='" + getPropertyName() + "'" +
                ", sellingPrice='" + getSellingPrice() + "'" +
                ", price='" + getPrice() + "'" +
                ", sharesNumber='" + getSharesNumber() + "'" +
                ", sale_date='" + getSale_date() + "'" +
                "}";
    }

}
