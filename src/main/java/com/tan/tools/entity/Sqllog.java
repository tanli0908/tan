package com.tan.tools.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * sqllog
 * @author 
 */
public class Sqllog implements Serializable {
    private Integer id;

    private String type;

    private String log_sql;

    private String sql_text;

    private Date create_time;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLog_sql() {
        return log_sql;
    }

    public void setLog_sql(String log_sql) {
        this.log_sql = log_sql;
    }

    public String getSql_text() {
        return sql_text;
    }

    public void setSql_text(String sql_text) {
        this.sql_text = sql_text;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}