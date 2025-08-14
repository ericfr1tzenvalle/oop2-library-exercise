/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.library.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Éric
 */
public abstract class Publicacao {

    private String titulo;
    private LocalDate data;

    public Publicacao(String titulo, LocalDate data) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título não pode ser nulo ou vazio.");
        }
        
        if (data == null || data.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("A data não pode ser nula ou uma data futura.");
        }
        this.titulo = titulo;
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getData() {
        return data;
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(titulo,data);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        // Não funcionaria pois é uma classe abstrata
        // if(getClass() != obj.getClass()){
        //     return false;
        // }
        if (!(obj instanceof Publicacao)) {
            return false;
        }
        final Publicacao other = (Publicacao) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return Objects.equals(this.data, other.data);

    }

}
