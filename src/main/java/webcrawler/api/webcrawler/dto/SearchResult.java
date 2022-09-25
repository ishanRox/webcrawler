package webcrawler.api.webcrawler.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchResult {
    String url;
    boolean isFound;
    String foundedNode;
}
