package com.hebao.hbservice.service.impl;

import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.hebao.hbservice.bean.People;
import com.hebao.hbservice.mapper.StockInfoMapper;
import com.hebao.hbservice.model.StockInfo;
import com.hebao.hbservice.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestServiceImpl implements TestService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StockInfoMapper stockInfoMapper;

    @Override
    public String getRedis() {
        String str = redisTemplate.opsForValue().get("a");
        Gson gson = new Gson();
        People p = new People();
        if (null != str) {
            p = gson.fromJson(str, People.class);
        }
        return p.getName();
    }

    @Override
    public void setRedis(People p) {
        Gson gson = new Gson();
        redisTemplate.opsForValue().set("a", gson.toJson(p));
    }

    @Override
    public StockInfo queryMybatis(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return stockInfoMapper.selectByPrimaryKey(2);
    }
}
