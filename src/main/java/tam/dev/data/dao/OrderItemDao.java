package tam.dev.data.dao;

import tam.dev.data.model.OrderItem;

import java.util.List;

public interface OrderItemDao {

    public boolean insert(OrderItem orderItem);

    public boolean update(OrderItem orderItem);

    public boolean delete(int id);

    public OrderItem find(int id);

    public List<OrderItem> findAll();

    public List<OrderItem> findByOder(int id);

    public List<OrderItem> findByProduct(int id);

}
