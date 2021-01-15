package web.services.learn.containers;

import net.mindview.util.Print;

import java.util.*;

public class Countries {
    public static final String[][] DATA = {{"", ""}, {"", ""}};

    /**
     * 自定义的map类。
     */
    private static class FlyWeightMap extends AbstractMap<String, String> {
        /**
         * 自定义的Entry类。
         */
        private static class MyEntry implements Map.Entry<String, String> {

            private int index;

            public MyEntry(int index) {
                this.index = index;
            }

            @Override
            public String getKey() {
                return DATA[index][0];
            }

            @Override
            public String getValue() {
                return DATA[index][1];
            }

            @Override
            public String setValue(String value) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean equals(Object o) {
                return DATA[index][0].equals(o);
            }

            @Override
            public int hashCode() {
                return DATA[index][0].hashCode();
            }
        }

        /**
         * 自定义的EntrySet。
         */
        private static class MyEntrySet extends AbstractSet<Map.Entry<String, String>> {
            private int size;

            public MyEntrySet(int size) {
                this.size = size;
            }

            /**
             * 自定义迭代器。
             */
            private static class MyIterator implements Iterator<Map.Entry<String, String>> {

                @Override
                public boolean hasNext() {
                    return false;
                }

                @Override
                public Entry<String, String> next() {
                    return null;
                }
            }

            @Override
            public Iterator<Map.Entry<String, String>> iterator() {
                return new MyIterator();
            }

            @Override
            public int size() {
                return size;
            }
        }

        @Override
        public Set<Entry<String, String>> entrySet() {
            return new MyEntrySet(DATA.length);
        }
    }

    private static Map<String, String> map = new FlyWeightMap();

    public static Map<String, String> capitals() {
        return map;
    }

    public static List<String> names() {
        return new ArrayList<>(map.keySet());
    }

    public static void main(String[] args) {
        Map<String, String> templateMap = capitals();
        List<String> templateList = names();
        Print.print(new ArrayList<>(templateList));
        Print.print(new LinkedHashMap<>(templateMap));
    }
}
