package com.lenged.springbootv1_5_19.controller;

import com.lenged.springbootv1_5_19.bo.EsUser;
import io.searchbox.client.JestClient;
import io.searchbox.core.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @title: ESController
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/5/7 11:49
 */

@RestController
@RequestMapping("es")
@Api(tags = "es 测试接口")
public class ESController {

    @Autowired
    private JestClient jestClient;


    @ApiOperation(value = "新增方法")
    @GetMapping("put")
    public String esPut(int i) {
            EsUser user = EsUser.builder()
                    .userId(i+10)
                    .password("456456"+i)
                    .username("sdfsf大概阿斯蒂芬"+i)
                    .build();

        Index index = new Index.Builder(user).index("school").type("user").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }



    @ApiOperation(value = "查询")
    @GetMapping("get")
    public String esGut(String index,String type,String stationId) {
        String date = "2022-04-15";
        String pointTime="2022/04/15 20:06:00";


        String json = "{\n" +
                "  \"query\": {\n" +
                "    \"bool\": {\n" +
                "      \"must\": [\n" +
                "        {\n" +
                "          \"match\": {\n" +
                "            \"stationId\": \""+stationId+"\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"match\": {\n" +
                "            \"date\": \""+date+"\" \n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"range\": {\n" +
                "            \"pointTime\": {\n" +
                "              \"gte\": \""+pointTime+"\" \n" +
                "            }\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}";
        System.out.println(json);
        Search search = new Search.Builder(json).addIndex(index).addType(type).build();
        SearchResult execute = null;
        try {
            execute = jestClient.execute(search);
            System.out.println(execute.toString());
            final List<SearchResult.Hit<EsUser, Void>> hits = execute.getHits(EsUser.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return execute.toString();
    }


}
