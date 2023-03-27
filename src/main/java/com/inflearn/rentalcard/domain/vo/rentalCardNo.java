package com.inflearn.rentalcard.domain.vo;

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
public class rentalCardNo implements Serializable {

    private String no;

    static UUID uuid = UUID.randomUUID();

    public static rentalCardNo createRentalCardNo(){
        String year = String.valueOf(LocalDate.now().getYear());
        String str = year + '-' +uuid.toString();
        rentalCardNo rentalCardNo1 = new rentalCardNo();
        rentalCardNo1.setNo(str);
        return rentalCardNo1;
    }

    public static rentalCardNo sample(){
        return new rentalCardNo("2022-00001");
    }

    public static void main(String[] args) {
        System.out.printf(createRentalCardNo().toString());
        System.out.printf(sample().toString());
    }
}
