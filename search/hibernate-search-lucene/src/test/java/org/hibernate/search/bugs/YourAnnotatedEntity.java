package org.hibernate.search.bugs;

import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Facet;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
public class YourAnnotatedEntity {

	@Id
	@DocumentId
	private Long id;

	@Field
	private String name;

	@Field(analyze = Analyze.NO)
	@Facet
	private Instant creationTimestamp;

	protected YourAnnotatedEntity() {
	}

	public YourAnnotatedEntity(Long id, String name, Instant timestamp) {
		this.id = id;
		this.name = name;
		creationTimestamp = timestamp;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getCreationTimestamp() {
		return creationTimestamp;
	}
}
