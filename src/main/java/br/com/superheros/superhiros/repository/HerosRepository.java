package br.com.superheros.superhiros.repository;

import br.com.superheros.superhiros.model.HerosModel;

public interface HerosRepository {
    HerosModel save(HerosModel herosModel);
}
