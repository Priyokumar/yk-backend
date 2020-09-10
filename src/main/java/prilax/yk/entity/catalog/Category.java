package prilax.yk.entity.catalog;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "M_CATEGORY")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", nullable = false, length = 100)
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "TOP_CATEGORY")
    private Boolean topCategory = false;

    @OneToMany(targetEntity = Category.class, cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    @JoinTable(name = "M_PARENT_CHILD_CAT_REF",
            joinColumns = {@JoinColumn(name = "PARENT_CATEGORY_ID", unique = false)},
            inverseJoinColumns = {@JoinColumn(name = "CATEGORY_ID", unique = false)}
    )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Category> subCategories = new ArrayList<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getTopCategory() {
        return topCategory;
    }

    public void setTopCategory(Boolean topCategory) {
        this.topCategory = topCategory;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }
}
