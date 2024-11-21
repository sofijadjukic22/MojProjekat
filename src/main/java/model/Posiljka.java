package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="posiljka")
public class Posiljka implements Mappable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="posiljka_id")
    private Integer posiljkaId;


    @Column(name="od_lokacija")
    private String odLokacija;

    @Column(name="do_lokacija")
    private String doLokacija;



    @Column(name="datum_pocetak")
    private Date datumPocetak;


    @Column(name="datum_kraj")
    private String datumKraj;

    @Column(name="status_posiljke")
    private String statusPosiljke;


    @Column(name="musterija")
    private String musterija;


    @Column(name="id_vozila")
    private int idVozila;

    @Column(name="tip")
    private String tip;





}
