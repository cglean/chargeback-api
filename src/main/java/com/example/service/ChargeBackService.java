package com.example.service;

import java.util.List;

import com.example.entity.Usage;
import com.example.vo.ChargeBackAggregrateVO;
import com.example.vo.ChargeBackUsageResponse;

public interface ChargeBackService {

	List<ChargeBackUsageResponse> getChargeBackUsage(final List<ChargeBackAggregrateVO> chargeBackAggregrateVOs);

	void persistUsageData(Usage usage);

}
