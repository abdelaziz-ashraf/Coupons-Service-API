package com.miniFawry.couponAPI.mapper;


import com.miniFawry.couponAPI.entity.ConsumptionHistory;
import com.miniFawry.couponAPI.model.ConsumptionHistoryModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface ConsumptionHistoryMapper {
    ConsumptionHistory toEntity(ConsumptionHistoryModel couponModel);
    ConsumptionHistoryModel toModel(ConsumptionHistory consumptionHistory);

    List<ConsumptionHistoryModel> toModelList(List<ConsumptionHistory> consumptionHistories);
}
