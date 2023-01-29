package br.com.webmadria.followup.app.entrypoint.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class EmailResponse {

    private String id;
    private EmailStatusEnum status;

}
