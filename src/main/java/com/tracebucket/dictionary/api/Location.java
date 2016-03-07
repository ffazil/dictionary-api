package com.tracebucket.dictionary.api;

import lombok.AllArgsConstructor;
import lombok.Value;

import javax.persistence.Embeddable;

/**
 * @author ffazil
 */
@Value
@Embeddable
@AllArgsConstructor
public class Location {

	private final double latitude, longitude;

	protected Location() {
		this.latitude = 0.0;
		this.longitude = 0.0;
	}
}
