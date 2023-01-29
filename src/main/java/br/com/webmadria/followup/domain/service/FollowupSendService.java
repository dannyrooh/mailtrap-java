package br.com.webmadria.followup.domain.service;

import org.springframework.stereotype.Service;

import br.com.webmadria.followup.domain.entity.EmailEntity;
import br.com.webmadria.followup.domain.usecase.FollowupSendUseCase;

@Service
public class FollowupSendService implements FollowupSendUseCase {

    public EmailEntity execute(EmailEntity emailEntity) {

        return emailEntity;
    }

}
