package br.com.webmadria.followup.domain.usecase;

import br.com.webmadria.followup.domain.entity.EmailEntity;

public interface FollowupSendUseCase {

    public EmailEntity execute(EmailEntity EmailEntity);
}
