package hw7.bean;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class PetBean {
    @Expose
    private int id = 0;
    @Expose
    private CategoryBean category;
    @Expose
    private String name = "";
    @Expose
    private List<String> photoUrls = new ArrayList<>();
    @Expose
    private List<TagBean> tags = new ArrayList<>();
    @Expose
    private String status = "available";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CategoryBean getCategoryBean() {
        return category;
    }

    public void setCategoryBean(CategoryBean categoryBean) {
        this.category = categoryBean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TagBean> getTags() {
        return tags;
    }

}
