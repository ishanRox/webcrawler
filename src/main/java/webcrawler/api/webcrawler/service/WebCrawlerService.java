package webcrawler.api.webcrawler.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class WebCrawlerService {

    private static boolean isValidUrl( String urlString ) {
        String urlRegex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

        Pattern patt = Pattern.compile(urlRegex);
        Matcher matcher = patt.matcher(urlString);
        boolean matches = matcher.matches();
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
          System.out.println(e.getMessage());
      }

        return "";
    }
}
