package annotation;

import java.lang.reflect.Field;

/**
 * Created by zhangjian on 2016/8/30.
 */
public class Apple {

    @FruitName("APPLE")
    private String name;

    @FruitColor(fruitColor = FruitColor.Color.BLUE)
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public static void main(String[] args) {
       Field fields[] =  Apple.class.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if(field.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = field.getAnnotation(FruitName.class);
                System.out.println(fruitName.value());
                if(field.getType().equals(Integer.class)){
                }
            }
        }
    }
}
