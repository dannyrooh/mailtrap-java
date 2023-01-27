package br.com.webmadria.sendmail.app;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailResponse {

    private String id;
    private EmailStatusEnum status;

}
