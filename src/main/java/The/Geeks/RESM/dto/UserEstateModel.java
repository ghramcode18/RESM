package The.Geeks.RESM.dto;

import java.util.Objects;

public class UserEstateModel {
    
    Integer userId;
    Integer estateId;

    public UserEstateModel() {
    }

    public UserEstateModel(Integer userId, Integer estateId) {
        this.userId = userId;
        this.estateId = estateId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEstateId() {
        return this.estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public UserEstateModel userId(Integer userId) {
        setUserId(userId);
        return this;
    }

    public UserEstateModel estateId(Integer estateId) {
        setEstateId(estateId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserEstateModel)) {
            return false;
        }
        UserEstateModel userEstateModel = (UserEstateModel) o;
        return Objects.equals(userId, userEstateModel.userId) && Objects.equals(estateId, userEstateModel.estateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, estateId);
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", estateId='" + getEstateId() + "'" +
            "}";
    }


}
