package com.server.service;

import com.server.dto.CartItemDTO;
import com.server.entity.Cart;
import com.server.entity.CartItem;
import com.server.entity.Product;
import com.server.repository.CartDAO;
import com.server.repository.CartItemDAO;
import com.server.repository.CustomerDAO;
import com.server.repository.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired private CartDAO cartDAO;
    @Autowired private CustomerDAO customerDAO;
    @Autowired private CartItemDAO cartItemDAO;
    @Autowired private ProductDAO productDAO;

    public ResponseEntity<?> addCartItem(CartItemDTO cartItemDTO) {
        List<Cart> carts = cartDAO.findByCustomerId(cartItemDTO.getCustomerId());
        int ok = 0;
        if(carts != null && !carts.isEmpty()) {
            for(Cart cart : carts){
                if(cart.getStatus().equals("CREATE")) {
                    ok = 1;
                    int temp = 0;
                    for(CartItem cartItem : cart.getCartItems()) {
                        if(cartItem.getProduct().getId() == cartItemDTO.getProductId()) {
                            cartItem.setQuantity(cartItem.getQuantity() + 1);
                            cartItem.setAmount(cartItem.getProduct().getPrice() + cartItem.getAmount());
                            cartItemDAO.save(cartItem);
                            temp = 1;
                        }
                    }
                    if(temp == 0) {
                        CartItem cartItem = new CartItem();
                        cartItem.setQuantity(1);
                        Product product = productDAO.findById(cartItemDTO.getProductId()).get();
                        cartItem.setProduct(product);
                        cartItem.setAmount(cartItem.getQuantity() * product.getPrice());
                        cartItem.setCart(cart);
                        cartItemDAO.save(cartItem);
                        cart.getCartItems().add(cartItem);
                        cartDAO.save(cart);
                    }
                }
            }
        }

        if(ok == 0) {
            Cart cart = new Cart();
            cart.setTotalAmount(0);
            cart.setCustomer(customerDAO.findById(cartItemDTO.getCustomerId()).get());
            cart.setStatus("CREATE");
            CartItem cartItem = new CartItem();
            cartItem.setQuantity(1);
            Product product = productDAO.findById(cartItemDTO.getProductId()).get();
            cartItem.setProduct(product);
            cartItem.setAmount(cartItem.getQuantity() * product.getPrice());

            List<CartItem> list = new ArrayList<>();
            list.add(cartItem);
            cart.setCartItems(list);
            Cart c = cartDAO.save(cart);
            cartItem.setCart(c);
            System.out.println(cartItem);
            cartItemDAO.save(cartItem);
        }
        return ResponseEntity.ok("Đã thêm vào giỏ hàng");
    }
}
