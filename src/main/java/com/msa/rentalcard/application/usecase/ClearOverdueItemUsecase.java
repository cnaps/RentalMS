package com.msa.rentalcard.application.usecase;

import com.msa.rentalcard.framework.web.dto.ClearOverdueInfoDTO;
import com.msa.rentalcard.framework.web.dto.RentalResultOuputDTO;

public interface ClearOverdueItemUsecase {

    RentalResultOuputDTO clearOverdue(ClearOverdueInfoDTO clearOverdueInfoDTO) throws Exception;
}
