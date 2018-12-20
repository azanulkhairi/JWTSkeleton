package com.honeybadger.graymarket.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
		value = {"createdAt","updateAt"},
		allowGetters =true
)
public abstract class DateAudit implements Serializable{

	@CreatedDate
	@Column(nullable = false)
	private Instant ceratedAt;
	
	@LastModifiedDate
	@Column(nullable = false)
	private Instant updateAt;

	public Instant getCeratedAt() {
		return ceratedAt;
	}

	public void setCeratedAt(Instant ceratedAt) {
		this.ceratedAt = ceratedAt;
	}

	public Instant getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Instant updateAt) {
		this.updateAt = updateAt;
	}
	
	
}
