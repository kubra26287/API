package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    private String name;
    private List<StatePojo> states;

    public Country() {
    }

    public Country(String name, List<StatePojo> states) {
        this.name = name;
        this.states = states;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StatePojo> getStates() {
        return states;
    }

    public void setStates(List<StatePojo> states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "CountryPojo{" +
                "name='" + name + '\'' +
                ", states=" + states +
                '}';
    }
}
