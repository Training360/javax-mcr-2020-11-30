package training.employees;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

@Gateway
@EnableConfigurationProperties(AddressesConfig.class)
public class AddressesGateway {

    private final AddressesConfig addressesConfig;

    private final RestTemplate restTemplate;

    public AddressesGateway(AddressesConfig addressesConfig, RestTemplateBuilder restTemplateBuilder) {
        this.addressesConfig = addressesConfig;
        this.restTemplate = restTemplateBuilder.build();
    }

    public AddressDto getAddress(String name) {
        return
                restTemplate.getForObject(addressesConfig.getUrl(),
                        AddressDto.class, name);
    }
}
