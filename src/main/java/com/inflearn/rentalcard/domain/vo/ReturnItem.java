package com.inflearn.rentalcard.domain.vo;

import com.inflearn.rentalcard.domain.vo.RentalItem;
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
    private RentalItem item;
    private LocalDate returnDate;

    public static ReturnItem sample(){
        return new ReturnItem(RentalItem.sample(),LocalDate.now());
    }

    public static ReturnItem createRetunItem(RentalItem rentalItem){
        return new ReturnItem(rentalItem,LocalDate.now());
    }
}
