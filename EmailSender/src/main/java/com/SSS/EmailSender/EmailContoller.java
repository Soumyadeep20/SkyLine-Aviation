//---------------email API Controller

package com.SSS.EmailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailContoller {
     @Autowired
     EmailService emailService;

     @PostMapping("/send")
     public ResponseEntity<String> send(@RequestParam String to, @RequestParam String body, @RequestParam String sub)
     {
          emailService.send(to,body,sub);
          return new ResponseEntity<>(null, HttpStatus.OK);
     }
}
