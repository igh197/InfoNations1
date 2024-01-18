package com.example.InfoNations.network;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.Accessors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
public class LoginDto {
    String username;
    String password;
}
