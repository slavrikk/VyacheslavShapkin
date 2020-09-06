package hw8.beans;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ExampleData {

    @Expose
    private List<String> summary;

    @Expose
    private List<String> elements;

    @Expose
    private String color;

    @Expose
    private String metals;

    @Expose
    private List<String> vegetables;

    public List<String> getSummary() {
        return summary;
    }

    public void setSummary(List<String> summary) {
        this.summary = summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetals() {
        return metals;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }
}
