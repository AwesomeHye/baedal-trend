package dev.elsboo.openapi.news;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = NaverNewsClient.class)
class NaverNewsClientTest {
    @Autowired
    private NaverNewsClient naverNewsClient;

    @Test
    void getNews() {
        List<NaverNews> itermsList = naverNewsClient.getNews();
        assertThat(itermsList).isNotEmpty();
    }

}
