import com.springboot.frontend.demo.service.EmployeeCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    public void test(){
        EmployeeCalculator calculator = new EmployeeCalculator();
        Assertions.assertEquals(10, calculator.getEmployeeCount());
    }
}
