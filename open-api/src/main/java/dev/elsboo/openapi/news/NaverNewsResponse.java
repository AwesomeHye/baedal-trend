package dev.elsboo.openapi.news;

import lombok.Getter;

import java.util.List;

@Getter
public class NaverNewsResponse {
    private String lastBuildDate;
    private Long total;
    private Long start;
    private Long display;
    private List<NaverNews> items;
}
