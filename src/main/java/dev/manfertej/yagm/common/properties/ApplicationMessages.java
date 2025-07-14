package dev.manfertej.yagm.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "messages")
public class ApplicationMessages {

	public static String clientAlreadyExists;
	public static String clientDoesNotExist;
	public static String clientRegistered;
	public static String clientDeleted;
}
