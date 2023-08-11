package com.msa.rentalcard.application.usecase;

import com.msa.rentalcard.framework.web.dto.RentItemOutputDTO;
import com.msa.rentalcard.framework.web.dto.RentalCardOutputDTO;
import com.msa.rentalcard.framework.web.dto.RetrunItemOupputDTO;
import com.msa.rentalcard.framework.web.dto.UserInputDTO;

import java.util.List;

public interface InquiryUsecase {
    public RentalCardOutputDTO getRentalCard(UserInputDTO userInputDTO);
    public List<RentItemOutputDTO> getAllRentItem(UserInputDTO userInputDTO);
    public List<RetrunItemOupputDTO> getAllReturnItem(UserInputDTO userInputDTO);

}
