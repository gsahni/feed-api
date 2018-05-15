package com.socialmedia.feed;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "post")
public class Post extends AuditEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Comment> comments = new HashSet<>();
	
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Boolean getSoftDeleted() {
		return softDeleted;
	}

	public void setSoftDeleted(Boolean softDeleted) {
		this.softDeleted = softDeleted;
	}

	@Column(name="account_id", nullable = false)
	private Long accountId;
	
	@Column(name="soft_deleted", nullable = false)
	private Boolean softDeleted;
	
	
	
}
