package ru.testing.api.entities.translate;

import lombok.Data;

@Data
public class Metadata{
	private String schema;
	private String provider;
	private String operation;
}