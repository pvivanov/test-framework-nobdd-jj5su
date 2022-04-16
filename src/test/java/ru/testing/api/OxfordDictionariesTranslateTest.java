package ru.testing.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.testing.api.entities.translate.Response;
import ru.testing.api.gateway.OxfordDictionatiesTranslateGateway;

@SpringBootTest(classes = Application.class)
public class OxfordDictionariesTranslateTest {

    @Autowired
    private OxfordDictionatiesTranslateGateway translateGateway;

    @ParameterizedTest
    @ValueSource(strings = { "hello" })
    @DisplayName("Text translation with API Oxford translator")
    public void translateText(String textToTranslate) {
        Response translateTextResponse = translateGateway.getTranslateText(textToTranslate);
        Assertions.assertEquals("здра́вствуй(те)!", translateTextResponse.getResults().get(0).getLexicalEntries().get(0).getEntries().get(0).getSenses().get(0).getTranslations().get(0).getText());
    }
}