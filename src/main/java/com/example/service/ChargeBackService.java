package com.example.service;

import java.util.List;

import org.cloudfoundry.client.lib.domain.CloudSpace;

import com.example.vo.ChargeBackAggregrateVO;
import com.example.vo.ChargeBackUsageResponse;

public interface ChargeBackService {

	List<ChargeBackUsageResponse> getChargeBackUsage(final List<ChargeBackAggregrateVO> chargeBackAggregrateVOs);



}
