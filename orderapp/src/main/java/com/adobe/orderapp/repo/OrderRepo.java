package com.adobe.orderapp.repo;

import com.adobe.orderapp.dto.OrderReport;
import com.adobe.orderapp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {
//    @Query("select orderDate, total from Order")
//    List<Object[]> getReport();

    //@Query(value = "select * from orders o inner  join on customers c where o.customer_fk = c.email", nativeQuery = true)
    @Query("select new com.adobe.orderapp.dto.OrderReport(c.firstName, o.orderDate, o.total) from Order o join o.customer c")
    List<OrderReport> getReport();

    @Query("from Order o where DATE(o.orderDate) = DATE(:date)")
    List<Order> getReportByDate(@Param("date") LocalDate date);
}
