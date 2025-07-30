package dev.manfertej.yagm.common.properties;

/* Keep this for using messages from app properties
(I don't really like it that way. At least for this.)
@Configuration
@ConfigurationProperties(prefix = "messages")
@Data
 */
public class ClientMessages {

	public final static String ALREADY_EXISTS = "Client exception - Client already exists";
	public final static String DOES_NOT_EXISTS = "Client exception - Client does not exists";
	public final static String REGISTERED = "Client registered successfully";
	public final static String DELETED = "Client deleted successfully";
	public final static String INVALID_DATA = "Invalid client data";
}
