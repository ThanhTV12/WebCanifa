package application.data.category.model;


import javax.persistence.*;
import java.util.Date;

@Entity(name = "tbl_product")
public class Product {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    @Id
    private int id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_des")
    private String des;

//    @ManyToOne(optional = true, fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    private Category category;
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "price")
    private float price;

    @Column(name = "quantity")
    private long quantity;

    @Column(name = "status_id")
    private Integer status;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "update_date")
    private Date updatedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
