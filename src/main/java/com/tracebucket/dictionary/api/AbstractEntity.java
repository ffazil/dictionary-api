package com.tracebucket.dictionary.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.hateoas.Identifiable;

import javax.persistence.*;

/**
 * Base class for entity implementations. Uses a {@link Long} id.
 * 
 * @author ffazil
 */
@MappedSuperclass
@Getter
@ToString
@EqualsAndHashCode
public class AbstractEntity implements Identifiable<Long> {

	private final @Id @GeneratedValue(strategy = GenerationType.AUTO) @JsonIgnore
	Long id;
	private @Version Long version;

	protected AbstractEntity() {
		this.id = null;
	}
}
