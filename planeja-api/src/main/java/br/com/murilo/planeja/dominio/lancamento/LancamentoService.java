package br.com.murilo.planeja.dominio.lancamento;

import br.com.murilo.planeja.common.exceptions.ValidationException;
import br.com.murilo.planeja.dominio.cartao.CartaoRepository;
import br.com.murilo.planeja.dominio.cartao.model.CartaoEntity;
import br.com.murilo.planeja.dominio.categoria.CategoriaRepository;
import br.com.murilo.planeja.dominio.categoria.model.CategoriaEntity;
import br.com.murilo.planeja.dominio.lancamento.dto.LancamentoDetalhes;
import br.com.murilo.planeja.dominio.lancamento.dto.LancamentoForm;
import br.com.murilo.planeja.dominio.lancamento.mapper.LancamentoMapper;
import br.com.murilo.planeja.dominio.lancamento.model.LancamentoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private LancamentoValidator validator;

    @Autowired
    private LancamentoMapper mapper;

    public LancamentoDetalhes criar(LancamentoForm form) {
        CategoriaEntity categoria = categoriaRepository.findById(form.categoriaId()).orElse(null);

        CartaoEntity cartao = null;
        if (form.cartaoId() != null) {
            cartao = cartaoRepository.findById(form.cartaoId()).orElse(null);
        }

        var result = validator.validar(form, categoria, cartao);
        if (result.isInvalido()) {
            throw new ValidationException(result.getCampoInvalidos());
        }

        LancamentoEntity entity = mapper.toEntity(form, categoria, cartao);
        repository.save(entity);

        return mapper.toDetalhes(entity);
    }






}
