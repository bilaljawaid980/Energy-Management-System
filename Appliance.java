public class Appliance {
    private String name;
    private double usagePerMin;
    private double Min;

    public Appliance(String name, double usagePerMin, double Min) {
        this.name = name;
        this.usagePerMin = usagePerMin;
        this.Min=Min;
 
    }

    public String getName() {
        return name;
    }

    public double getUsagePerMin() {
        return usagePerMin;
    }
    public double Min() {
        return Min;
    }
    
}