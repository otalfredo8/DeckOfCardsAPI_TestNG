package pojos;

public class CardPojo {


    private String code;
    private String suit;
    private String value;
    private String image;

    public CardPojo(String code, String suit, String value, String image) {
        this.code = code;
        this.suit = suit;
        this.value = value;
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "CardPojo{" +
                "code='" + code + '\'' +
                ", suit='" + suit + '\'' +
                ", value='" + value + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
