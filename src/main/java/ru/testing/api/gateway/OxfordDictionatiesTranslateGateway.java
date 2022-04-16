package ru.testing.api.gateway;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.testing.api.entities.translate.Response;


@Slf4j
@Component
public class OxfordDictionatiesTranslateGateway {

    private static final String URL = "https://od-api.oxforddictionaries.com/api/v2/{endpoint}/{source_lang_translate}/{target_lang_translate}/{word_id}";
    private static final String APPLICATION_KEY = ""; //TODO generate and insert your Oxford API KEY here, https://developer.oxforddictionaries.com
    private static final String APPLICATION_ID = ""; //TODO generate and insert your Oxford API ID here, https://developer.oxforddictionaries.com

    @SneakyThrows
    public Response getTranslateText(String textToTranslate) {
        Gson gson = new Gson();
        HttpResponse<JsonNode> response = Unirest.get(URL)
                                                 .header("Content-Type", "application/x-www-form-urlencoded")
                                                 .header("Accept", "*/*")
                                                 .header("app_id", APPLICATION_ID)
                                                 .header("app_key", APPLICATION_KEY)
                                                 .routeParam("endpoint", "translations")
                                                 .routeParam("source_lang_translate", "en")
                                                 .routeParam("target_lang_translate", "ru")
                                                 .routeParam("word_id", textToTranslate)
                                                 .asJson();
        String strResponse = response.getBody().toString();
        log.info("response: "+strResponse);
        return gson.fromJson(strResponse, Response.class);
    }
}