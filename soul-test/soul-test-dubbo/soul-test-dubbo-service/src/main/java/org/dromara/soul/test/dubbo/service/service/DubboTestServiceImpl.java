/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package org.dromara.soul.test.dubbo.service.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.dromara.soul.client.common.annotation.SoulClient;
import org.dromara.soul.test.dubbo.api.entity.ComplexBeanTest;
import org.dromara.soul.test.dubbo.api.entity.DubboTest;
import org.dromara.soul.test.dubbo.api.service.DubboTestService;
import org.springframework.stereotype.Service;

/**
 * DubboTestServiceImpl.
 *
 * @author xiaoyu(Myth)
 */
@Service("dubboTestService")
public class DubboTestServiceImpl implements DubboTestService {

    @Override
    @SoulClient(path = "/findById", desc = "根据用户查询")
    public DubboTest findById(final String id) {
        DubboTest dubboTest = new DubboTest();
        dubboTest.setName("hhah");
        return dubboTest;
    }

    @Override
    @SoulClient(path = "/findAll", desc = "获取所有")
    public DubboTest findAll() {
        DubboTest dubboTest = new DubboTest();
        dubboTest.setName("findAll");
        return dubboTest;
    }

    @Override
    @SoulClient(path = "/findByLong", desc = "findByLong")
    public String findByLong(final Long id) {
        return "Long id" + id;
    }

    @Override
    @SoulClient(path = "/insert", desc = "插入一条数据")
    public DubboTest insert(final DubboTest dubboTest) {
        // 模拟阻塞
        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return dubboTest;
    }

    @Override
    @SoulClient(path = "/findByDouble", desc = "根据double类型查询")
    public String findByDouble(Double id) {
        return "Double id" + id;
    }

    @Override
    @SoulClient(path = "/queryByArray", desc = "插入一条数据")
    public String queryByArray(Integer[] ids) {
        return "param array:" + ids;
    }

    @Override
    @SoulClient(path = "/queryByStringArray", desc = "插入一条数据")
    public String queryByStringArray(String[] ids) {
        return "param string array" + ids;
    }

    @Override
    @SoulClient(path = "/queryByList", desc = "根据列表查询数据")
    public String queryByList(List<Integer> ids) {
        return "query list:" + ids;
    }

    /**
     * { "complexBeanTests": [{ "idArrays": [1, 2, 3], "idLists": [ "1", "2", "3" ], "idMaps": { "id":
     * 1, "name": 1 }* } ] }
     * 
     * @param complexBeanTests
     * @return
     */
    @Override
    @SoulClient(path = "/queryByComplexList", desc = "根据对象列表查询")
    public String queryByComplexList(List<ComplexBeanTest> complexBeanTests) {
        return "queryByComplexList" + complexBeanTests;
    }

    @Override
    @SoulClient(path = "/queryByMap", desc = "插入一条数据")
    public String queryByMap(final Map<String, String> ids) {
        return "param map values:" + ids.values();
    }

    /**
     * { "idMaps": { "idArrays": [1, 2, 3], "idLists": [ "1", "2", "3" ], "idMaps": { "id": 1, "name": 1
     * }* } }
     * 
     * @param complexBeanTestMap
     * @return
     */
    @Override
    @SoulClient(path = "/queryByComplexMap", desc = "根据对象Map查询")
    public String queryByComplexMap(Map<String, ComplexBeanTest> complexBeanTestMap) {
        return "queryByComplexMap" + complexBeanTestMap.values();
    }

    /**
     * { "idArrays": [1, 2, 3], "idLists": [ "1", "2", "3" ], "idMaps": { "id": 1, "name": 1 }* }
     * 
     * @param complexBeanTest
     * @return
     */
    @Override
    @SoulClient(path = "/insertComplexData", desc = "插入复杂数据")
    public String insertComplexData(final ComplexBeanTest complexBeanTest) {
        return "insert complex data:" + complexBeanTest;
    }
}
