package br.com.webmadria.sendmail.app;

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

import br.com.webmadria.sendmail.domain.model.EmailModel;
import br.com.webmadria.sendmail.domain.usecase.SendEmailUseCase;

@ActiveProfiles("test")
@WebMvcTest
public class SendMailControllerTest {

    static String SENDMAIL_API = "/email/sendmail";

    @Autowired
    MockMvc mockMvc;

    @MockBean
    SendEmailUseCase sendEmailUseCase;

    @Test
    @DisplayName("Cria o envio de um email com sucesso")
    public void createSendMail() throws JsonProcessingException {

        EmailRequest emailRequest = EmailRequest
                .builder()
                .from("from@teste.com")
                .subject("Teste de Envio de Email")
                .to("to@teste.com")
                .body(" body email de teste")
                .build();

        EmailModel emailModel = (new ModelMapper()).map(emailRequest, EmailModel.class);
        emailModel.setId("15646-fdasd");

        BDDMockito.given(sendEmailUseCase.execute(Mockito.any(EmailRequest.class))).willReturn(emailModel);

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
                    .andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("Erro quando os dados de envio no corpo do email estiverem inválidos")
    public void createInvalidSendMail() {

    }
}
