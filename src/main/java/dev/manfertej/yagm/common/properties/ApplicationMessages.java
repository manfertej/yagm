package dev.manfertej.yagm.common.properties;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "messages")
@Data
public class ApplicationMessages {

	public String clientAlreadyExists;
	public String clientDoesNotExist;
	public String clientRegistered;
	public String clientDeleted;
	public String invalidClientData;
}
