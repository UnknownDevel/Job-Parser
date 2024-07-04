package com.parser;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
//"https://api.hh.ru/vacancies/103118727"

@RestController
@RequestMapping
public class ParserEndpointController {
    @PostMapping("/parse")
    public ResponseEntity<String> parse(@RequestBody String body) throws IOException {
        String id = new JSONObject(body).getString("id");
        Document document = Jsoup.connect("https://api.hh.ru/vacancies/" + id).ignoreContentType(true).get();
        return ResponseEntity.ok(document.text());
    }
}
