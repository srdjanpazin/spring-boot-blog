package com.example.demo.models;

import com.example.demo.enums.PostStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String title;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	@ManyToOne(fetch = FetchType.LAZY) // default fetch type - EAGER
	@JoinColumn(name = "author_id")
	private Author author;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToMany
	@JoinTable(
		name = "posts_tags",
		joinColumns = @JoinColumn(name = "post_id"),
		inverseJoinColumns = @JoinColumn(name = "tag_id")
	)
	private Set<Tag> tags = new HashSet<>();

	private String image;

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp createdAt;

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp updatedAt;

	@Column(columnDefinition = "ENUM('DRAFT', 'PUBLISHED') DEFAULT 'DRAFT'")
	@Enumerated(value = EnumType.STRING)
	private PostStatus status;

	@Column(columnDefinition = "INT DEFAULT 0")
	private int views;

	@Transient
	private String shortContent;
}
