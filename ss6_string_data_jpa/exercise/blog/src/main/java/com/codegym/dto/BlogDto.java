package com.codegym.dto;

import com.codegym.model.BlogType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class BlogDto {
    private Integer blogId;
    @NotEmpty
    @NotBlank
    @Size(min = 1,max = 800, message = "number of character is between 1 to 800 character")
    private String blogName;
    @NotEmpty
    @NotBlank
    @Size(min = 1,max = 10000, message = "number of character is between 1 to 10000 character")
    private String blogSummary;
    private BlogType blogType;

    public BlogDto() {
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogSummary() {
        return blogSummary;
    }

    public void setBlogSummary(String blogSummary) {
        this.blogSummary = blogSummary;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }
}
