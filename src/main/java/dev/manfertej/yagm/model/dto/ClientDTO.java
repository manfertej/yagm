package dev.manfertej.yagm.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

	private Long ID;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	@Pattern(regexp = "^\\d{8}[A-Z]$")
	private String dni;

	@NotNull
	private int phoneNumber;

	private String country;

	private String city;

	private String address;

	private int zip;

}
