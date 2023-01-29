package br.com.webmadria.followup.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailEntity {
    private String id;
    private String subject;
    private String from;
    private String to;
    private String body;

}
