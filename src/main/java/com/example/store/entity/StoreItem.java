package com.example.store.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class StoreItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank private String name;
    private String info;
    @NotNull private Double price;
    private String type;
    @NotNull private Integer count;
}
