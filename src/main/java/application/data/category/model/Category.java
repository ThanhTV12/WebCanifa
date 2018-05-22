package application.data.category.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tbl_category")
public class Category {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    @Id
    private  int id;

    @Column(name = "category_name")
    private String name;

    @Column(name = "category_des")
    private String des;

//    @ManyToOne(optional = true, fetch = FetchType.LAZY)
//    @JoinColumn(name = "parent_id")
    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "update_date")
    private Date updateDate;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
