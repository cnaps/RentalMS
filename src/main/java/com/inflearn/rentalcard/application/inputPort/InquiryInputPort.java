package com.inflearn.rentalcard.application.inputPort;

import com.inflearn.rentalcard.application.ouputPort.RentalCardOuputPort;
import com.inflearn.rentalcard.application.usecase.InquiryUsecase;
import com.inflearn.rentalcard.domain.model.RentalCard;
import com.inflearn.rentalcard.domain.model.vo.RentItem;
import com.inflearn.rentalcard.domain.model.vo.ReturnItem;
import com.inflearn.rentalcard.framework.web.dto.RentItemOutputDTO;
import com.inflearn.rentalcard.framework.web.dto.RentalCardOutputDTO;
import com.inflearn.rentalcard.framework.web.dto.RetrunItemOupputDTO;
import com.inflearn.rentalcard.framework.web.dto.UserInputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class InquiryInputPort implements InquiryUsecase {

    private final RentalCardOuputPort rentalCardOuputPort;
    @Override
    public RentalCardOutputDTO getRentalCard(UserInputDTO userInputDTO) {

        RentalCard loadedRentalCard = rentalCardOuputPort.loadRentalCard(userInputDTO.UserId);

        return RentalCardOutputDTO.mapToDTO(loadedRentalCard);
    }

    @Override
    public List<RentItemOutputDTO> getAllRentItem(UserInputDTO userInputDTO) {
        RentalCard loadedRentalCard = rentalCardOuputPort.loadRentalCard(userInputDTO.UserId);
        return loadedRentalCard.getRentItemList().stream().map(RentItemOutputDTO::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<RetrunItemOupputDTO> getAllReturnItem(UserInputDTO userInputDTO) {
        RentalCard loadedRentalCard = rentalCardOuputPort.loadRentalCard(userInputDTO.UserId);
        return loadedRentalCard.getReturnItemList().stream().map(RetrunItemOupputDTO::mapToDTO).collect(Collectors.toList());
    }
}
