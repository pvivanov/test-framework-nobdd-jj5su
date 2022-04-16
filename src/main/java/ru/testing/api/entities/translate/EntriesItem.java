package ru.testing.api.entities.translate;

import java.util.List;
import lombok.Data;

@Data
public class EntriesItem{
	private List<SensesItem> senses;
	private List<VariantFormsItem> variantForms;
	private List<PronunciationsItem> pronunciations;
}