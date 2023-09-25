package com.yugi.service;

import com.yugi.dto.MonsterDTO;
import com.yugi.response.MonsterApiResponse;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class MonsterService {

    private final String API_URL = "https://db.ygoprodeck.com/api/v7/cardinfo.php?archetype=";

    @Autowired
    private RestTemplate restTemplate;

    public List<MonsterDTO> getMonstersByArchetype(String archetypeName) {
        String apiUrl = API_URL + archetypeName;

       ResponseEntity<MonsterApiResponse> response = restTemplate.getForEntity(apiUrl, MonsterApiResponse.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            MonsterApiResponse apiResponse = response.getBody();
            if (apiResponse != null && apiResponse.getData() != null) {
                List<MonsterDTO> monsterDTOList = apiResponse.getData().stream()
                        .map(this::mapToMonsterDTO)
                        .collect(Collectors.toList());
                return monsterDTOList;
            }
        }

        return Collections.emptyList();
    }

    private MonsterDTO mapToMonsterDTO(MonsterApiResponse.MonsterData monsterData) {
        MonsterDTO monsterDTO = new MonsterDTO();
        monsterDTO.setName(monsterData.getName());
        monsterDTO.setType(monsterData.getType());
        monsterDTO.setFrameType(monsterData.getFrameType());
        monsterDTO.setDesc(monsterData.getDesc());
        monsterDTO.setRace(monsterData.getRace());
        monsterDTO.setArchetype(monsterData.getArchetype());
        monsterDTO.setImage_url(monsterData.getCard_images().get(0).getImage_url());
        return monsterDTO;
    }
}
