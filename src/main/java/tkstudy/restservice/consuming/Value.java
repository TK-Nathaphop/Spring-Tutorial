package tkstudy.restservice.consuming;

public class Value {
    private Long id;
    private String quote;

    public Long getId(){
        return this.id;
    }

    public String getQuote(){
        return this.quote;
    }
    public void setId(Long id){
        this.id = id;
    }

    public void setQuote(String quote){
        this.quote = quote;
    }

    @Override
    public String toString(){
        return "Value{" +
                "id=" + this.id +
                ", quote='" + this.quote + '\'' +
                '}';
    }
}
