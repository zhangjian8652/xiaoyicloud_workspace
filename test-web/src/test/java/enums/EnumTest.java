package enums;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.junit.Test;

/**
 * author:zhangjian
 * date:2016-05-08
 * describe:
 **/
public class EnumTest {

    @Test
    public void testConstruct() throws JsonProcessingException {

        Color[] colors = {Color.RED, Color.GREEN};

        System.out.println(Color.RED);
        System.out.println(colors);
        System.out.println(Type.MONDAY);


        Day day = new Day();
        day.setColor(Color.GREEN);
        day.setType(Type.MONDAY);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);

        System.out.println(objectMapper.writeValueAsString(day));

    }

    public enum Color{
        RED("RED"),GREEN("GREEN");

        private String name;

        Color(String name) {
            this.name = name;
        }

    }

    public enum Type{
        MONDAY
    }


    public class Day{
        private Color color;
        private Type type;

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }
    }
}
