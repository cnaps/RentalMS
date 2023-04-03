package com.inflearn.rentalcard.infrastructure.web.dto;

import com.inflearn.rentalcard.domain.model.vo.IDName;
import com.inflearn.rentalcard.domain.model.vo.Item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalDTO {
    public Item rentItem;
    public IDName rentalUser;

}
