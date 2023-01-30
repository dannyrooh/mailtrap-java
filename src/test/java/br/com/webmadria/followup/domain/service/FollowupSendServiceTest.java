package br.com.webmadria.followup.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.function.Supplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;
import br.com.webmadria.followup.domain.dataprovider.FollowupSendDataProvider;
import br.com.webmadria.followup.domain.entity.EmailEntity;

@ActiveProfiles("test")
public class FollowupSendServiceTest {

    FollowupSendService followupSendService;

    FollowupSendDataProvider followupSendDataProvider;

    @BeforeEach
    public void setUp() {
        this.followupSendDataProvider = Mockito.mock(FollowupSendDataProvider.class);
        this.followupSendService = new FollowupSendService(followupSendDataProvider);
    }

    @Test
    @DisplayName("Salva os dados do email")
    public void executeFollowupSendService() {

        Supplier<EmailEntity> newEntity = () -> EmailEntity
                .builder()
                .id("dfasda")
                .from("from@teste.com")
                .subject("teste")
                .body("<h1>Body body body</h1>")
                .build();

        EmailEntity emailEntity = newEntity.get();
        EmailEntity emailEntityReturn = newEntity.get();

        Mockito.when(followupSendDataProvider.save(emailEntity))
                .thenReturn(emailEntityReturn);

        var result = this.followupSendService.execute(emailEntity);

        assertNotNull(result.getId());
        assertEquals(result.getFrom(), "from@teste.com");

    }

}
