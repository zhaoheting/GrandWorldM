package web.stream;

import java.util.Optional;

public class Address {

    private Optional<Integer> addressNumber;
    private String addressDetail;

    public Optional<Integer> getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(Optional<Integer> addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }
}
