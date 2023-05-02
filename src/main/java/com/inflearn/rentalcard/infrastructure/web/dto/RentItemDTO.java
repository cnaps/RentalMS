package com.inflearn.rentalcard.infrastructure.web.dto;

import com.inflearn.rentalcard.domain.model.RentalCard;
import com.inflearn.rentalcard.domain.model.vo.IDName;
import com.inflearn.rentalcard.domain.model.vo.Item;

import junit.framework.Test;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentItemDTO {
    public IDNameDTO rentalUser;
    public ItemDTO rentItem;


    public static RentItemDTO fromEntity(RentalCard rental) {
        RentItemDTO rentalDto = new RentItemDTO();
        rentalDto.setRentalUser(rental.getMember());
        return rentalDto;
    }

}
