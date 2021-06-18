package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.CharacterBDO;

@RestController
@RequestMapping("/bdo")
public class DemoController {

    @GetMapping(produces = { "application/json" })
    public CharacterBDO getCharacterBDO(String id, String name, String classname, Integer level) {
	CharacterBDO character = new CharacterBDO();
	character.setId(id);
	character.setName("Jhon");
	character.setClassname(classname);
	character.setLevel(level);
	return character;
    }

}
