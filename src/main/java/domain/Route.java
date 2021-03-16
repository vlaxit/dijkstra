package domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class Route {

    private City from;
    private City to;
    private double cost;

    public Route (City from, City to, double cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

}
