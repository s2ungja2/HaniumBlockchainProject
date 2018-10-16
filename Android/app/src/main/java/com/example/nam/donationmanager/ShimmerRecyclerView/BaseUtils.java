package com.example.nam.donationmanager.ShimmerRecyclerView;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;

import com.example.nam.donationmanager.R;

import java.util.Arrays;
import java.util.List;

public class BaseUtils {

    private static List<ItemCard> getListCards(Resources resources) {
        ItemCard card1 = createItemCard(resources, R.string.group1_titletext, R.string.group1_subtext, R.drawable.unicef);
        ItemCard card2 = createItemCard(resources, R.string.group2_titletext, R.string.group2_subtext, R.drawable.neighbors);
        ItemCard card3 = createItemCard(resources, R.string.group3_titletext, R.string.group3_subtext, R.drawable.neighbors);
        ItemCard card4 = createItemCard(resources, R.string.group4_titletext, R.string.group4_subtext, R.drawable.neighbors);
        ItemCard card5 = createItemCard(resources, R.string.group5_titletext, R.string.group5_subtext, R.drawable.neighbors);
        ItemCard card6 = createItemCard(resources, R.string.group6_titletext, R.string.group6_subtext, R.drawable.neighbors);
        ItemCard card7 = createItemCard(resources, R.string.group7_titletext, R.string.group7_subtext, R.drawable.neighbors);
        ItemCard card8 = createItemCard(resources, R.string.group8_titletext, R.string.group8_subtext, R.drawable.neighbors);
        ItemCard card9 = createItemCard(resources, R.string.group9_titletext, R.string.group9_subtext, R.drawable.neighbors);
        ItemCard card10 = createItemCard(resources, R.string.group10_titletext, R.string.group10_subtext, R.drawable.neighbors);

        return Arrays.asList(card1, card2, card3, card4, card5, card6, card7, card8, card9, card10);
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

    private static ItemCard createItemCard(Resources resources, @StringRes int title, @StringRes int description, @DrawableRes int image) {
        ItemCard itemCard = new ItemCard();

        itemCard.setTitle(resources.getString(title));
        itemCard.setDescription(resources.getString(description));
        itemCard.setThumbnailUrl(resources.getDrawable(image));

        return itemCard;
    }
}
