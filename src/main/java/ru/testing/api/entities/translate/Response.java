package ru.testing.api.entities.translate;

import java.util.List;
import lombok.Data;

@Data
public class Response{
	private Metadata metadata;
	private String id;
	private List<ResultsItem> results;
	private String word;
}