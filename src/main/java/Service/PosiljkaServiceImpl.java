package Service;

import DAO.PosiljkaDAO;
import helpers.Mapping;
import model.Posiljka;
import model.PosiljkaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class PosiljkaServiceImpl implements PosiljkaService{

    @Autowired
    private PosiljkaDAO posiljkaDAO;


    @Override
    public PosiljkaDTO insertPosiljka(PosiljkaDTO posiljkaDTO) {
        try{
            Posiljka p= Posiljka.builder()
                    .posiljkaId(posiljkaDTO.getPosiljkaId())
                    .odLokacija(posiljkaDTO.getOdLokacija())
                    .doLokacija(posiljkaDTO.getDoLokacija())
                    .datumPocetak(posiljkaDTO.getDatumPocetak())
                    .datumKraj(posiljkaDTO.getDatumKraj())
                    .statusPosiljke(posiljkaDTO.getStatusPosiljke())
                    .musterija(posiljkaDTO.getMusterija())
                    .idVozila(posiljkaDTO.getIdVozila())
                    .tip(posiljkaDTO.getTip())
                    .build();
            posiljkaDAO.save(p);
            PosiljkaDTO save= Mapping.mapObject(p, PosiljkaDTO.class);
            return save;


        } catch (Exception e){
            throw new RuntimeException("Error when inserting");
        }
    }

    @Override
    public PosiljkaDTO updatePosiljka(PosiljkaDTO posiljkaDTO) {

        Posiljka existing = posiljkaDAO.findById(posiljkaDTO.getPosiljkaId())
                .orElseThrow(() -> new RuntimeException("Posiljka not found for update"));

        try{
            Posiljka nova= Posiljka.builder()
                    .posiljkaId(posiljkaDTO.getPosiljkaId())
                    .odLokacija(posiljkaDTO.getOdLokacija())
                    .doLokacija(posiljkaDTO.getDoLokacija())
                    .datumPocetak(posiljkaDTO.getDatumPocetak())
                    .datumKraj(posiljkaDTO.getDatumKraj())
                    .statusPosiljke(posiljkaDTO.getStatusPosiljke())
                    .musterija(posiljkaDTO.getMusterija())
                    .idVozila(posiljkaDTO.getIdVozila())
                    .tip(posiljkaDTO.getTip())
                    .build();
            posiljkaDAO.save(nova);
            PosiljkaDTO save= Mapping.mapObject(nova, PosiljkaDTO.class);
            return save;


        } catch (Exception e){
            throw new RuntimeException("Error when updating");
        }

    }

    @Override
    public void deletePosiljka(int PosiljkaId) {

        try{
            Posiljka fetched=posiljkaDAO.getReferenceById(PosiljkaId);
            posiljkaDAO.delete(fetched);
        } catch (Exception e){
            throw new RuntimeException("Error when deleting");
        }

    }
}
