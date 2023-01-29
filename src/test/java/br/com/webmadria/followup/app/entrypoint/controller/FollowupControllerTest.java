package br.com.webmadria.followup.app.entrypoint.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.webmadria.followup.app.entrypoint.dto.EmailRequest;
import br.com.webmadria.followup.domain.entity.EmailEntity;
import br.com.webmadria.followup.domain.usecase.FollowupSendUseCase;

@ActiveProfiles("test")
@WebMvcTest
public class FollowupControllerTest {

    static String SENDMAIL_API = "/email/send";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    FollowupSendUseCase followupSendUseCase;

    @Test
    @DisplayName("Envio de um email com sucesso")
    public void createSendMail() throws JsonProcessingException {

        EmailRequest emailRequest = EmailRequest
                .builder()
                .from("from@teste.com")
                .subject("Teste de Envio de Email")
                .to("to@teste.com")
                .body(" body email de teste")
                .build();

        EmailEntity emailEntity = (new ModelMapper()).map(emailRequest, EmailEntity.class);
        emailEntity.setId("15646-fdasd");

        BDDMockito.given(followupSendUseCase.execute(Mockito.any(EmailEntity.class))).willReturn(emailEntity);

        String json = new ObjectMapper().writeValueAsString(emailRequest);

        MockHttpServletRequestBuilder content = MockMvcRequestBuilders
                .post(SENDMAIL_API)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(json);

        try {
            this.mockMvc
                    .perform(content)
                    .andExpect(MockMvcResultMatchers.status().isCreated())
                    .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
                    .andExpect(MockMvcResultMatchers.jsonPath("from").value(emailEntity.getFrom()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
