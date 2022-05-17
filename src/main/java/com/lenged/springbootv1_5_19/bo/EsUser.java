package com.lenged.springbootv1_5_19.bo;

import io.searchbox.annotations.JestId;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @title: SysUser
 * @description: TODO
 * @auther: zhangjianyun
 * @date: 2022/5/7 11:06
 */

@Data
@Builder
public class EsUser implements Serializable {

    @JestId
    private int userId;
    private String username;
    private String password;
}
