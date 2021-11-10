package com.telran.contact.api.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString

public class AuthoRequestDto {
    String email;
    String password;
}
