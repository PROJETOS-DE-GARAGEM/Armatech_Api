package com.estaciojava.Armatech.service;


import com.estaciojava.Armatech.classes.CrudServiceImpl;
import com.estaciojava.Armatech.model.Produto;
import com.estaciojava.Armatech.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends CrudServiceImpl<Produto, Long> {

    public ProdutoService(ProdutoRepository repository) { super(repository); }
}
