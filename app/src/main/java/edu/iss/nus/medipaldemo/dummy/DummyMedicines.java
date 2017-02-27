package edu.iss.nus.medipaldemo.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample medicineName for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyMedicines {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyMedicine> ITEMS = new ArrayList<DummyMedicine>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyMedicine> ITEM_MAP = new HashMap<String, DummyMedicine>();

    private static final int COUNT = 5;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyMedicine item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyMedicine createDummyItem(int position) {
        return new DummyMedicine(String.valueOf(position), "Medicine " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        //builder.append("Medicine Name: ").append("Medicine " + position);
        /*for (int i = 0; i < position; i++) {
            builder.append("\nMore description information here.");
        }*/
        builder.append("\nMore description information here.");
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of medicineName.
     */
    public static class DummyMedicine {
        public final String id;
        public final String medicineName;
        public final String description;

        public DummyMedicine(String id, String content, String details) {
            this.id = id;
            this.medicineName = content;
            this.description = details;
        }

        @Override
        public String toString() {
            return medicineName;
        }
    }
}
