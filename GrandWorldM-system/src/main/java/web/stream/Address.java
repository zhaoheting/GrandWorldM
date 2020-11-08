package web.stream;

import java.util.Optional;

public class Address {

    private Optional<Integer> addressNumber;
    private Optional<String> addressDetail;

    public Optional<Integer> getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(Optional<Integer> addressNumber) {
        this.addressNumber = addressNumber;
    }

    public Optional<String> getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(Optional<String> addressDetail) {
        this.addressDetail = addressDetail;
    }
}
