package prilax.yk.entity.catalog;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "M_PRODUCT")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", nullable = false, length = 100)
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SELLING_PRICE")
    private Double price;

    @Column(name = "TOTAL_QUANTITY")
    private Integer totalQuantity;

    @Column(name = "MEDIA_ID")
    private String mediaId;

    @Column(name = "unit")
    private String unit;

    @Column(name = "CUSTOMIZABLE")
    private Boolean customizable;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="m_product_pcs", joinColumns=@JoinColumn(name="id"))
    @Column(name="name")
    @Fetch(FetchMode.SUBSELECT)
    private List<String> pcs = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="m_product_weights", joinColumns=@JoinColumn(name="id"))
    @Column(name="name")
    @Fetch(FetchMode.SUBSELECT)
    private List<String> weights = new ArrayList<>();

    @ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER)
    @JoinTable(name = "M_PRODUCT_CATEGORY",
            joinColumns = {@JoinColumn(name = "PRODUCT_ID", unique = false)},
            inverseJoinColumns = {@JoinColumn(name = "CATEGORY_ID", unique = false)}
    )
    private Category category;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public Boolean getCustomizable() {
        return customizable;
    }

    public void setCustomizable(Boolean customizable) {
        this.customizable = customizable;
    }

    public List<String> getWeights() {
        return weights;
    }

    public void setWeights(List<String> weights) {
        this.weights = weights;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<String> getPcs() {
        return pcs;
    }

    public void setPcs(List<String> pcs) {
        this.pcs = pcs;
    }
}


