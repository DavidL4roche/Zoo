package Zoo;

import java.util.ArrayList;
import java.util.Arrays;

public final class Utils {
    private static ArrayList listRankDomination = new ArrayList<>(Arrays.asList('α', 'β', 'γ', 'δ', 'ε', 'ζ', 'η', 'θ', 'ι', 'κ', 'λ',
    		'μ', 'ν', 'ξ', 'ο', 'π', 'ρ', 'σ', 'τ', 'υ', 'φ', 'χ', 'ψ', 'ω'));

    public static ArrayList getListRankDomination() {
        return listRankDomination;
    }

    public static boolean isInListRank(char c) {
        if(listRankDomination.contains(c)) {
            return true;
        }
        return false;
    }

    public static boolean isDominant(char c1, char c2) {
        if(isInListRank(c1) && isInListRank(c2)) {
            if(listRankDomination.indexOf(c1) > listRankDomination.indexOf(c2)) {
                return true;
            }
        }
        return false;
    }
}
