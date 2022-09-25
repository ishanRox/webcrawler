package webcrawler.api.webcrawler.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlListDto {
    private String []urlList;
    private String searchKeyword;
}
