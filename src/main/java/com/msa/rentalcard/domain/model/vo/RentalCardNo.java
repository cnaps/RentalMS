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
        String str = year + '-' + uuid.toString();
        RentalCardNo rentalCardNo1 = new RentalCardNo();

        rentalCardNo1.setNo(str);
        return rentalCardNo1;
    }

    public static RentalCardNo sample(){
        return new RentalCardNo("2023-00001");
    }


    public static void main(String[] args) {
        System.out.printf(createRentalCardNo().toString());
        System.out.printf(sample().toString());
    }
}
