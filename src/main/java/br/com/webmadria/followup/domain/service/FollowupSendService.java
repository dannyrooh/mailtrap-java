package br.com.webmadria.followup.domain.service;

import org.springframework.stereotype.Service;

import br.com.webmadria.followup.domain.dataprovider.FollowupSendDataProvider;
import br.com.webmadria.followup.domain.entity.EmailEntity;
import br.com.webmadria.followup.domain.usecase.FollowupSendUseCase;

@Service
public class FollowupSendService implements FollowupSendUseCase {

    private FollowupSendDataProvider followupSendDataProvider;

    public FollowupSendService(FollowupSendDataProvider followupSendDataProvider) {
        this.followupSendDataProvider = followupSendDataProvider;
    }

    public EmailEntity execute(EmailEntity emailEntity) {

        // salva no banco de dados
        var entity = followupSendDataProvider.save(emailEntity);

        //

        return entity;

    }

}
