package sinforge.practice14.Entities;

public class Address implements TwoFieldable{
    public Address(String addressText, String zipCode) {
        this.addressText = addressText;
        this.zipCode = zipCode;
    }

    public String getAddressText() {
        return addressText;
    }

    public void setAddressText(String addressText) {
        this.addressText = addressText;
    }

    public String getZipCode() { return zipCode; }

    public void setZipCode(String zipCode) {
        this.zipCode = this.zipCode;
    }

    private String addressText;
    private String zipCode;


    @Override
    public String getFirstField() {
        return addressText;
    }

    @Override
    public String getSecondField() {
        return zipCode;
    }
}
