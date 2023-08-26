package com.msa.rentalcard.framework.jpaadapter;

import com.msa.rentalcard.domain.model.RentalCard;
import com.msa.rentalcard.domain.model.vo.IDName;
import com.msa.rentalcard.domain.model.vo.RentalCardNo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentalCardRepository extends JpaRepository<RentalCard, RentalCardNo> {

    @Query("select m from RentalCard m where m.member.id = :id")
    Optional<RentalCard> findByMemberId(@Param("id") String memberID);

    Optional<RentalCard> findByMember(IDName member);

    @Query("select m from  RentalCard m where  m.rentalCardId.no = :id")
    Optional<RentalCard> findById(@Param("id") Long rentalCardId);
}