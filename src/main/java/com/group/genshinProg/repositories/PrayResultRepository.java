package com.group.genshinProg.repositories;


import com.group.genshinProg.model.entity.PrayResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrayResultRepository extends JpaRepository<PrayResult, Long> {

    @Query(value = "SELECT count(*) FROM pray_result WHERE rang='THREE_STAR' AND date > (SELECT MAX(date) FROM pray_result WHERE rang = 'FOUR_STAR')",
            nativeQuery = true)
    int countThreeStarPrayResultsAfterLatestFourStar();

    @Query(value = "SELECT count(*) FROM pray_result WHERE rang<>'FIVE_STAR' AND date > (SELECT MAX(date) FROM pray_result WHERE rang = 'FIVE_STAR')",
            nativeQuery = true)
    int countThreeStarPrayResultsAfterLatestFiveStar();

    void deletePrayResultById(Long id);

}
