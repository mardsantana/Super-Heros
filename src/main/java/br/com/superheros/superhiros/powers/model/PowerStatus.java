//package br.com.superheros.superhiros.powers.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Entity
//@Data
//public class PowerStatus {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "strength")
//    private int strength;
//
//    @Column(name = "speed")
//    private int speed;
//
//    @Column(name = "durability")
//    private int durability;
//
//    @Column(name = "power")
//    private int power;
//
//    @Column(name = "combat")
//    private int combat;
//
//    public Map<String, Double> getPowerPercentages() {
//        Map<String, Double> powerPercentages = new HashMap<>();
//        double total = getTotal();
//        powerPercentages.put("strength", (double) strength / total * 100);
//        powerPercentages.put("speed", (double) speed / total * 100);
//        powerPercentages.put("durability", (double) durability / total * 100);
//        powerPercentages.put("power", (double) power / total * 100);
//        powerPercentages.put("combat", (double) combat / total * 100);
//        return powerPercentages;
//    }
//
//    private double getTotal() {
//        return strength + speed + durability + power + combat;
//    }
//}
