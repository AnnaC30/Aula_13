package com.example.carrinho_service.controller;

import com.example.carrinho_service.model.ItemCarrinho;
import com.example.carrinho_service.service.CarrinhoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @PostMapping("/adicionar")
    public void adicionarProduto(@RequestParam Long produtoId, @RequestParam int quantidade) {
        carrinhoService.adicionarProduto(produtoId, quantidade);
    }

    @DeleteMapping("/remover/{produtoId}")
    public void removerProduto(@PathVariable Long produtoId) {
        carrinhoService.removerProduto(produtoId);
    }

    @GetMapping
    public List<ItemCarrinho> listarItens() {
        return carrinhoService.listarItens();
    }

    @GetMapping("/total")
    public double calcularTotal() {
        return carrinhoService.calcularTotal();
    }
}
