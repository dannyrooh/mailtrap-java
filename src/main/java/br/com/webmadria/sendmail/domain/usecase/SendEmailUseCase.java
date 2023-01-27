package br.com.webmadria.sendmail.domain.usecase;

import br.com.webmadria.sendmail.app.EmailRequest;
import br.com.webmadria.sendmail.domain.model.EmailModel;

public interface SendEmailUseCase {

    public EmailModel execute(EmailRequest emailRequest);
}
