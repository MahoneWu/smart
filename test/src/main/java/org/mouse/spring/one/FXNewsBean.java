package org.mouse.spring.one;

import java.util.Date;

/**
 * 对象
 *
 * @author wuhao Mahone Wu
 * @date 2017/10/19
 */
public class FXNewsBean {


    private String id;


    private String content;


    private String author;


    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
