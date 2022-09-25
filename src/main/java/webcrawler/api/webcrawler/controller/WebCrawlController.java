package webcrawler.api.webcrawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webcrawler.api.webcrawler.dto.SearchResult;
import webcrawler.api.webcrawler.dto.UrlSearchListDto;
import webcrawler.api.webcrawler.service.WebCrawlerService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class WebCrawlController {

    @Autowired
    private WebCrawlerService webCrawlerService;


    @PostMapping
    public ResponseEntity add( @RequestBody UrlSearchListDto urlSearchListDto ) {
        try {
            webCrawlerService.validateUrlList(urlSearchListDto.getUrlList());
            List<SearchResult> searchResults = webCrawlerService.getSearchResultList(urlSearchListDto);
            return new ResponseEntity<List<SearchResult>>(searchResults, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }


    }



}
