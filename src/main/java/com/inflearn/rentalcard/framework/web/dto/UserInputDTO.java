package com.inflearn.rentalcard.framework.web.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class UserInputDTO {
    public String UserId;
    public String UserNm;
}
