package br.com.webmadria.sendmail.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email/sendmail")
public class SendMailController {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)

    public EmailResponse send(@RequestBody EmailRequest emailRequest) {
        return EmailResponse
                .builder()
                .id("UUID-45646-32342")
                .status(EmailStatusEnum.PENDING)
                .build();

    }

}
