package com.sriram.warehouse_management.Controller;

import com.sriram.warehouse_management.Model.Item;
import com.sriram.warehouse_management.Service.ItemService;
import com.sriram.warehouse_management.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ItemController {

    private final ItemService itemService;
    private final UserService userService;

    @Autowired
    public ItemController(ItemService itemService, UserService userService) {
        this.itemService = itemService;
        this.userService = userService;
        System.out.println("Services Injected: " + itemService + "|||||||||||||| " + userService);
    }

    @GetMapping("/login")
    public String login() {
        return "home";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
        System.out.println("Attempting login: username=" + username + " password=" + password);
        if (userService.authenticate(username, password)) {
            return "redirect:/home";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid username or password.");
            return "redirect:/login";
        }
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "home";
    }


    @GetMapping("items/add")
    public String showAddItemForm() {
        return "add-item";
    }

    @PostMapping("items/add-item")
    public String addItem(@RequestParam Long id, @RequestParam String name, @RequestParam String type, @RequestParam int quantity) {
        Item item = new Item(id, name, type, quantity);
        itemService.addItem(item);
        return "redirect:/home";
    }

    @GetMapping("items/update")
    public String showUpdateItemForm(@RequestParam Long id, Model model) {
        model.addAttribute("item", itemService.getItemById(id).orElseThrow(() -> new RuntimeException("Item not found")));
        return "update-item";
    }

    @PostMapping("items/update-item")
    public String updateItem(@RequestParam Long id, @RequestParam String type, @RequestParam int quantity) {
        Item item = itemService.getItemById(id).orElseThrow(() -> new RuntimeException("Item not found"));
        item.setType(type);
        item.setQuantity(quantity);
        itemService.updateItem(item);
        return "redirect:/home";
    }

    @GetMapping("items/delete")
    public String showDeleteItemForm() {
        return "delete-item";
    }

    @PostMapping("items/delete-item")
    public String deleteItem(@RequestParam(required = false) Long id, @RequestParam(required = false) String name) {
        if (id != null) {
            itemService.deleteItem(id);
        } else if (name != null) {
            itemService.getAllItems().stream()
                    .filter(item -> item.getName().equals(name))
                    .findFirst()
                    .ifPresent(item -> itemService.deleteItem(item.getId()));
        }
        return "redirect:/home";
    }
}
