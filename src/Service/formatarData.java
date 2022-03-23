
package Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class formatarData {

    public String formatarDataERetornar(String dataParaFormatar) throws ParseException {
        Date dt = new SimpleDateFormat("yyyyMMdd").parse(dataParaFormatar);
        String dataFormatada = new SimpleDateFormat("dd-MM-yyyy").format(dt);
        return dataFormatada;
    }
    
    
    
}
