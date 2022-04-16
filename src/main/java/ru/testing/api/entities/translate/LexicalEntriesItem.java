package ru.testing.api.entities.translate;

import java.util.List;
import lombok.Data;

@Data
public class LexicalEntriesItem{
	private List<EntriesItem> entries;
	private LexicalCategory lexicalCategory;
	private String language;
	private String text;
}