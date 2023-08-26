package com.msa.rentalcard.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Getter @Setter
public class ReturnItem {
    @Embedded
    private RentItem item;
    private LocalDate returnDate;

    public static ReturnItem creatReturnItem(RentItem rentItem){
        return new ReturnItem(rentItem,LocalDate.now());
    }


    private static ReturnItem sample(){
        return ReturnItem.creatReturnItem(RentItem.sample());
    }
}
