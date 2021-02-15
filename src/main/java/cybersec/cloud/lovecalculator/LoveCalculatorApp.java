package cybersec.cloud.lovecalculator;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class LoveCalculatorApp extends Application<LoveCalculatorConfig> {
    
    public static void main(String[] args) throws Exception {
        new LoveCalculatorApp().run(args);
    }
    
    @Override
    public void run(LoveCalculatorConfig configuration, Environment environment) {
        final LoveCalculator risorsaLoveCalculator  = new LoveCalculator(
                configuration.getN()
        );
        
        environment.jersey().register(risorsaLoveCalculator);
    }
    
}