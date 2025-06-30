package com.example.carrinho_service.service;

import com.example.carrinho_service.client.ProdutoClient;
import com.example.carrinho_service.dto.ProdutoDTO;
import com.example.carrinho_service.model.ItemCarrinho;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarrinhoService {

    private final ProdutoClient produtoClient;
    private final List<ItemCarrinho> carrinho = new ArrayList<>();

    public CarrinhoService(ProdutoClient produtoClient) {
        this.produtoClient = produtoClient;
    }

    public void adicionarProduto(Long produtoId, int quantidade) {
        ProdutoDTO produto = produtoClient.getProdutoById(produtoId);
        carrinho.add(new ItemCarrinho(produto.getId(), produto.getNome(), produto.getPreco(), quantidade));
    }

    public void removerProduto(Long produtoId) {
        carrinho.removeIf(item -> item.getProdutoId().equals(produtoId));
    }

    public List<ItemCarrinho> listarItens() {
        return carrinho;
    }

    public double calcularTotal() {
        return carrinho.stream().mapToDouble(ItemCarrinho::getSubtotal).sum();
    }
}
