//Time: 24:14.99

class Solution {
    public String validIPAddress(String queryIP) {
        if (isValid4(queryIP)) {
            return "IPv4";
        }

        if (isValid6(queryIP)) {
            return "IPv6";
        }

        return "Neither";
    }

    public boolean isValid4(String queryIP) {
        if (queryIP.startsWith(".") || queryIP.endsWith(".")) {
            return false;
        }

        String[] segments = queryIP.split("[.]"); //mistake: "." is regex, needed to use "[.]"
        if (segments.length != 4) {
            return false;
        }

        for (String segment : segments) {
            if (!isValid4Segment(segment)) {
                return false;
            }
        }

        return true;
    }

    public boolean isValid4Segment(String segment) {
        try {
            Integer integer = Integer.parseInt(segment);
            if (integer > 255 || integer < 0) {
                return false;
            }

            if (segment.startsWith("0") && segment.length() > 1) {
                return false;
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isValid6(String queryIP) {
        if (queryIP.startsWith(":") || queryIP.endsWith(":")) {
            return false;
        }

        String[] segments = queryIP.split("[:]"); //mistake: "." is regex, needed to use "[.]"
        if (segments.length != 8) {
            return false;
        }

        for (String segment : segments) {
            if (!isValid6Segment(segment)) {
                return false;
            }
        }

        return true;
    }

    public boolean isValid6Segment(String segment) {
        if (segment.length() > 4 || segment.length() == 0) {
            return false;
        }

        for (char c : segment.toCharArray()) {
            if (Character.digit(c,16) == -1) {
                return false;
            }
        }
        return true;
    }

}

//mitake: "2001:0db8:85a3:0:0:8A2E:0370:7334:" need to account for leading and trailing "." & ":", assimed they would return "" with split

//mistake: "00.0.0.0" need to account for when starts with zero, is zero, and still is wrong, replaced starts with zero & not zero with starts with zero and length > 1

//mistake: "2001:0db8:85a3:00000:0:8A2E:0370:7334" overlooked segment length

//mistake: "2001:db8:85a3:0::8a2E:0370:7334" overlooked segment length minimum
