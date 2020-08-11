import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] orgStructure = {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};

        List<String> sortedOrgStructure = sortOrgStructure(orgStructure);
        System.out.println(sortedOrgStructure);
    }

    private static List<String> sortOrgStructure(String[] orgStructure) {
        HashSet<String> hashSet = new HashSet<>();

        for (String unit : orgStructure) {
            String[] splitUnit = unit.split("\\\\");
            String mainUnit = splitUnit[0];
            hashSet.add(mainUnit);

            for (int i = 1; i < splitUnit.length; i++) {
                mainUnit = mainUnit + "\\" + splitUnit[i];
                hashSet.add(mainUnit);
            }
        }

        List<String> unitList = new ArrayList<>(hashSet);

        OrgComparator orgComparator = new OrgComparator();
        Collections.sort(unitList, orgComparator.comparator);
        return unitList;
    }
}
