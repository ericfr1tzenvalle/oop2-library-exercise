/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Éric
 */
public class Livraria {
    private String nome;
    private ArrayList<Impressao> estoque;

    public Livraria(String nome) {
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
        this.estoque = new ArrayList<Impressao>();
    }
    
    public int getExemplares(Publicacao pub){
        int contador = 0;
        for(Impressao imp: estoque){
            if(imp.getPublicacao().equals(pub)){
                contador++;
            }
        }
        return contador;
    }
    
    public void addEstoque(Publicacao pub){
        if(pub != null){
            Impressao imp = new Impressao(pub);
            estoque.add(imp);
        }
    }
    
    public void addEstoque(Publicacao pub, int quantidade){
        if(pub == null){
            throw new IllegalArgumentException("Não pode ser nula");
        }
        for(int i = 0; i < quantidade; i++){
            Impressao imp = new Impressao(pub);
            estoque.add(imp);
        }
    }
    
    public Impressao vende(Publicacao pub){
        Iterator<Impressao> iterator = estoque.iterator();
        while(iterator.hasNext()){
            Impressao exemplar = iterator.next();
            if(exemplar.getPublicacao().equals(pub)){
                iterator.remove();
                return exemplar;
            }
        }
        return null;
        
    }
    
    
    
    
}
