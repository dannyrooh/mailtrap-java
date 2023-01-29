package br.com.webmadria.followup.app.entrypoint.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.webmadria.followup.app.entrypoint.dto.EmailResponse;
import br.com.webmadria.followup.domain.entity.EmailEntity;
import br.com.webmadria.followup.domain.service.FollowupSendService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("email/send")
@RestController
@AllArgsConstructor
@NoArgsConstructor
public class FollowupController {

    private ModelMapper modelMapper;
    private FollowupSendService followupSendService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public EmailResponse postMethodName(@RequestBody EmailEntity emailEntity) {

        var mapEntity = modelMapper.map(emailEntity, EmailEntity.class);
        var entityReturn = followupSendService.execute(mapEntity);
        EmailResponse emailResponse = modelMapper.map(entityReturn, EmailResponse.class);

        // return new ResponseEntity<EmailResponse>(emailResponse, HttpStatus.CREATED);

        return emailResponse;
    }

}
