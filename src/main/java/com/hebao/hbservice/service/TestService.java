package com.hebao.hbservice.service;

import com.hebao.hbservice.bean.People;
import com.hebao.hbservice.model.StockInfo;

public interface TestService {

    String getRedis();

    void setRedis(People p);

    StockInfo queryMybatis(int pageNum, int pageSize);

}
