package br.com.murilo.planeja.infra;

import br.com.murilo.planeja.dominio.cartao.CartaoRepository;
import br.com.murilo.planeja.dominio.cartao.model.BandeiraCartao;
import br.com.murilo.planeja.dominio.cartao.model.CartaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Sandbox implements CommandLineRunner {
    //testes

    @Override
    public void run(String... args) throws Exception {
        salvarCartao();
    }

    @Autowired
    CartaoRepository repository;

    public void salvarCartao() {
        CartaoEntity cartao = new CartaoEntity();
        cartao.setNome("Itaú Personnalité ");
        cartao.setBandeira(BandeiraCartao.AMERICAN_EXPRESS);

        repository.save(cartao);
    }

}
