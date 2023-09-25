package com.yugi.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MonsterDTO {
    public String name;
    public String type;
    public String frameType;
    public String desc;
    public String race;
    public String archetype;
    private String image_url;

}
