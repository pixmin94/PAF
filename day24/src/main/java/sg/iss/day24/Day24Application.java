package sg.iss.day24;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import sg.iss.day24.model.Order;
// import sg.iss.day24.repository.OrderRepository;

@SpringBootApplication
public class Day24Application { // implements CommandLineRunner {
	// @Autowired
	// private OrderRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(Day24Application.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// 	// List<Order> result = repo.getAllOrders();
	// 	Order order = new Order(null, null, "fred", "fred address", "no fred notes", 0);
	// 	Integer result = repo.createOrder(order);
	// 	System.out.println(">>>>>>>>>>> \n");
	// 	System.out.println(result);
	// 	// for (Order o : result) {
	// 	// 	System.out.println(o.toString());
	// 	// }
	// 	System.exit(0);
	// }

}
