package ru.testing.api.entities.translate;

import java.util.List;
import lombok.Data;

@Data
public class SensesItem{
	private List<NotesItem> notes;
	private List<DatasetCrossLinksItem> datasetCrossLinks;
	private List<TranslationsItem> translations;
	private String id;
}