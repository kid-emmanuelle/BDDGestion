package com.fisa.bddgestion.service;

import com.fisa.bddgestion.exception.EntityNotFoundException;
import com.fisa.bddgestion.model.Commande;
import com.fisa.bddgestion.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public List<Commande> getAllCommande() {
        return commandeRepository.findAll();
    }

    public Commande getCommandeById(String id) {
        return commandeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Commande non trouvée"));
    }

    public Commande creerGroupe(Commande commande) {
        if (commande.getId() == null || commande.getId().isEmpty()) {
            throw new IllegalArgumentException("Le numéro de groupe est obligatoire");
        }
        return commandeRepository.save(commande);
    }

    public List<Commande> getCommandeByDate(String start, String end) {
        ZonedDateTime zonedDateTimeStart = ZonedDateTime.parse(start, DateTimeFormatter.ISO_DATE_TIME);
        Date dateStart = Date.from(zonedDateTimeStart.toInstant());
        ZonedDateTime zonedDateTimeEnd = ZonedDateTime.parse(end, DateTimeFormatter.ISO_DATE_TIME);
        Date dateEnd = Date.from(zonedDateTimeEnd.toInstant());

        if (dateEnd.before(dateStart)) {
            throw new IllegalArgumentException("Le date de début ne peut pas être après la date de fin");
        }

        return this.commandeRepository.findByDateCommandeBetween(dateStart, dateEnd);
    }

    public List<Commande> getCommandeByClientId(String clientid, String idVendeur, Double price) {
        if (idVendeur == null && price == null) {
            return commandeRepository.findAllByIdClient(clientid);
        }
        return commandeRepository.findAllByIdClientAndIdVendeurOrPrixTotal(clientid, idVendeur, price);
    }

    public List<Commande> getCommandeByVendeurId(String vendeurid, String clientid, Double price) {
        if (clientid == null && price == null) {
            return commandeRepository.findAllByIdVendeur(vendeurid);
        }
        return commandeRepository.findAllByIdVendeurAndIdClientOrPrixTotal(vendeurid, clientid, price);
    }

    public int getAmount(String vendeurid) {
        return commandeRepository.findAllByIdVendeur(vendeurid).size();
                /*this.getCommandeByClientId(vendeurid,null,null).stream()
                .map(Commande::getPrixTotal)
                .filter(Objects::nonNull)
                .reduce(0.0, Double::sum);*/
    }

    public Double getTotalPrice(String vendeurid) {
        return commandeRepository.findAllByIdVendeur(vendeurid).stream()
                .map(Commande::getPrixTotal)
                .filter(Objects::nonNull)
                .reduce(0.0, Double::sum);
    }
}
