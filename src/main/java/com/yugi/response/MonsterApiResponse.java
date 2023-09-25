package com.yugi.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MonsterApiResponse {
    private List<MonsterData> data;

    @Getter
    @Setter
    public static class MonsterData {
        private int id;
        private String name;
        private String type;
        private String frameType;
        private String desc;
        private String race;
        private String archetype;
        private List<CardSet> card_sets;
        private List<CardImage> card_images;
        private List<CardPrice> card_prices;
    }

    @Getter
    @Setter
    public static class CardSet {
        private String set_name;
        private String set_code;
        private String set_rarity;
        private String set_rarity_code;
        private String set_price;
    }

    @Getter
    @Setter
    public static class CardImage {
        private int id;
        private String image_url;
        private String image_url_small;
        private String image_url_cropped;
    }

    @Getter
    @Setter
    public static class CardPrice {
        private String cardmarket_price;
        private String tcgplayer_price;
        private String ebay_price;
        private String amazon_price;
        private String coolstuffinc_price;
    }
}