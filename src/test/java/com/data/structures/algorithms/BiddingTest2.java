/*
package com.data.structures.algorithms;

import com.alibaba.fastjson.JSONObject;
import com.gw.ub.mall.goods.pojo.dto.mall.BiddingPayBondDtoReq;
import com.gw.ub.mall.service.BiddingServiceHandle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BiddingTest2 {

  @Autowired
  private BiddingServiceHandle biddingServiceHandle;

  @Autowired
  private RestTemplate restTemplate;

  @Test
  public void test() {
    BiddingPayBondDtoReq biddingPayBondDtoReq = new BiddingPayBondDtoReq();

    biddingPayBondDtoReq.setBiddingId(1617443060457803776L);
    biddingPayBondDtoReq.setGwAccount("gw19911110001");
    biddingPayBondDtoReq.setIsUb(false);
    biddingServiceHandle.payBond(biddingPayBondDtoReq, true);
  }


  @Test
  public void testPostUrl() throws InterruptedException {
    // 810 - 2008
    Integer[] a = {2016, 2009, 2008, 2004, 2003, 2001, 2000, 1999, 1998, 1993, 1992, 1986, 1985, 1980, 1979, 1978, 1977, 1972, 1971, 1970, 1969, 1968,
        1964, 1909, 1905, 1885, 1472, 812, 811, 810};
    // 2016,2009,2008,2004,2003,2001,2000,1999,1998,1993,1992,1986,1985,1980,1979,1978,1977,1972,1971,1970,1969,1968,1964,1909,1905,1885,1472,812,811,810
    JSONObject params = new JSONObject();
    HttpHeaders formHeader = getFormHeader("fdmGhCjHWCZ85+RUYYY0/jxA7Kc4yibCHOQaZad7OOp2f7iAiptPZhCVSBmsVldn");
    for (int i = 0; i < a.length; i++) {
      System.out.println("=====================================================" + i);
      params.put("adId", (long)a[i]);
      Thread.sleep(10000);
      HttpEntity<JSONObject> requestEntity = new HttpEntity<>(params, formHeader);
      JSONObject jsonObject = restTemplate
          .postForObject("https://usapi.wenwenlianshang.com/api/v1/group/talent/show/adReward", requestEntity, JSONObject.class);
      System.out.println("---------------------------" + JSONObject.toJSONString(jsonObject));
    }
  }


  */
/**
   * 获取表单提交头部
   *
   * @param token 联运平台验签
   * @return HttpHeaders
   *//*

  private HttpHeaders getFormHeader(String token) {
    HttpHeaders headers = new HttpHeaders();
    headers.set("wwToken", token);
    headers.setContentType(MediaType.APPLICATION_JSON);
    return headers;
  }

}
*/
