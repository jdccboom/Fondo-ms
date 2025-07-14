package com.bts.api.fondos;

import com.bts.api.fondos.requests.CancelarFondoRequest;
import com.bts.api.fondos.requests.SuscribirFondoRequest;
import com.bts.model.common.PageRequests;
import com.bts.model.common.exception.ErrorException;
import com.bts.model.fondo.Fondo;
import com.bts.model.transaccion.TipoTransaccion;
import com.bts.model.transaccion.Transaccion;
import com.bts.usecase.fondos.FondosUseCase;
import com.bts.usecase.transaccion.TransaccionUseCase;
import io.micrometer.core.ipc.http.HttpSender;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
@RestController
@RequestMapping(value = "/api/fondos", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class FondosController {

    private final FondosUseCase fondosUseCase;
    private final TransaccionUseCase transaccionUseCase;

    @PostMapping("/suscribir")
    public ResponseEntity<?> suscribir(@Valid @RequestBody SuscribirFondoRequest suscribirFondoRequest) throws Exception {

        Transaccion guardarTransaccion = Transaccion.builder()
                .fondoId(suscribirFondoRequest.fondoId())
                .clienteId(suscribirFondoRequest.clienteId())
                .monto(suscribirFondoRequest.monto())
                .tipo(TipoTransaccion.SUSCRIPCION.getTipo())
                .fecha(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(fondosUseCase.suscribir(guardarTransaccion));
    }

    @PostMapping("/cancelar")
    public ResponseEntity<?> cancelar(@Valid @RequestBody CancelarFondoRequest cancelarFondoRequest) throws Exception {
        Transaccion transaccion = Transaccion.builder()
                .fondoId(cancelarFondoRequest.fondoId())
                .clienteId(cancelarFondoRequest.clienteId())
                .tipo(TipoTransaccion.CANCELACION.getTipo())
                .fecha(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(fondosUseCase.cancelarFondo(transaccion));
    }

    @GetMapping("/list")
    public ResponseEntity<?> obtenerFondos(){
        return ResponseEntity.ok(fondosUseCase.obtenerFondos());
    }

    @GetMapping("/historial/{id}")
    public ResponseEntity<?> obtenerFondosHistorial(@PathVariable("id") String id,
                                                    @RequestParam(name = "page", defaultValue = "0") int page,
                                                    @RequestParam(name = "size", defaultValue = "10") int size,
                                                    @RequestParam(name = "sort", required = false) String sort) throws Exception {

        PageRequests pageRequests = PageRequests.builder()
                .page(page)
                .size(size)
                .sort(sort)
                .build();

        return ResponseEntity.ok(transaccionUseCase.obtenerTransaccionesClienteId(id, pageRequests));
    }

}
