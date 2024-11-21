package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PosiljkaDTO implements Mappable{
    public int posiljkaId;
    public String odLokacija;
    public String doLokacija;
    public Date datumPocetak;
    public String datumKraj;
    public String statusPosiljke;
    public String musterija;
    public int idVozila;
    public String tip;
}
