package br.com.webmadria.followup.app.provider.dataprovider;

import org.springframework.stereotype.Component;

import br.com.webmadria.followup.domain.dataprovider.FollowupSendDataProvider;
import br.com.webmadria.followup.domain.entity.EmailEntity;

@Component
public class FolloupProvider implements FollowupSendDataProvider {

    @Override
    public EmailEntity save(EmailEntity EmailEntity) {
        // TODO Auto-generated method stub
        return EmailEntity;
    }

}
