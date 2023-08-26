package com.msa.rentalcard.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IDName {
    private String id;
    private String name;

    public static IDName sample(){
        return new IDName("scant","han");
    }

    public static void main(String[] args){
        System.out.println(IDName.sample());
    }
}