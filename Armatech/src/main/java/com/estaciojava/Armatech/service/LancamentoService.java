package com.estaciojava.Armatech.service;


import com.estaciojava.Armatech.classes.CrudServiceImpl;
import com.estaciojava.Armatech.model.Lancamento;
import com.estaciojava.Armatech.repository.LancamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService extends CrudServiceImpl<Lancamento, Long> {

    public LancamentoService(LancamentoRepository repository) {
        super(repository);
    }

    @Override
    public Lancamento save(Lancamento entity) {
        System.out.println(entity.getId());
        System.out.println( entity.getDataEntrada());
        System.out.println( entity.getDataSaida());
        return super.save(entity);
    }
}