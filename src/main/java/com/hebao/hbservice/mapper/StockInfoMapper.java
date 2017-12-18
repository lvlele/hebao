package com.hebao.hbservice.mapper;

import com.hebao.hbservice.model.StockInfo;

public interface StockInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StockInfo record);

    int insertSelective(StockInfo record);

    StockInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(StockInfo record);

    int updateByPrimaryKey(StockInfo record);
}