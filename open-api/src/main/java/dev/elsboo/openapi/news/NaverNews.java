package dev.elsboo.openapi.news;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class NaverNews {
    private String title;
    private String originallink;
    private String link;
    private String description;
    private String pubDate;

    @Builder
    public NaverNews(String title, String originallink, String link, String description, String pubDate) {
        this.title = title;
        this.originallink = originallink;
        this.link = link;
        this.description = description;
        this.pubDate = pubDate;
    }
}
