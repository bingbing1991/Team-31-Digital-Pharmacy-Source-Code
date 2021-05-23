package com.example.digital_pharmacy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.digital_pharmacy.DTO.OrderProductDto;
//import com.example.digital_pharmacy.model.Order;
//import com.example.digital_pharmacy.service.OrderProductService;
//import com.example.digital_pharmacy.service.OrderService;
//import com.example.digital_pharmacy.service.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.digital_pharmacy.DTO.OrderProductDto;
import com.example.digital_pharmacy.model.Order;
import com.example.digital_pharmacy.model.OrderProduct;
import com.example.digital_pharmacy.model.OrderStatus;
import com.example.digital_pharmacy.service.OrderProductService;
import com.example.digital_pharmacy.service.OrderService;
import com.example.digital_pharmacy.service.ProductService;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController
{
//	@Autowired
//	private OrderService orderService;
//	
//	@PostMapping("/createOrder")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public Order createOrder(@RequestBody Order order) throws Exception
//	{
//		Order returnOrder = new Order();
//		returnOrder = orderService.saveOrder(order);
//		return returnOrder;
//	}
//		
//	@GetMapping("/getAllOrders")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public List<Order> getAllOrder(@RequestBody int prescriptionId) throws Exception
//	{
//		List<Order> OrderList = new ArrayList<Order>();
//		OrderList = orderService.findAllByPrescriptionId(prescriptionId);
//		return OrderList;
//	}
	@Autowired
	ProductService productService;
	
	@Autowired
    OrderService orderService;
	
	@Autowired
    OrderProductService orderProductService;

    public OrderController(ProductService productService, OrderService orderService, OrderProductService orderProductService) {
        this.productService = productService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:4200")
    public @NotNull Iterable<Order> list() {
        return this.orderService.getAllOrders();
    }

    @PostMapping
//    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Order> create(@RequestBody OrderForm form) {
        List<OrderProductDto> formDtos = form.getProductOrders();
        validateProductsExistence(formDtos);
        Order order = new Order();
        order.setStatus(OrderStatus.PAID.name());
        order = this.orderService.create(order);

        List<OrderProduct> orderProducts = new ArrayList<>();
        for (OrderProductDto dto : formDtos) {
            orderProducts.add(orderProductService.create(new OrderProduct(order, productService.getProduct(dto
              .getProduct()
              .getId()), dto.getQuantity())));
        }

        order.setOrderProducts(orderProducts);

        this.orderService.update(order);

        String uri = ServletUriComponentsBuilder
          .fromCurrentServletMapping()
          .path("/orders/{id}")
          .buildAndExpand(order.getId())
          .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }

    private void validateProductsExistence(List<OrderProductDto> orderProducts) {
        List<OrderProductDto> list = orderProducts
          .stream()
          .filter(op -> Objects.isNull(productService.getProduct(op
            .getProduct()
            .getId())))
          .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(list)) {
            new ResourceNotFoundException("Product not found");
        }
    }

    public static class OrderForm {

        private List<OrderProductDto> productOrders;

        public List<OrderProductDto> getProductOrders() {
            return productOrders;
        }

        public void setProductOrders(List<OrderProductDto> productOrders) {
            this.productOrders = productOrders;
        }
    }
}
