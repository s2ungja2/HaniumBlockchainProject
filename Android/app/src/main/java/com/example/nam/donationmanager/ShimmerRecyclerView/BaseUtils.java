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
        ItemCard ndtvCard = createItemCard(resources, R.string.ndtv_titletext, R.string.ndtv_image_url,
                R.string.ndtv_subtext, R.string.ndtv_submittext);

        ItemCard opCard = createItemCard(resources, R.string.op_titletext, R.string.op_image_url,
                R.string.op_subtext, R.string.op_submittext);

        ItemCard gotCard = createItemCard(resources, R.string.got_titletext, R.string.got_image_url,
                R.string.got_subtext, R.string.got_submittext);

        ItemCard jetCard = createItemCard(resources, R.string.jet_titletext, R.string.jet_image_url,
                R.string.jet_subtext, R.string.jet_submittext);

        return Arrays.asList(ndtvCard, opCard, gotCard, jetCard);
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

    private static ItemCard createItemCard(Resources resources, @StringRes int title, @StringRes int imageUrl,
                                           @StringRes int description, @StringRes int submit) {
        ItemCard itemCard = new ItemCard();

        itemCard.setTitle(resources.getString(title));
        itemCard.setThumbnailUrl(resources.getString(imageUrl));
        itemCard.setDescription(resources.getString(description));
        itemCard.setSubmitText(resources.getString(submit));

        return itemCard;
    }
}
