package prilax.yk.dto.product;

import java.io.Serializable;

public class ProductMediaRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String type;

    private String color;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
