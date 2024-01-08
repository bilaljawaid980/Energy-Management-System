import java.util.ArrayList;
import java.util.List;



public class Customer extends Admin {
    private String username;
    private String password;
    private double consumption;
    private double conlimit;
//    private double Min;
    private boolean alert;
    private List<Appliance> appliances;

    public Customer(String username, String password, double conlimit) {
        this.username = username;
        this.password = password;
        this.conlimit = conlimit;
        this.consumption = 0.0;
        this.alert = false;
        this.appliances = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public double getConlimit(){
    	return conlimit;
    }

    public void addAppliance(String name, double usagePerMin, double Min) {
Appliance appliance = new Appliance(name, usagePerMin, Min);
appliances.add(appliance);
// Update the consumption
consumption += (usagePerMin*Min);
// Check if consumption exceeds a certain threshold
if (consumption > conlimit) {
alert = true;
}
}
    public String[] getAppNames() {
        String[] appNames = new String[appliances.size()];
        for (int i = 0; i < appliances.size(); i++) {
            appNames[i] = appliances.get(i).getName();
        }
        return appNames;
    }

    public double getConsumption() {
        return consumption;
    }

    public boolean isAlert() {
        return alert;
    }
    
	
}
