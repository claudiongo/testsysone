package web.rest.dto;

/**
 * Created by C.CLAGOM on 4/5/2019.
 */
public class InDTO {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "InDTO{" +
                "value='" + value + '\'' +
                '}';
    }
}
