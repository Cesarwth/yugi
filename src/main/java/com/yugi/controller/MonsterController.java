package com.yugi.controller;

import com.yugi.dto.MonsterDTO;
import com.yugi.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monsters")
public class MonsterController {

    @Autowired
    private MonsterService monsterService;

    @GetMapping("/{archetypeName}")
    public ResponseEntity<List<MonsterDTO>> getMonstersByArchetype(@PathVariable String archetypeName) {
        List<MonsterDTO> monsters = monsterService.getMonstersByArchetype(archetypeName);
        return ResponseEntity.ok(monsters);
    }
}
