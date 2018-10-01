package com.example.nam.donationmanager.ShimmerRecyclerView;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;

import com.example.nam.donationmanager.R;

import java.util.Arrays;
import java.util.List;

public class BaseUtils {

    private static List<ItemCard> getListCards(Resources resources) {
        ItemCard unicefCard = createItemCard(resources, R.string.unicef_titletext, R.string.unicef_subtext);

        ItemCard neiborsCard = createItemCard(resources, R.string.neibors_titletext, R.string.neibors_subtext);

        ItemCard visionCard = createItemCard(resources, R.string.vision_titletext, R.string.vision_subtext);

        ItemCard crossCard = createItemCard(resources, R.string.cross_titletext, R.string.cross_subtext);

        ItemCard umbrellaCard = createItemCard(resources, R.string.umbrella_titletext, R.string.umbrella_subtext);

        return Arrays.asList(unicefCard, neiborsCard, visionCard, crossCard, umbrellaCard);
    }

    public static List<ItemCard> getCards(Resources resources) {
        List<ItemCard> itemCards;
        itemCards = getListCards(resources);
        return itemCards;
    }

    public static DemoConfiguration getDemoConfiguration(Context context) {
        DemoConfiguration demoConfiguration;
            demoConfiguration = new DemoConfiguration();
            demoConfiguration.setLayoutResource(R.layout.group_list);
            demoConfiguration.setLayoutManager(new LinearLayoutManager(context));
            demoConfiguration.setItemDecoration(new CardPaddingItemDecoration(context));
        return demoConfiguration;
    }

    private static ItemCard createItemCard(Resources resources, @StringRes int title, @StringRes int description) {
        ItemCard itemCard = new ItemCard();

        itemCard.setTitle(resources.getString(title));
        itemCard.setDescription(resources.getString(description));

        return itemCard;
    }
}
