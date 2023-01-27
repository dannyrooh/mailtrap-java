package br.com.webmadria.sendmail.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailModel {
    private String id;
    private String subject;
    private String from;
    private String to;
    private String body;

}
