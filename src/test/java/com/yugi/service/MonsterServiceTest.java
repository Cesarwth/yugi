package com.yugi.service;

import com.yugi.dto.MonsterDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ComponentScan(basePackages = "com.yugi")
public class MonsterServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @Autowired
    private MonsterService monsterService;

    @Test
    public void testGetMonstersByArchetypeSuccessfully() {
        String archetypeName = "Blue-Eyes";

        List<MonsterDTO> result = monsterService.getMonstersByArchetype(archetypeName);

        MonsterDTO monsterDTO = result.get(0);
        assertEquals("Blue-Eyes", monsterDTO.getArchetype());
        assertNotNull(monsterDTO.getImage_url());
    }

}
