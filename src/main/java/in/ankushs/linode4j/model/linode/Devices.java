package in.ankushs.linode4j.model.linode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import lombok.val;

/**
 *
 * Created by ankushsharma on 29/11/17.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Devices {

    @JsonProperty("sda")
    private final Sda sda;

    @JsonProperty("sdb")
    private final Sdb sdb;

    @JsonProperty("sdc")
    private final Sdc sdc;

    @JsonProperty("sdd")
    private final Sdd sdd;

    @JsonProperty("sde")
    private final Sde sde;

    @JsonProperty("sdf")
    private final Sdf sdf;

    @JsonProperty("sdg")
    private final Sdg sdg;

    @JsonProperty("sdh")
    private final Sdh sdh;

    public static Builder builder(){
        return new Builder();
    }

    private Devices(final Builder builder){
        this.sda = builder.sda;
        this.sdb = builder.sdb;
        this.sdc = builder.sdc;
        this.sdd = builder.sdd;
        this.sde = builder.sde;
        this.sdf = builder.sdf;
        this.sdg = builder.sdg;

        this.sdh = null;
    }

    //Not using Lombok's builder, but in fact creating our own builder
    //The reason is that the class Sdh cannot be modified when the Device object is used as a POJO for a POST request
    @ToString
    public static class Builder{
        private Sda sda;
        private Sdb sdb;
        private Sdc sdc;
        private Sdd sdd;
        private Sde sde;
        private Sdf sdf;
        private Sdg sdg;

        public Builder sda(final Sda sda){
            this.sda = sda;
            return this;
        }
        public Builder sdb(final Sdb sdb){
            this.sdb = sdb;
            return this;
        }

        public Builder sdc(final Sdc sdc){
            this.sdc = sdc;
            return this;
        }

        public Builder sdd(final Sdd sdd){
            this.sdd = sdd;
            return this;
        }

        public Builder sde(final Sde sde){
            this.sde = sde;
            return this;
        }

        public Builder sdf(final Sdf sdf){
            this.sdf = sdf;
            return this;
        }

        public Builder sdg(final Sdg sdg){
            this.sdg = sdg;
            return this;
        }

        public Devices build(){
            return new Devices(this);
        }
    }

    public static void main(String[] args) {
       val x =  Devices.builder()
                .sda(new Sda(1,2))
                .build();
        System.out.println(x);
    }
}
