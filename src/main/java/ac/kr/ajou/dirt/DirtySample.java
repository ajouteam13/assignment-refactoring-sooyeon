package ac.kr.ajou.dirt;

class DirtySample {
    Item[] items;

    public DirtySample(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!equals_Name(items[i], "Aged Brie") && !equals_Name(items[i],"Backstage passes to a TAFKAL80ETC concert")) {
                if (quality_more_than_0(items[i])) {
                    if (!equals_Name(items[i],"Sulfuras, Hand of Ragnaros")) {
                        quality_decrease(items[i]);
                        sellin_decrease(items[i]);
                    }
                }
            }
            else {
                if (quality_less_than_50(items[i])) {
                    quality_increase(i); //age
                    if (equals_Name(items[i],"Backstage passes to a TAFKAL80ETC concert")){ //back
                        if (sellin_less_than(items[i].sellIn, 11)) {
                                quality_increase(i);
                        }
                        if (sellin_less_than(items[i].sellIn, 6)) {
                                quality_increase(i);
                        }
                    }
                }
            }

            if (sellin_less_than(items[i].sellIn, 0)) {
                if (!equals_Name(items[i], "Aged Brie")) {
                    if (!equals_Name(items[i],"Backstage passes to a TAFKAL80ETC concert")) {
                        if (quality_more_than_0(items[i])) {
                            if (!equals_Name(items[i],"Sulfuras, Hand of Ragnaros")) {
                                quality_decrease(items[i]);
                                sellin_decrease(items[i]);
                            }
                        }
                    }
                    else { //back
                        items[i].quality = 0;
                    }
                }
                else { //age
                    if (quality_less_than_50(items[i])) {
                        quality_increase(i);
                    }
                }
            }
        }
    }

    private boolean sellin_less_than(int sellIn, int compare) {
        return sellIn < compare;
    }

    private boolean quality_more_than_0(Item item) {
        return item.quality > 0;
    }

    private boolean quality_less_than_50(Item item) {
        return item.quality < 50;
    }

    private void sellin_decrease(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void quality_decrease(Item item) {
        item.quality = item.quality - 1;
    }

    private void quality_increase(int i) {
        items[i].quality = items[i].quality + 1;
    }

    private boolean equals_Name(Item item, String name) {
        return item.name.equals(name);
    }

}