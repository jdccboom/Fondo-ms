package com.bts.api.fondos;

import com.bts.api.fondos.requests.SuscribirFondoRequest;
import com.bts.model.transaccion.TipoTransaccion;
import com.bts.model.transaccion.Transaccion;
import com.bts.usecase.fondos.FondosUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FondosController.class)
@ContextConfiguration(classes = {FondosController.class})
@AutoConfigureMockMvc(addFilters = false)
public class FondosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FondosUseCase fondosUseCase;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void suscribirTest() throws Exception {

        SuscribirFondoRequest suscribirFondoRequest = new SuscribirFondoRequest(
                "1",
                "1",
                new BigDecimal(100000)
        );

        Transaccion transaccion = Transaccion.builder()
                .fondoId(suscribirFondoRequest.fondoId())
                .clienteId(suscribirFondoRequest.clienteId())
                .monto(suscribirFondoRequest.monto())
                .tipo(TipoTransaccion.SUSCRIPCION.getTipo())
                .transaccionId("1")
                .build();

        when(fondosUseCase.suscribir(Mockito.any(Transaccion.class))).thenReturn(transaccion);

        mockMvc.perform(post("/api/fondos/suscribir")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(suscribirFondoRequest)))
                .andExpect(status().isOk());


    }
    @Test
    public void cancelarTest() throws Exception {

        SuscribirFondoRequest suscribirFondoRequest = new SuscribirFondoRequest(
                "1",
                "1",
                new BigDecimal(100000)
        );

        Transaccion transaccion = Transaccion.builder()
                .fondoId(suscribirFondoRequest.fondoId())
                .clienteId(suscribirFondoRequest.clienteId())
                .monto(suscribirFondoRequest.monto())
                .tipo(TipoTransaccion.SUSCRIPCION.getTipo())
                .transaccionId("1")
                .build();

        when(fondosUseCase.suscribir(Mockito.any(Transaccion.class))).thenReturn(transaccion);

        mockMvc.perform(post("/api/fondos/cancelar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(suscribirFondoRequest)))
                .andExpect(status().isOk());


    }
    @Test
    public void obtenerFondosTest() throws Exception {
        when(fondosUseCase.obtenerFondos()).thenReturn(List.of());
        mockMvc.perform(get("/api/fondos/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
