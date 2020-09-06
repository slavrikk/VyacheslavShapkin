package hw8.beans;

import com.google.gson.annotations.Expose;

public class DataBean {

    @Expose
    private ExampleData data_1;
    @Expose
    private ExampleData data_2;
    @Expose
    private ExampleData data_3;
    @Expose
    private ExampleData data_4;
    @Expose
    private ExampleData data_5;

    public ExampleData getData_1() {
        return data_1;
    }

    public void setData_1(ExampleData data_1) {
        this.data_1 = data_1;
    }

    public ExampleData getData_2() {
        return data_2;
    }

    public void setData_2(ExampleData data_2) {
        this.data_2 = data_2;
    }

    public ExampleData getData_3() {
        return data_3;
    }

    public void setData_3(ExampleData data_3) {
        this.data_3 = data_3;
    }

    public ExampleData getData_4() {
        return data_4;
    }

    public void setData_4(ExampleData data_4) {
        this.data_4 = data_4;
    }

    public ExampleData getData_5() {
        return data_5;
    }

    public void setData_5(ExampleData data_5) {
        this.data_5 = data_5;
    }
}
