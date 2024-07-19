package com.SSS.EmailSender.JWT_Model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class LoginDTO {


    private String id;
    private String password;
}