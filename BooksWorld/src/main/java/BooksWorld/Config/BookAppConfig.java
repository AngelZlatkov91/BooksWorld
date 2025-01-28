package BooksWorld.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "book.ui")
public class BookAppConfig {
    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

    public BookAppConfig setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }
}
