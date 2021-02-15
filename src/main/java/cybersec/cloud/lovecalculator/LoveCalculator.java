package cybersec.cloud.lovecalculator;

import java.util.Optional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/lovecalculator")
@Produces(MediaType.APPLICATION_JSON)
public class LoveCalculator {
    
    private final int n;
    
    public LoveCalculator(int n) {
        this.n = n;
    }
    
    @GET
    public Response calcolaAffinità(
        @QueryParam("nome1") Optional<String> nome1,
        @QueryParam("nome2") Optional<String> nome2
    ) {
        // Se "nome1" non è specificato,
        // restituisce messaggio di errore (BAD REQUEST)
        if (!nome1.isPresent()) {
            return Response.status(Status.BAD_REQUEST)
                    .entity("Nome1 deve essere sempre specificato")
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
        // Se "nome2" non è specificato,
        // restituisce messaggio di errore (BAD REQUEST)
        if (!nome2.isPresent()) {
            return Response.status(Status.BAD_REQUEST)
                    .entity("Nome2 deve essere sempre specificato")
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
        // Calcola l'affinità tra "nome1" e "nome2" con la funzione indicata
        int numero1 = Math.abs(nome1.get().hashCode())*n;
        int numero2 = Math.abs(nome2.get().hashCode())*n;
        int aff = Math.abs((numero1 + numero2) % this.n);
        // Restituisce il risultato calcolato
        RisultatoLoveCalculator ris = new RisultatoLoveCalculator(nome1.get(),nome2.get(),aff);
        return Response.ok()
                .entity(ris)
                .build();
    }
    
}