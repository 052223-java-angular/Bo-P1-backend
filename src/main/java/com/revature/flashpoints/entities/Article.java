package com.revature.flashpoints.entities;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "articles")
public class Article {
    @Id
    private String id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column
    private String image_url;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Tag tag;

    @OneToMany (mappedBy = "article", fetch = FetchType.LAZY)
    private Set<Comment> comments;

    @Column(nullable = false)
    private String content;

    public Article(String title, String image_url, User user, Tag tag,
    Float lat, Float longitude, String content) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.image_url = image_url;
        this.user = user;
        this.tag = tag;
        this.comments = new HashSet<>();
        this.content = content;
    }
}
