/**
 * Created by kpj767 on 6/13/17.
 */
package sparkexample;
import static spark.Spark.*;

public class sparkexample {
    public static void main(String[] args) {
        get("/java/square/:number", (req, res) -> {
            String number = req.params(":number");
            int num = Integer.parseInt(number);
            int square = num * num;
            String statement = "Square of " + number + " is " + Integer.toString(square);
            return statement;
        });
    }
}