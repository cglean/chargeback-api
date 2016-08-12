package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.cloudfoundry.client.lib.domain.InstanceStats;
import org.springframework.stereotype.Service;

import com.example.service.ChargeBackService;
import com.example.vo.ChargeBackAggregrateVO;
import com.example.vo.ChargeBackUsageResponse;

/**
 * 
 * @author ambansal
 *
 */
@Service
public class ChargeBackServiceImpl implements ChargeBackService {

	final Function<ChargeBackAggregrateVO, List<ChargeBackUsageResponse>> maptoUsage 
    = new Function<ChargeBackAggregrateVO, List<ChargeBackUsageResponse>>() {
    
    public List<ChargeBackUsageResponse> apply(final ChargeBackAggregrateVO chargeBackAggregrateVO) {
       
    	final List<ChargeBackUsageResponse> backUsageResponseList =  new ArrayList<>();
    	for(InstanceStats stats: chargeBackAggregrateVO.getApplicationStats().getRecords()){
    		final ChargeBackUsageResponse chargeBackUsageResponse = new ChargeBackUsageResponse();
    		chargeBackUsageResponse.setAppname(stats.getName());
    		chargeBackUsageResponse.setCpu(stats.getUsage().getCpu());
    		chargeBackUsageResponse.setDisk(stats.getUsage().getDisk());
    		chargeBackUsageResponse.setInstanceIndex(stats.getId());
    		chargeBackUsageResponse.setMemory(stats.getUsage().getMem());
    		chargeBackUsageResponse.setTime(stats.getUsage().getTime());
    		chargeBackUsageResponse.setSpaceName(chargeBackAggregrateVO.getCloudApplication().getSpace().getName());
    		String orgName = chargeBackAggregrateVO.getSpaces().stream().filter(cloudSpace -> (cloudSpace.getName().equals(chargeBackAggregrateVO.getCloudApplication().getSpace().getName())))
    		.map(cloudSpace -> cloudSpace.getOrganization().getName()).collect(Collectors.toList()).get(0);
    		chargeBackUsageResponse.setOrgName(orgName);
    		backUsageResponseList.add(chargeBackUsageResponse);
    	}
    	
    	
        return backUsageResponseList;
    }
};
	@Override
	public List<ChargeBackUsageResponse> getChargeBackUsage(final List<ChargeBackAggregrateVO> chargeBackAggregrateVOs) {
		final List<ChargeBackUsageResponse> chargeBackUsageResponses =  new ArrayList<>();
		chargeBackAggregrateVOs.stream().map(maptoUsage).collect(Collectors.toList()).stream().flatMap(records -> records.stream()).forEach(chargeBackUsageResponses::add);
		return chargeBackUsageResponses;
	}

	
	
}
