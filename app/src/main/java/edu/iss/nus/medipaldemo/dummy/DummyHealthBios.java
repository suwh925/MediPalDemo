package edu.iss.nus.medipaldemo.dummy;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample conditonName for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyHealthBios {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyHealthBio> ITEMS = new ArrayList<DummyHealthBio>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyHealthBio> ITEM_MAP = new HashMap<String, DummyHealthBio>();

    private static final int COUNT = 5;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    public static void addItem(DummyHealthBio item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static DummyHealthBio createDummyItem(int position) {
        return new DummyHealthBio(String.valueOf(position), makeDetails(position),new Date(),"C");
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Health Condition History " + position + " information here.");
        return builder.toString();
    }


}

