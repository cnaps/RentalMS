package com.msa.rentalcard.framework.web.dto;

import com.msa.rentalcard.domain.model.vo.ReturnItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RetrunItemOupputDTO {
    private Integer itemNo;
    private String itemtitle;
    private LocalDate returnDate;

    public static RetrunItemOupputDTO mapToDTO(ReturnItem returnItem)
    {
        RetrunItemOupputDTO rentItemOutputDTO = new RetrunItemOupputDTO();
        rentItemOutputDTO.setItemNo(returnItem.getItem().getItem().getNo());
        rentItemOutputDTO.setItemtitle(returnItem.getItem().getItem().getTitle());
        rentItemOutputDTO.setReturnDate(returnItem.getReturnDate());
        return rentItemOutputDTO;
    }

}
