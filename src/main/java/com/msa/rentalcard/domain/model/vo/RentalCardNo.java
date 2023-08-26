package com.msa.rentalcard.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Data
public class RentalCardNo implements Serializable {

    private String no;

    public static RentalCardNo createRentalCardNo(){
        UUID uuid = UUID.randomUUID();
        String year = String.valueOf(LocalDate.now().getYear());
        String str = year + '-' + uuid;
        RentalCardNo rentalCardNo = new RentalCardNo();
        rentalCardNo.setNo(str);
        return rentalCardNo;
    }

    public static RentalCardNo sample(){
        return RentalCardNo.createRentalCardNo();
    }

    public static void main(String[] args){
        System.out.println(RentalCardNo.sample());
    }
}
