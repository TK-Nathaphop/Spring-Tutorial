package tkstudy.restservice.consuming;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    private String type;
    private Value value;

    public String getType(){
        return this.type;
    }

    public Value getValue(){
        return this.value;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setValue(Value value){
        this.value = value;
    }

    @Override
    public String toString(){
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
