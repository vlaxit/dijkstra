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
    private int cost;

    public Route (City from, City to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

}
