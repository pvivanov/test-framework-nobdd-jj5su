package ru.testing.api.gateway;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.testing.api.entities.translate.TranslateResponse;


@Slf4j
@Component
public class YandexTranslateGateway {

    private static final String URL = "https://translate.yandex.net/api/v1.5/tr.json/translate";
    private static final String TOKEN = ""; //TODO generate and insert your yandex token here, https://tech.yandex.ru/translate/doc/dg/concepts/api-keys-docpage/

    @SneakyThrows
    public TranslateResponse getTranslateText(String textToTranslate) {
        Gson gson = new Gson();
        HttpResponse<JsonNode> response = Unirest.post(URL)
                                                 .header("Content-Type", "application/x-www-form-urlencoded")
                                                 .header("Accept", "*/*")
                                                 .field("key", TOKEN)
                                                 .field("text", textToTranslate)
                                                 .field("lang", "en-ru")
                                                 .field("format", "plain")
                                                 .field("options", "1")
                                                 .asJson();
        String strResponse = response.getBody().toString();
        log.info("response: "+strResponse);
        return gson.fromJson(strResponse, TranslateResponse.class);
    }
}