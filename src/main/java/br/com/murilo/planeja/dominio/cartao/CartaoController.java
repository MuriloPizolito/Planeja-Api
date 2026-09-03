package br.com.murilo.planeja.dominio.cartao;

import br.com.murilo.planeja.dominio.cartao.dto.CartaoDetalhes;
import br.com.murilo.planeja.dominio.cartao.dto.CartaoForm;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cartoes")
public class CartaoController {

    @Autowired
    private CartaoService service;

    @PostMapping
    public ResponseEntity<CartaoDetalhes> criar(@RequestBody @Valid CartaoForm dto) {
        CartaoDetalhes detalhes = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalhes);
    }


}
