package webcrawler.api.webcrawler.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import webcrawler.api.webcrawler.dto.SearchResult;
import webcrawler.api.webcrawler.dto.UrlSearchListDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WebCrawlerService {

    Logger logger = LoggerFactory.getLogger(WebCrawlerService.class);
    private  boolean isValidUrl( String urlString ) {
        String urlRegex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

        Pattern patt = Pattern.compile(urlRegex);
        Matcher matcher = patt.matcher(urlString);
        boolean matches = matcher.matches();
        logger.info(urlString+" isUrl :"+matches);
        return matches;
    }

    public void validateUrlList( String[] urlList ) throws Exception {
        for (int i = 0; i < urlList.length; i++) {
            String url = urlList[i];
            if (!isValidUrl(url)) {
                throw new Exception(url + " :URL is wronge ");
            }
        }

    }

    public String getUrlBodyText(String url,String keyword) throws IOException {
      try {
          Document doc = (Document) Jsoup.connect(url).get();
          Element element = doc.select(":containsOwn("+keyword+")").first();
          if(element!=null && element.hasText() && element.text()!=""){
              return "text found : "+element;
          }else {
              return "not found";
          }
      }catch (Exception e){
          logger.info(e.getMessage());
        throw  e;
      }
    }

    public List<SearchResult> getSearchResultList( UrlSearchListDto urlSearchListDto ) throws IOException {
        List<SearchResult> searchResults = new ArrayList<>();
        for (String url : urlSearchListDto.getUrlList()) {
            logger.info(url);
            String text = getUrlBodyText(url, urlSearchListDto.getSearchText());
            SearchResult searchResult = new SearchResult();
            searchResult.setUrl(url);
            searchResult.setFoundedNode(text);
            searchResult.setFound(text!="not found");
            searchResults.add(searchResult);
        }
        return searchResults;
    }
}
