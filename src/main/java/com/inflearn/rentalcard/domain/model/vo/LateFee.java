package com.inflearn.rentalcard.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Getter
public class LateFee {
    private Integer point;

    public Integer addPoint(Integer lateFee)
    {
        this.point = this.point + lateFee;
        return point;
    }

    public Integer removePoint(Integer lateFee) throws Exception {
        if (lateFee > this.point) {
            throw new Exception("기존 가진 point보다 작어 삭제할 수 없습니다.");
        }
        this.point = this.point - lateFee;
        return point;
    }
    public static LateFee sample(){
        return new LateFee(0);
    }

    public static LateFee createLateFee()
    {
        LateFee lateFee = new LateFee();
        lateFee.point = 0;
        return lateFee;
    }
}
