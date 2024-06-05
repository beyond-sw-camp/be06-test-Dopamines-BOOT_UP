public class Snack {
    String name;
    Integer price;
    String flavor;

    public Snack(String name, Integer price, String flavor) {
        this.name = name;
        this.price = price;
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return "Snack{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", flavor='" + flavor + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getFlavor() {
        return flavor;
    }
}
