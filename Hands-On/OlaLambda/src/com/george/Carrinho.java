package com.george;

import java.util.List;

public class Carrinho {
    private List<Produto> lista;

    public Carrinho(List<Produto> lista) {
        this.lista = lista;
    }

    public void darDesconto(int poncentagem, Condicao<Produto> cond) {
        for (Produto p : lista) {
            if (cond.incluir(p)) {
                p.setValor(p.getValor() * (100 - poncentagem) / 100);
            }
        }
    }

    public List<Produto> getLista() {
        return lista;
    }
}
