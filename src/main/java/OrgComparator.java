import java.util.*;

public class OrgComparator {
    Comparator<String> comparator = (Str1, Str2) -> {
        String[] orgUnit1 = Str1.split("\\\\");
        String[] orgUnit2 = Str2.split("\\\\");

        int compareResult = 0;
        for (int i = 0; i < orgUnit1.length || i < orgUnit2.length; i++) {
            if (i >= orgUnit1.length) return -1;
            else if (i >= orgUnit2.length) return 1;

            compareResult = -1 * orgUnit1[i].compareTo(orgUnit2[i]);

            if (compareResult != 0) {
                return compareResult;
            }
        }
        return compareResult;
    };
}

