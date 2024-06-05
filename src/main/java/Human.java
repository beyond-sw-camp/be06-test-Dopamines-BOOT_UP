import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Integer age;
    private List<Snack> snacks;

    public Human(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.snacks = new ArrayList<>();
    }

    public void addSnacks(Snack snack){
        this.snacks.add(snack);
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public List<Snack> getSnacks() {
        return snacks;
    }
}
