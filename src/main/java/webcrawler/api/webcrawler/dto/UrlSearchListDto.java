package webcrawler.api.webcrawler.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlSearchListDto {
    private String []urlList;
    private String searchText;
}
