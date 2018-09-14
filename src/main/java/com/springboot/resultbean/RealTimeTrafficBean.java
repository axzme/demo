package com.springboot.resultbean;


import com.springboot.model.AddressResult;
import com.springboot.model.EvaluationMap;
import com.springboot.model.RoadTraffic;

import java.util.List;

public class RealTimeTrafficBean {
    /**
     * {
     "status": 0,
     "message": "成功",
     "description": "东二环:自北向南较为畅通;自南向北拥堵;南向北,从光明桥到建国门桥拥堵;北向南,从东直门北桥到建国门桥拥堵。",
     "evaluation": {
     "status": 2,
     "status_desc": "自北向南较为畅通;自南向北拥堵"
     },
     "road_traffic": [{
     "congestion_sections": [
     {
     "congestion_distance": 2660,
     "speed": 15.22,
     "status": 3,
     "congection_trend": "持平",
     "section_desc": "南向北,从光明桥到建国门桥"
     },
     {
     "congestion_distance": 1890,
     "speed": 17.81,
     "status": 3,
     "congection_trend": "加重",
     "section_desc": "北向南,从东直门北桥到建国门桥"
     }],
     "road_name": "东二环"
     }]
     }
     */
    private byte status ;

    private String message;

    private String description;

    private EvaluationMap evaluation;

    private List<RoadTraffic> road_traffic;

    private List<AddressResult> results;

    public List<AddressResult> getResults() {
        return results;
    }

    public void setResults(List<AddressResult> results) {
        this.results = results;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EvaluationMap getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(EvaluationMap evaluation) {
        this.evaluation = evaluation;
    }

    public List<RoadTraffic> getRoad_traffic() {
        return road_traffic;
    }

    public void setRoad_traffic(List<RoadTraffic> road_traffic) {
        this.road_traffic = road_traffic;
    }
}
