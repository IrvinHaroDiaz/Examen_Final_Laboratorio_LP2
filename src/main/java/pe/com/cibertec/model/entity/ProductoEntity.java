package pe.com.cibertec.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productoId;
    
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
    @Column(name = "stock", nullable = false)
    private Integer stock;
    
    @Column(name = "precio", nullable = false)
    private Double precio;
    
    @Column(name = "url_imagen", nullable = false)
    private String urlImagen;

}
