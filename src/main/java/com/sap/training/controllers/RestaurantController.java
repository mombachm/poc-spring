package com.sap.training.controllers;

import com.sap.training.models.Restaurant;
import com.sap.training.services.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class RestaurantController {

    @Resource
    private RestaurantService restaurantService;

    @RequestMapping(value = "/")
    public String listRestaurants(Model model) {
        List<Restaurant> restaurants = restaurantService.listRestaurants();
        model.addAttribute("restaurants", restaurants);
        return "list-restaurants";
    }

    @ResponseBody
    @RequestMapping(value = "/restaurants")
    public List<Restaurant> getRestRestaurants(Model model) {
        return restaurantService.listRestaurants();
    }

    @RequestMapping(value = "/add-restaurant")
    public String createRestaurantForm(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "form-restaurant";
    }

    @RequestMapping(value = "/add-restaurant", method = RequestMethod.POST)
    public String createRestaurant(@Valid Restaurant restaurant, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest req) {
        if (bindingResult.hasErrors()) {
            return "form-restaurant";
        }

        if (restaurant.getId() == 0) {
            restaurantService.createRestaurant(restaurant);
        }else{
            restaurantService.updateRestaurant(restaurant);
        }

        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit-restaurant")
    public String editRestaurantForm(@RequestParam("id") int id, Model model) {
        model.addAttribute("restaurant", restaurantService.getRestaurantbyId(id));
        return "form-restaurant";
    }

    @RequestMapping(value = "/remove-restaurant")
    protected String removeRestaurant(@RequestParam("id") int removeid, RedirectAttributes redirectAttributes) {
        if(removeid == 0) {
            return "list-restaurants";
        }
        restaurantService.deleteRestaurant(removeid);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/";
    }
}
