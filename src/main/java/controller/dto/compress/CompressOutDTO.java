package controller.dto.compress;

/**
 * Created by C.CLAGOM on 4/5/2019.
 */
public class CompressOutDTO {

    private String value;
    private String compressed;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCompressed() {
        return compressed;
    }

    public void setCompressed(String compressed) {
        this.compressed = compressed;
    }

    @Override
    public String toString() {
        return "CompressInDTO{" +
                "value='" + value + '\'' +
                ", compressed='" + compressed + '\'' +
                '}';
    }
}
