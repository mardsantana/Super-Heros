package br.com.superheros.superhiros.repository;

import br.com.superheros.superhiros.model.HerosModel;

import java.util.List;
import java.util.UUID;

public interface HerosRepository {
    HerosModel save(HerosModel herosModel);
    HerosModel getHerosById(UUID idHeros);
    List<HerosModel> getAll();
}
