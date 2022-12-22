package org.example.MathModule;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class MathIntegral {

    @JsonProperty("a")
    private double a;

    @JsonProperty("b")
    private double b;

    public MathIntegral(){
        a = 0;
        b = 0;
    }
    public MathIntegral(double a, double b){
        this.a = a;
        this.b = b;
    }

    public ResultIntegral getIntegral(IFunction function){
        double area = 0;
        double h = 0.001;

        for(int i = 0; i < (b-a) / h; i++){
            area += h * (0.5 * (function.func(a + i * h) + function.func(a + (i + 1) * h)));
        }

        return new ResultIntegral(area);
    }
}
