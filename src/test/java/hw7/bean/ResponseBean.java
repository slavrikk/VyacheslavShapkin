package hw7.bean;

import com.google.gson.annotations.Expose;

public class ResponseBean {
    @Expose
    private int code;
    @Expose
    private String type;
    @Expose
    private String message;

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
