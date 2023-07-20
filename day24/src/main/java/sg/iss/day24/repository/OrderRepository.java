package sg.iss.day24.repository;

import static sg.iss.day24.repository.Queries.*;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.iss.day24.model.Order;

@Repository
public class OrderRepository {
    @Autowired
    private JdbcTemplate template;

    public List<Order> getAllOrders() {
        final List<Order> orderList = new LinkedList<>();
        final SqlRowSet rs = template.queryForRowSet(SQL_GET_ALL_ORDER);

        while(rs.next()) {
            Order order = new Order();
            order.setCustomerName(rs.getString("customer_name"));
            order.setShipAddress(rs.getString("ship_address"));
            order.setNotes(rs.getString("notes"));

            orderList.add(order);
        }

        return orderList;
    }

    public Integer createOrder(Order order) {
        KeyHolder generatedKey = new GeneratedKeyHolder();

        PreparedStatementCreator psc = new PreparedStatementCreator() {
            
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(SQL_POST_ORDER, new String[] {"order_id"});
                long ms = System.currentTimeMillis();  

                ps.setDate(1, new Date(ms));
                ps.setString(2, order.getCustomerName());
                ps.setString(3, order.getShipAddress());
                ps.setString(4, order.getNotes());
                ps.setFloat(5, 0.05f);
                return ps;
            }

        };

        template.update(psc, generatedKey);

        Integer createdOrderID = generatedKey.getKey().intValue();
        return createdOrderID;

    }
    
}
