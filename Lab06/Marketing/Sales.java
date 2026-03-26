package Marketing;

import General.Employee;

public class Sales extends Employee {

    public Sales(int id, String name, double basic) {
        super(id, name, basic);
    }

    public double tallowance() {
        return 0.05 * earnings(); // calculated, not added to total earning
    }
}
