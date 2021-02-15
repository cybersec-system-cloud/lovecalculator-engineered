package cybersec.cloud.lovecalculator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RisultatoLoveCalculator {
    
    private String nome1;
    private String nome2;
    private int aff;
    
    public RisultatoLoveCalculator() {}
    
    public RisultatoLoveCalculator(String nome1, String nome2, int aff) {
        this.nome1 = nome1;
        this.nome2 = nome2;
        this.aff = aff;
    }
    
    @JsonProperty
    public String getNome1() {
        return nome1;
    }

    @JsonProperty
    public String getNome2() {
        return nome2;
    }

    @JsonProperty
    public int getAff() {
        return aff;
    }
    
}