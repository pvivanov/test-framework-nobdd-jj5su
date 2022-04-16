package ru.testing.api.entities.translate;

import java.util.List;
import lombok.Data;

@Data
public class PronunciationsItem{
	private String audioFile;
	private String phoneticNotation;
	private List<String> dialects;
	private String phoneticSpelling;
}