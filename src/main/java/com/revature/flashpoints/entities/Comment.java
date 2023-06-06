package com.revature.flashpoints.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "comments")
public class Comment {
    @Id
    private String id;

    @Column (nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Article article;

    public Comment(String comment, User user, Article article) {
        this.id = UUID.randomUUID().toString();
        this.comment = comment;
        this.user = user;
        this.article = article;
    }
}
