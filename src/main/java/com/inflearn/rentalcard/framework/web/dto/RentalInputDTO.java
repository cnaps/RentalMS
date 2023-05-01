package com.inflearn.rentalcard.framework.web.dto;

import com.inflearn.rentalcard.domain.model.vo.IDName;
import com.inflearn.rentalcard.domain.model.vo.Item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalInputDTO {
    public String userId;
    public String userNm;
    public Integer itemId;
    public String itemTitle;
}
