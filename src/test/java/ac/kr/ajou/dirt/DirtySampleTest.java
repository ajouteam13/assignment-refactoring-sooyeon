package ac.kr.ajou.dirt;

import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DirtySampleTest {

    @Test
    public void 이름이_aged나_back이_아니며_quality가_0이상이고_이름이_설이_아닌경우_quality_감소_테스트()
    {
        Item[] items = new Item[1];
        items[0]= new Item("wow",1,3);

        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(dirtySample.items[0].quality,is(2));
        assertThat(dirtySample.items[0].sellIn,is(0));

    }

    @Test
    public void 이름이_aged나_back이며_quality가_50이하인_경우_quality_증가_테스트()
    {
        Item[] items = new Item[1];
        items[0]= new Item("Aged Brie",1,3);

        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(dirtySample.items[0].quality,is(4));
    }

    @Test
    public void quality가_50이하이고_이름이_back이며_sellin이_0이상_6이하인_경우_quality_증가_테스트()
    {
        Item[] items = new Item[1];
        items[0]= new Item("Backstage passes to a TAFKAL80ETC concert",1,3);

        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(dirtySample.items[0].quality,is(6));

    }
    @Test
    public void 이름이_sul이_아니면_sellin_감소_테스트()
    {
        Item[] items = new Item[1];
        items[0]= new Item("wow",1,3);

        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(dirtySample.items[0].sellIn,is(0));
    }

    @Test
    public void sellin이_0이하이고_이름이_age와_back이_아니며_quality가_0이상이고_이름이_sul이아니면_quality_감소_테스트()
    {
        Item[] items = new Item[1];
        items[0]= new Item("wow",-1,3);

        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(dirtySample.items[0].quality,is(1));
    }

    @Test
    public void sellin이_0이하이고_이름이_back이면_quality가_0_테스트()
    {
        Item[] items = new Item[1];
        items[0]= new Item("Backstage passes to a TAFKAL80ETC concert",-1,3);

        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(dirtySample.items[0].quality,is(0));
    }

    @Test
    public void sellin이_0이하이고_이름이_age이며_quality가_50이하이면_quality_증가_테스트()
    {
        Item[] items = new Item[1];
        items[0]= new Item("Aged Brie",-1,3);

        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(dirtySample.items[0].quality,is(5));
    }


}
