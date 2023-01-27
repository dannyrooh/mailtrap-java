package br.com.webmadria.sendmail.app;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.webmadria.sendmail.domain.model.EmailModel;
import br.com.webmadria.sendmail.domain.usecase.SendEmailUseCase;

@RestController
@RequestMapping("/email/sendmail")
public class SendMailController {

    final SendEmailUseCase sendEmailUseCase;

    public SendMailController(SendEmailUseCase sendEmailUseCase) {
        this.sendEmailUseCase = sendEmailUseCase;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EmailResponse send(@RequestBody EmailRequest emailRequest) {

        EmailModel emailModel = sendEmailUseCase.execute(emailRequest);

        ModelMapper modelMapper = new ModelMapper();
        EmailResponse emailResponse = modelMapper.map(emailModel, EmailResponse.class);
        emailResponse.setStatus(EmailStatusEnum.PENDING);

        return emailResponse;

    }

}
