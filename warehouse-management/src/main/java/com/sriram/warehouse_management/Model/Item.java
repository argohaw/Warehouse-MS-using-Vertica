package com.sriram.warehouse_management.Model;

//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//
//public class Item
//{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String type;
//    private int quantity;
//
//    public Item(Long id, String name, String type, int quantity)
//    {
//        this.id = id;
//        this.name = name;
//        this.type = type;
//        this.quantity = quantity;
//    }
//
//    public Long getId()
//    {
//        return id;
//    }
//
//    public void setId(Long id)
//    {
//        this.id = id;
//    }
//
//    public String getType()
//    {
//        return type;
//    }
//
//    public void setType(String type)
//    {
//        this.type = type;
//    }
//
//    public String getName()
//    {
//        return name;
//    }
//
//    public void setName(String name)
//    {
//        this.name = name;
//    }
//
//    public int getQuantity()
//    {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity)
//    {
//        this.quantity = quantity;
//    }
//
//    @Override
//    public String toString()
//    {
//        return "Item{" + "id=" + id + ", name='" + name + '\'' + ", type='" + type + '\'' + ", quantity=" + quantity + '}';
//    }
//}

public class Item {
    private Long id;
    private String name;
    private String type;
    private int quantity;

    // Default constructor
    public Item() {
    }

    // Parameterized constructor
    public Item(Long id, String name, String type, int quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and Setter for quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}