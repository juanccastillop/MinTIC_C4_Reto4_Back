package co.edu.usa.lasartenreto4.reto4_lasarten.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.lasartenreto4.reto4_lasarten.models.Order;
import co.edu.usa.lasartenreto4.reto4_lasarten.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    public Order create(Order order) {

        // obtiene el maximo id existente en la coleccion
        Optional<Order> orderIdMaxima = orderRepository.lastUserId();

        // si el id de la orden que se recibe como parametro es nulo, entonces valida el
        // maximo id existente en base de datos
        if (order.getId() == null) {
            // valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (!orderIdMaxima.isPresent())
                order.setId(1);
            // si retorna informacion suma 1 al maximo id existente y lo asigna como el
            // codigo de la orden
            else
                order.setId(orderIdMaxima.get().getId() + 1);
        }

        Optional<Order> e = orderRepository.getOrder(order.getId());
        if (e.isEmpty()) {
            return orderRepository.create(order);        
        } else {
            return order;
        }     
    }

    public Order update(Order order){
        if (order.getId() != null){
            Optional<Order> dbOrder = orderRepository.getOrder(order.getId());
            if (!dbOrder.isEmpty()){
                if (order.getId() != null){
                    dbOrder.get().setId(order.getId());
                }

                if (order.getRegisterDay() != null){
                    dbOrder.get().setRegisterDay(order.getRegisterDay());
                }

                if (order.getStatus() != null){
                    dbOrder.get().setStatus(order.getStatus());
                }

                if (order.getSalesMan() != null){
                    dbOrder.get().setSalesMan(order.getSalesMan());
                }

                if (order.getProducts() != null){
                    dbOrder.get().setProducts(order.getProducts());
                }

                if (order.getQuantities() != null){
                    dbOrder.get().setQuantities(order.getQuantities());
                }
                orderRepository.update(dbOrder.get());
                return dbOrder.get();
            } else {
                return order;
            }
        }
        return order;
    }


    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    // Ordenes de pedido asociadas a los asesores de una zona
    public List<Order> findByZone(String zona) {
        return orderRepository.findByZone(zona);
    }

    public List<Order> getOrderBySalesManId(int id){
        return orderRepository.getOrderBySalesManId(id);
    }

    public List<Order> getOrderBySalesManIdAndStatus(int id, String status){
        return orderRepository.getOrderBySalesManIdAndStatus(id, status);
    }

    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        return orderRepository.getByRegisterDayAndSalesManId(registerDay, id);
    }
}
