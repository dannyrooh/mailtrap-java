package br.com.webmadria.followup.app.provider.model;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailModel {

    private UUID id;
    private String subject;
    private String from;
    private String to;
    private String body;
    private LocalDateTime createdat;
    private LocalDateTime sendat;
    private EmailModelStatus status;

}
