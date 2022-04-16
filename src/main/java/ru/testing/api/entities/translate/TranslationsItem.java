package ru.testing.api.entities.translate;

import java.util.List;
import lombok.Data;

@Data
public class TranslationsItem{
	private List<NotesItem> notes;
	private List<RegionsItem> regions;
	private String language;
	private String text;
	private List<RegistersItem> registers;
}