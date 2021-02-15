package cybersec.cloud.lovecalculator;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class LoveCalculatorConfig extends Configuration {
    
    private int n;
    
    @JsonProperty
    public int getN() {
        return n;
    }
    
}