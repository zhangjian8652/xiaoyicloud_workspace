package annotation;

/**
 * Created by zhangjian on 2016/8/30.
 */
@Table(name = "USER")
public class User {

    @Column(name = "NAME")
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
