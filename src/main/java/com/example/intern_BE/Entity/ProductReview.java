package com.example.intern_BE.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Table(name = "product_review")
@Entity
public class ProductReview {
    @Id
    @Column(name = "product_review_id", nullable = false)
    private Integer id;

    @ManyToOne

    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne

    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "content_rated", length = 100)
    private String contentRated;

    @Column(name = "point_evaluation")
    private Integer pointEvaluation;

    @Column(name = "content_seen", length = 50)
    private String contentSeen;

    @Column(name = "status")
    private Integer status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "update_at")
    private Instant updateAt;

    public Instant getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContentSeen() {
        return contentSeen;
    }

    public void setContentSeen(String contentSeen) {
        this.contentSeen = contentSeen;
    }

    public Integer getPointEvaluation() {
        return pointEvaluation;
    }

    public void setPointEvaluation(Integer pointEvaluation) {
        this.pointEvaluation = pointEvaluation;
    }

    public String getContentRated() {
        return contentRated;
    }

    public void setContentRated(String contentRated) {
        this.contentRated = contentRated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}