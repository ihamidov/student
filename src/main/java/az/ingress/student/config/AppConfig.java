package az.ingress.student.config;

import java.util.List;
import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
@Data
public class AppConfig {

    private String name;

    private String version;

    private List<String> developers;

    private Map<String, String> numbers;
}
