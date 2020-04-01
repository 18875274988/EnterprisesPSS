package com.puyin.cn.BO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/31
 **/
@Data
@NoArgsConstructor
public class TemporaryProduBo {
    List<TemporaryProduct> productList;
    String name;
}
