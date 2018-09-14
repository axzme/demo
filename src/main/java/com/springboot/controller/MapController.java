package com.springboot.controller;

import com.google.gson.Gson;
import com.springboot.model.LocationLatLng;
import com.springboot.resultbean.RealTimeTrafficBean;
import com.springboot.searchBean.AddressSearchBean;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springboot/map")
public class MapController {
    //百度地图key: gL3CWXPmN2dCencYqH4tHnTafm38X915
    //获取地理位置路况
    private String ak = "gL3CWXPmN2dCencYqH4tHnTafm38X915";

    @RequestMapping(value = "location",method = RequestMethod.GET)
    public Object getLocation(AddressSearchBean addressSearchBean) {
        String url = "http://api.map.baidu.com/traffic/v1/road?road_name=" + addressSearchBean.getRoad_name() + "&city=" + addressSearchBean.getCity() + "&ak=" + ak;
        return getRequstResult(url,Object.class);
    }

    //路线规划
    @RequestMapping(value = "road",method = RequestMethod.GET)
    public Object roadPlan(AddressSearchBean addressSearchBean) {
        //按照行政区域进行检索相应地点
        String url = "http://api.map.baidu.com/place/v2/search?query=" + addressSearchBean.getQuery() + "&tag=" + addressSearchBean.getTag() + "&region=" + addressSearchBean.getRegion() + "&output=json&ak=" + ak;
        RealTimeTrafficBean result = getRequstResult(url, RealTimeTrafficBean.class);
        LocationLatLng origins = result.getResults().get(0).getLocation();
        LocationLatLng destinations = result.getResults().get(1).getLocation();
        return wayToPlace(origins,destinations);
    }

    @RequestMapping(value = "way")
    public Object wayToPlace(LocationLatLng origins,LocationLatLng destinations){
        String url = "http://api.map.baidu.com/routematrix/v2/driving?output=json&origins="+origins.getLat()+","+origins.getLng()+"&destinations="+destinations.getLat()+","+destinations.getLng()+"&ak="+ak;
        Object result = getRequstResult(url,Object.class);
        return goToPlace(origins,destinations);
    }

    @RequestMapping(value = "go")
    public Object goToPlace(LocationLatLng origins,LocationLatLng destinations){
/*
       String url =  "http://api.map.baidu.com/direction/v2/riding?origin="+getLocation(origins)+"&destination="+getLocation(destinations)+"&ak="+ak;
*/
       String url =  "http://api.map.baidu.com/direction/v2/transit?origin="+getLocation(origins)+"&destination="+getLocation(destinations)+"&ak="+ak;
       Object result = getRequstResult(url,Object.class);
        return result;
    }

    private String getLocation(LocationLatLng location){
        return location.getLat()+","+location.getLng();
    }

    private <T> T getRequstResult(String url,Class<T> obj) {
        OkHttpClient ok = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = ok.newCall(request).execute();
            String json = response.body().string();
            return new Gson().fromJson(json, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
