package prilax.yk.dto.product;

import java.io.Serializable;

public class ProductMediaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String mediaId;

    private String color;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
