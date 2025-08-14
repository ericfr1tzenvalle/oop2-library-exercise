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


public class Revista extends Publicacao {

    private int edicao;
    private String editora;

    public Revista(String titulo, LocalDate data, String editora, int edicao) {
        super(titulo, data);
        if(edicao <= 0){
            throw new IllegalArgumentException("Edição não pode ser nula ou zero.");
        }
        if(editora == null || editora.trim().isEmpty()){
            throw new IllegalArgumentException("Editora não pode ser nula ou vazia");
        }
        this.edicao = edicao;
        this.editora = editora;
    }

    public int getEdicao() {
        return edicao;
    }

    public String getEditora() {
        return editora;
    }

    @Override
    public int hashCode() {
        // 1. Pegamos o hash da superclasse pra incluir seus campos na conta.
        int hash = super.hashCode();
        // 2. Adicionamos os camos dessa classe no calculo.
        hash = 79 * hash + Objects.hash(this.edicao,this.editora);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        // 1. Verificação de referência: se são o mesmo objeto, são iguais.
        if (this == obj) {
            return true;
        }
        // 2. Verificação de nulidade: o objeto não pode ser igual a null.
        if (obj == null) {
            return false;
        }
        // 3. Verificação de tipo: os objetos devem ser da mesma classe.
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        // 4. Primeiro, verifica se a parte "Publicacao" dos objetos é igual.
        if (!super.equals(obj)) {
            return false;
        }

        // 5. Se a parte da superclasse for igual, convertemos o objeto
        //    e comparamos os atributos específicos desta classe.
        final Revista other = (Revista) obj;
        if (this.edicao != other.edicao) {
            return false;
        }
        
        // Objects.equals é seguro para valores que podem ser nulos.
        return Objects.equals(this.editora, other.editora);
    }

   

    @Override
    public String toString() {
        return "Revista: " + this.getTitulo() + " (" + this.getData().getMonthValue() + "/" + this.getData().getYear() + ")" + " - editora " + this.getEditora() + " - edicao n:" + this.getEdicao();
    }

}
