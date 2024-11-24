package com.example.courses_management_service.model;

import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Objects;

public class Section {

    @Id
    private String id;
    private String title;
    private String description;
    private Integer order;
    private List<Subsection> subsections;

    public Section(String id, String title, String description, Integer order, List<Subsection> subsections) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.order = order;
        this.subsections = subsections;
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

    public List<Subsection> getSubsections() {
        return subsections;
    }

    public void setSubsections(List<Subsection> subsections) {
        this.subsections = subsections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(id, section.id) && Objects.equals(title, section.title) && Objects.equals(description, section.description) && Objects.equals(order, section.order) && Objects.equals(subsections, section.subsections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, order, subsections);
    }
}
