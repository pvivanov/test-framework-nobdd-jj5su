package ru.testing.api.entities.translate;

import java.util.List;
import lombok.Data;

@Data
public class ResultsItem{
	private List<LexicalEntriesItem> lexicalEntries;
	private String language;
	private String id;
	private String type;
	private String word;
}