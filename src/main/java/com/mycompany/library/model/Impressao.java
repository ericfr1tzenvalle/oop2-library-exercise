/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author Éric
 */

public class Impressao {

    private LocalDate data;
    private Publicacao publicacao;
    private String codigo;
    private static int contador = 0;

    public Impressao(Publicacao publicacao) {
        this.data = LocalDate.now();
        if(publicacao == null){
            throw new IllegalArgumentException("Publicação não pode ser nula.");
        }
        this.publicacao = publicacao;
        
        String prefixo;
        if (publicacao instanceof Livro) {
            prefixo = "L";
        } else if (publicacao instanceof Revista) {
            prefixo = "R";
        } else {
            prefixo = "X";
        }
        this.codigo = prefixo + contador;
        contador++;
    }

    public LocalDate getData() {
        return data;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getContador() {
        return contador;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return String.format(
                "exemplar: %s| Data impressao: %s\n%s",
                codigo,
                data.format(formatter),
                publicacao.toString()
        );
    }
    
    
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        final Impressao other = (Impressao) obj;
        // Comparamos apenas o código, pois ele é o identificador único de um exemplar.
        return Objects.equals(this.codigo, other.codigo);
    }
    

}
