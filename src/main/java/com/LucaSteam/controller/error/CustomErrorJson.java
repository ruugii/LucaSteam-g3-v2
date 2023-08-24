package com.LucaSteam.controller.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomErrorJson {
    private String timestamp;
    private int status;
    private String error;
    private String trace;
    private List<String> message;
    private String path;

    private String jdk;
    private String infoAdicional;

    public CustomErrorJson() {
        super();
        this.timestamp = "";
        this.status = 0;
        this.error = "";
        this.trace = "";
        this.message = new ArrayList<>();
        this.path = "";
        this.jdk = "ND";
    }

    public CustomErrorJson(Date timestamp, int status, String error, String trace, List<String> message, String path,
                           String jdk) {
        super();
        this.timestamp = this.changeTimeStamp(timestamp);
        this.status = status;
        this.error = error;
        this.trace = trace;
        this.message = message;
        this.path = path;
        this.jdk = jdk;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = this.changeTimeStamp(timestamp);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getJdk() {
        return jdk;
    }

    public void setJdk(String jdk) {
        this.jdk = jdk;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }

    @Override
    public String toString() {
        return "CustomErrorJson{" +
                "timestamp='" + timestamp + '\'' +
                ", status=" + status +
                ", error='" + error + '\'' +
                ", trace='" + trace + '\'' +
                ", message=" + message +
                ", path='" + path + '\'' +
                ", jdk='" + jdk + '\'' +
                ", infoAdicional='" + infoAdicional + '\'' +
                '}';
    }

    private String changeTimeStamp(Date timestamp) {
        return timestamp.toString();
    }
}
