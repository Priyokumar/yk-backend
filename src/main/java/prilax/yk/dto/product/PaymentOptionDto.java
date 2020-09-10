package prilax.yk.dto.product;

import java.io.Serializable;

public class PaymentOptionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private  String id;

    private String name;

    private Boolean enabled;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
