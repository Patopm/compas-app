package com.compas.app.model;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name= "me_entona")
public class MeEntona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_me_entona")
    private Long id_me_entona;

    //@Column(name ="publicaciones_id_publicacion")
    //private  Publicaciones publicacion_id;

    @ManyToMany(mappedBy = "meEntona")
    private List<Usuario> usuarios;

}

