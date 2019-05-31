package ru.testing.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.testing.api.entities.translate.TranslateResponse;
import ru.testing.api.gateway.YandexTranslateGateway;

@SpringBootTest(classes = Application.class)
public class YandexTranslateTest {

    @Autowired
    private YandexTranslateGateway translateGateway;

    @ParameterizedTest
    @ValueSource(strings = { "Hello World!" })
    @DisplayName("Перевод текста через api яндекс переводчика")
    public void translateText(String textToTranslate) {
        TranslateResponse translateTextResponse = translateGateway.getTranslateText(textToTranslate);
        Assertions.assertEquals("Всем Привет!", translateTextResponse.getText().get(0));
    }
}