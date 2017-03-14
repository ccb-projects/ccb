package org.ccb.core.service.impl;

import org.ccb.core.model.City;
import org.ccb.core.service.CityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CityServiceImpl extends GenericServiceImpl<City> implements CityService{

}
