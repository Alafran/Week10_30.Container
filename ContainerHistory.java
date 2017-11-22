
package containers;

import java.util.ArrayList;
import java.util.List;

public class ContainerHistory {
    private List<Double> containerHistory;
    
    public ContainerHistory() {
        this.containerHistory = new ArrayList<Double>();
    }
    
    public void add(double situation) {
        this.containerHistory.add(situation);
    }
    
    public void reset() {
        this.containerHistory.clear();
    }
    
    @Override
    public String toString() {
        if(this.containerHistory.isEmpty()) {
            return "[]";
        }
        
        String history = "[";
        
        for(int i = 0; i < this.containerHistory.size(); i++) {
            history += this.containerHistory.get(i);
            if(i == this.containerHistory.size() - 1) {
                history += "]";
            }
            else {
                history += ", ";
            }
        }
        
        return history;
    }
    
    public double maxValue() {
        double maxValue = 0;
        
        for(double volume : this.containerHistory) {
            if(volume > maxValue) {
                maxValue = volume;
            }
        }
        
        return maxValue;
    }
    
    public double minValue() {
        if(this.containerHistory.isEmpty()) {
            return 0;
        }
        
        double minValue = this.containerHistory.get(0);
        
        for(double volume : this.containerHistory) {
            if(minValue > volume) {
                minValue = volume;
            }
        }
        
        return minValue;
    }
    
    public double average() {
        double sum = 0;
        
        for(double volume : this.containerHistory) {
            sum += volume;
        }
        
        return sum / this.containerHistory.size();
    }
    
    public double greatestFluctuation() {
        if(this.containerHistory.size() == 0 || this.containerHistory.size() == 1) {
            return 0;
        }
        
        double greatestFluctuation = 0;
        
        for(int i = 0; i < this.containerHistory.size() - 1; i++) {
            double fluctuation = Math.abs(this.containerHistory.get(i) - this.containerHistory.get(i + 1));
            if(fluctuation > greatestFluctuation) {
                greatestFluctuation = fluctuation;
            }
        }
        
        return greatestFluctuation;
    }
    
    public double variance() {
        double mean = this.average();
        double difference = 0;
        double addAllDiffs = 0;
        
        for(double volumes : this.containerHistory){
            difference = mean - volumes;
            addAllDiffs += Math.pow(difference, 2);
        }
        
        return addAllDiffs / (this.containerHistory.size() - 1);
    }
}
    