package com.inflearn.rentalcard.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.time.LocalDate;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class RentalItem {

    @Embedded
    private Item item;
    private LocalDate rentalDate;
    private boolean overdued;
    private LocalDate overdueStartDate;

    public static RentalItem createRentalItem(Item item)
    {
        return new RentalItem(item,LocalDate.now(),false,null);
    }

    public static RentalItem sample(){
        return new RentalItem(Item.sample(),LocalDate.now(),false,null);
    }
}
