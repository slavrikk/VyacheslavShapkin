package hw7.bean;

import com.google.gson.annotations.Expose;

public class CategoryBean {
    @Expose
    private int id = 0;
    @Expose
    private String name = "";

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
}
