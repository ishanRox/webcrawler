package webcrawler.api.webcrawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web_crawler.api.webcrawler.dto.UrlListDto;
import web_crawler.api.webcrawler.service.WebCrawlerService;

@RestController
@RequestMapping(value = "/search")
public class WebCrawlController {

    @Autowired
    private WebCrawlerService webCrawlerService;


    @PostMapping
    public ResponseEntity add( @RequestBody UrlListDto urlListDto ) {
        try {
            webCrawlerService.validateUrlList(urlListDto.getUrlList());
            return new ResponseEntity<>("okkk", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }


    }

}
