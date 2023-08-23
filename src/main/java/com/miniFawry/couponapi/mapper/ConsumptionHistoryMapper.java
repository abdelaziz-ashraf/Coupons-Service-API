package com.miniFawry.couponapi.mapper;


import com.miniFawry.couponapi.entity.ConsumptionHistory;
import com.miniFawry.couponapi.model.ConsumptionHistoryModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface ConsumptionHistoryMapper {
    ConsumptionHistory toEntity(ConsumptionHistoryModel couponModel);
    ConsumptionHistoryModel toModel(ConsumptionHistory consumptionHistory);

    List<ConsumptionHistoryModel> toModelList(List<ConsumptionHistory> consumptionHistories);
}
