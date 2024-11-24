package com.example.courses_management_service.model;

import org.springframework.data.annotation.Id;

public class Subsection {
    @Id
    private String id;
    private String title;
    private String description;
    private Integer order;
    private String contentType;
    private String content;
    private Integer duration;
    private Boolean isPreview;

    public Subsection(String id, String title, String description, Integer order, String contentType, String content, Integer duration, Boolean isPreview) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.order = order;
        this.contentType = contentType;
        this.content = content;
        this.duration = duration;
        this.isPreview = isPreview;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean getPreview() {
        return isPreview;
    }

    public void setPreview(Boolean preview) {
        isPreview = preview;
    }
}
