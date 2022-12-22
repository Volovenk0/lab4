package org.example.MathModule;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ResultIntegral {
    @JsonProperty("result")
    private double result;

    public ResultIntegral(){
        result = 0;
    }
    public ResultIntegral(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }
}
