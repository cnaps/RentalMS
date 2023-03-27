package com.inflearn.rentalcard.domain.repository;

import com.inflearn.rentalcard.domain.RentalCard;
import com.inflearn.rentalcard.domain.vo.IDName;
import com.inflearn.rentalcard.domain.vo.rentalCardNo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RentalCardRepository extends JpaRepository<RentalCard, rentalCardNo> {

    @Query("select m from RentalCard m where m.member.id = :id")
    Optional<RentalCard> findByMemberId(@Param("id") String memberID);

    Optional<RentalCard> findByMember(IDName member);
}