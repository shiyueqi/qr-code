package com.unionpay.algorithm;

/**
 * date: 2017/05/15 14:01.
 * author: Yueqi Shi
 */
public class Heart {

    public static void main(String[] args) {

        String res = simpleHeart("*");
        System.out.println(res);

        //单心
        heart(15,0.9,"love");
        //双心
        heartTwo(15,0.9,"爱","梁山伯","祝英台");
        //点缀
        heartTwoWithXK(15, 0.9, "爱", "梁山伯", "祝英台");
    }

    /**
     * 控制台版打印心形
     * @param input
     * @return
     */
    public static String simpleHeart(String input) {

        int[] array = {0, 1, 0, 0, 0, 1, 0
                , 1, 0, 1, 0, 1, 0, 1
                , 1, 0, 0, 1, 0, 0, 1
                , 1, 4, 5, 2, 3, 4, 1
                , 0, 1, 0, 0, 0, 1, 0
                , 0, 0, 1, 0, 1, 0, 0
                , 0, 0, 0, 1, 0, 0, 0
                , 0, 0, 0, 0, 0, 0, 0
                , 0};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {

            if (i % 7 == 0)

                sb.append("\n");

            if (array[i] == 0)

                sb.append("   ");

            else if (array[i] == 4)

                sb.append("  ");

            else if (array[i] == 5)

                sb.append(" I ");

            else if (array[i] == 2)

                sb.append("Love ");

            else if (array[i] == 3)

                sb.append("You");

            else

                sb.append("  " + input);

        }

        return sb.toString();

    }

    /**
     * 由于微信扫描二维码会出现错乱，因此，调整一个微信版心形
     * @param input
     * @return
     */
    public static String simpleWeChatHeart(String input) {

        int[] array = {0, 1, 0, 0, 0, 1, 0
                , 1, 0, 1, 0, 1, 0, 1
                , 1, 0, 0, 1, 0, 0, 1
                , 1, 4, 5, 2, 3, 4, 1
                , 0, 1, 0, 0, 0, 1, 0
                , 0, 0, 1, 0, 1, 0, 0
                , 1, 0, 0, 0, 0, 0, 0};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {

            if (i % 7 == 0 && i != 0)

                sb.append("\n");

            if (array[i] == 0)

                sb.append("     ");

            else if (array[i] == 4)

                sb.append("    ");

            else if (array[i] == 5)

                sb.append(" I ");

            else if (array[i] == 2)

                sb.append("love ");

            else if (array[i] == 3)

                sb.append("you");

            else

                sb.append("    ").append(input);

        }

        return sb.toString();

    }

    /**
     * 转载算法
     * @param r
     * @param size
     * @param req
     */
    public static void heart(int r, double size, String req) {
        size = 1 / (1.5 * r * size);
        StringBuilder sb = new StringBuilder();
        for (int y = r; y > -r; y--, sb.append("\n"))
            for (int x = -2 * r; x < 2 * r; x++) {
                char msg = (req + req).charAt((x - y) % req.length() + req.length());
                sb.append((inHeart(size, x, y) ? msg + " " : " "));
            }
        System.err.println(sb.toString());
    }

    /**
     * 转载算法
     * @param r
     * @param size
     * @param center
     * @param left
     * @param right
     */
    public static void heartTwo(int r, double size, String center, String left, String right) {
        size = 1 / (1.5 * r * size);
        StringBuilder sb = new StringBuilder();
        for (int y = r; y > -r; y--, sb.append("\n"))
            for (int x = -2 * r; x < 4 * r; x++) {
                boolean isLeft = inHeart(size, x, y);
                boolean isRight = inHeart(size, x - 25, y - 3);
                //双空格
                String req = null;
                if (isLeft && isRight) req = center;
                else if (isLeft) req = left;
                else if (isRight) req = right;
                if (req != null) sb.append((req + req).charAt((x - y) % req.length() + req.length()));
                else sb.append(" ");//双空格
            }
        System.err.println(sb.toString());
    }

    /**
     * 转载算法
     * @param r
     * @param size
     * @param center
     * @param left
     * @param right
     */
    public static void heartTwoWithXK(int r, double size, String center, String left, String right) {
        size = 1 / (1.5 * r * size);
        StringBuilder sb = new StringBuilder();
        for (int y = r; y >= -r; y--, sb.append("\n"))
            for (int x = -2 * r; x <= 4 * r; x++) {
                boolean isLeft = inHeart(size, x, y + 3);
                boolean isRight = inHeart(size, x - 25, y);
                //双空格
                String req = null;
                String w = "";
                if (isLeft && isRight) req = center;
                else if (isLeft) req = left;
                else if (isRight) req = right;
                else if ((y == -r || y == r)) {
                    if (x < 3 * r - 7) {
                        req = "♥";
                        w = " ";
                    }
                } else if (x == 4 * r || x == -2 * r || line(x, y + 3)) req = "♥";
                if (req != null) sb.append((req + req).charAt((x - y) % req.length() + req.length()) + w);
                else sb.append(" ");//双空格
            }
        System.err.println(sb.toString());
    }

    private static boolean inHeart(double size, int x, int y) {
        return Math.pow(Math.pow(x * size, 2) + Math.pow(y * 2 * size, 2) - 1, 3) - Math.pow(x * size, 2) * Math.pow(y * 2 * size, 3) <= 0;
    }

    private static boolean line(int x, int y) {
        return 4 * y - x == 0;
    }

}
