package com.cg.bankapp.command.events;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCreateEvent {
	private int id;
	private String uid;
	private String firstName;
	private String lastName;
	private String username;
}
