package br.com.superheros.superhiros.heros.repository;

import br.com.superheros.superhiros.heros.model.HerosModel;

import java.util.List;
import java.util.UUID;

public interface HerosRepository {
    HerosModel save(HerosModel herosModel);
    HerosModel getHerosById(UUID idHeros);
    List<HerosModel> getAll();
    void deleteHero(HerosModel herosModel);
}
