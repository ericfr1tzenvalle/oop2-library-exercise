/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Éric
 */
public class Livro extends Publicacao {
    private int numPaginas;
    private String[] autores;
    
    public Livro(String titulo, LocalDate data, int numPaginas, String... autores) {
        super(titulo, data);
        if (numPaginas <= 0) {
            throw new IllegalArgumentException("O número de páginas deve ser positivo.");
        }
        if (autores == null || autores.length == 0) {
            throw new IllegalArgumentException("O livro deve ter pelo menos um autor.");
        }
        this.numPaginas = numPaginas;
        this.autores = autores;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public String[] getAutores() {
        return autores;
    }

    @Override
    public String toString() {
        return "Livro: " + this.getTitulo()+ " (" + this.getData().getYear() + ") - " + this.getNumPaginas() + " paginas - Autores: " + String.join(", ", this.autores);
        
    }
    
    @Override
    public int hashCode(){
        int hash = super.hashCode();
        hash = 31 * hash + Arrays.deepHashCode(this.autores);
        hash = 31 * hash + Objects.hashCode(this.numPaginas);
        return hash;
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
       if(!super.equals(obj)){
           return false;
       }
       
       final Livro other = (Livro) obj;
       if(this.numPaginas != other.numPaginas){
           return false;
       }
       // Arrays.deepEquals é usado para comparar arrays de objetos.
        return Arrays.deepEquals(this.autores, other.autores);
       
       
    }

    public int getPaginas() {
       return numPaginas;
    }
    
    
    
    
    
}
