package br.com.webmadria.sendmail.app;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailRequest {
    private String subject;
    private String from;
    private String to;
    private String body;
}
