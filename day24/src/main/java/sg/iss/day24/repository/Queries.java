package sg.iss.day24.repository;

public class Queries {

    public static final String SQL_GET_ALL_ORDER = """
            SELECT * FROM orders
            """;

    public static final String SQL_POST_ORDER = """
            INSERT INTO 
                orders (order_date, customer_name, ship_address, notes, tax)
            VALUES
                (?, ?, ?, ?, ?)
            """;
}
