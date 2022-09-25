package webcrawler.api.webcrawler.service;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import javax.swing.text.Document;
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

    public String getUrlBodyText() throws IOException {
        Document doc = (Document) Jsoup.connect("http://jsoup.org").get();

//        Element link = doc.select("a").first();
//        String relHref = link.attr("href"); // == "/"
//        String absHref = link.attr("abs:href"); // "http://jsoup.org/"
        return "";
    }
}
