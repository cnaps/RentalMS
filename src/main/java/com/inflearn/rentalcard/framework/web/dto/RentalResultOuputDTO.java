package com.inflearn.rentalcard.framework.web.dto;

import com.inflearn.rentalcard.domain.model.RentalCard;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter @Setter
public class RentalResultOuputDTO {
    public String userId;
    public String userNm;
    public Integer rentedCount;
    public long totalLateFee;

    public static RentalResultOuputDTO mapToDTO(RentalCard rental){
        RentalResultOuputDTO rentDTO = new RentalResultOuputDTO();
        rentDTO.setUserId(rental.getMember().getId());
        rentDTO.setUserNm(rental.getMember().getName());
        rentDTO.setRentedCount(rental.getRentItemList().size());
        rentDTO.setTotalLateFee(rental.getTotalLateFee().getPoint());
        return rentDTO;
    }
}
