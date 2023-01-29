package br.com.webmadria.followup.domain.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import br.com.webmadria.followup.domain.entity.EmailEntity;
import br.com.webmadria.followup.domain.usecase.FollowupSendUseCase;

@ActiveProfiles("test")
public class FollowupSendServiceTest {

    private FollowupSendUseCase followupSendUseCase;

    @BeforeEach
    public void setUp() {
        this.followupSendUseCase = new FollowupSendService();
    }

    @Test
    @DisplayName("Envia um email")
    public void executeFollowupSendService() {

        EmailEntity emailEntity = EmailEntity.builder().id("dfasda").from("from@teste.com").subject("teste")
                .body("<h1>Body body body</h1>").build();

        var result = followupSendUseCase.execute(emailEntity);

        assertNotNull(result.getId());

    }

}
