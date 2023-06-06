package com.revature.flashpoints.entities;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "tags")
public class Tag {
    @Id 
    private String id;

    @Column (nullable = false, unique = true)
    private String name;

    @Column (nullable = false)
    private String image;

    @OneToMany(mappedBy = "tag", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Article> articles;

    public Tag(String name, String image) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.image = image;
        this.articles = new HashSet<>();
    }
}
