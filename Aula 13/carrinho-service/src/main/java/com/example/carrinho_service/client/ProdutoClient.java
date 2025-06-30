package com.example.carrinho_service.client;

import com.example.carrinho_service.dto.ProdutoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "produto-service")
public interface ProdutoClient {

    @GetMapping("/produtos/{id}")
    ProdutoDTO getProdutoById(@PathVariable("id") Long id);
}
