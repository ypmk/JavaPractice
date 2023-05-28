package sinforge.practice14.Entities;

public class Building implements TwoFieldable {
    private String creationDate;

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    private String Type;

    public Building(String creationDate, String type) {
        this.creationDate = creationDate;
        this.Type = type;
    }

    @Override
    public String getFirstField() {
        return creationDate;
    }

    @Override
    public String getSecondField() {
        return Type;
    }
}
