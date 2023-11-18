package com.group.genshinProg.model;

import com.group.genshinProg.model.DTO.*;
import com.group.genshinProg.model.entity.PrayResult;
import com.group.genshinProg.model.enums.RangCode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConverterDTO {


    public static PrayResult prayerDTOtoPrayResult (PrayerDTO prayerDTO) {
        String name = prayerDTO.getName();
        String rang = prayerDTO.getRang();
        return new PrayResult(name, rang);
    }

    public static List<PrayResult> threeStarDTOtoHero(ThreeStarDTO threeStarDTO) {
        int amount = threeStarDTO.getAmount();
        PrayResult prayResult = new PrayResult(null, RangCode.THREE_STAR.toString());
        List<PrayResult> list = new ArrayList<>();
        for (int i =0; i < amount; i++) {
            list.add(prayResult);
        }
        return list;
    }

    public static PrayResult prayResultDTOtoPrayResult (PrayResultDTO prayResultDTO) {
        String name = prayResultDTO.getName();
        String rang = prayResultDTO.getRang();
        return new PrayResult(name, rang);
    }


}
