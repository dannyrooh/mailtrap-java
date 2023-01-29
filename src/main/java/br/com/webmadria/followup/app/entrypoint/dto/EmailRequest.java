package br.com.webmadria.followup.app.entrypoint.dto;

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
