package br.com.webmadria.followup.domain.dataprovider;

import br.com.webmadria.followup.domain.entity.EmailEntity;

public interface FollowupSendDataProvider {

    public EmailEntity save(EmailEntity EmailEntity);
}
