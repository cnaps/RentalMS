package com.inflearn.rentalcard.application.usecase;

import com.inflearn.rentalcard.domain.model.RentalCard;
import com.inflearn.rentalcard.domain.model.vo.RentItem;
import com.inflearn.rentalcard.domain.model.vo.ReturnItem;
import com.inflearn.rentalcard.framework.web.dto.RentItemOutputDTO;
import com.inflearn.rentalcard.framework.web.dto.RentalCardOutputDTO;
import com.inflearn.rentalcard.framework.web.dto.RetrunItemOupputDTO;
import com.inflearn.rentalcard.framework.web.dto.UserInputDTO;

import java.util.List;

public interface InquiryUsecase {
    public RentalCardOutputDTO getRentalCard(UserInputDTO userInputDTO);
    public List<RentItemOutputDTO> getAllRentItem(UserInputDTO userInputDTO);
    public List<RetrunItemOupputDTO> getAllReturnItem(UserInputDTO userInputDTO);

}
