package Service;

import DAO.PosiljkaDAO;
import model.PosiljkaDTO;

public interface PosiljkaService {
    PosiljkaDTO insertPosiljka(PosiljkaDTO posiljkaDTO);
    PosiljkaDTO updatePosiljka(PosiljkaDTO posiljkaDTO);

    void deletePosiljka(int PosiljkaId);

}
