package tags;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Map<String, String> menus = new HashMap<String, String>();

        menus.put("비오는날", "");
        menus.put("비오는날", "#자장면");
        menus.put("비오는날", menus.get("비오는날") + "#피자");
        menus.put("비오는날", menus.get("비오는날") + "#설빙");
        menus.put("비오는날", menus.get("비오는날") + "#바나나");
        menus.put("비오는날", menus.get("비오는날") + "#사과");
        menus.put("비오는날", menus.get("비오는날") + "#귤");
        
        menus.put("긴장되는", "#마라탕");
        menus.put("긴장되는", menus.get("긴장되는") + "#바나나");
        menus.put("긴장되는", menus.get("긴장되는") + "#고구마");

        menus.put("짜증나는", "#다크초콜릿");
        menus.put("짜증나는", menus.get("짜증나는") + "#연어");
        menus.put("짜증나는", menus.get("짜증나는") + "#견과류");

        menus.put("피곤한", "#오리고기");
        menus.put("피곤한", menus.get("피곤한") + "#꿀물");
        menus.put("피곤한", menus.get("피곤한") + "#매실차");

        menus.put("바람부는", "#버섯전골");
        menus.put("바람부는", menus.get("바람부는") + "#수제비");
        menus.put("바람부는", menus.get("바람부는") + "#잔치국수");

        menus.put("미세먼지 심한", "#콩나물국");
        menus.put("미세먼지 심한", menus.get("미세먼지 심한") + "#미역국");
        menus.put("미세먼지 심한", menus.get("미세먼지 심한") + "#고등어구이");

        menus.put("따뜻한", "#짜장면");
        menus.put("따뜻한", menus.get("따뜻한") + "#치즈케이크");
        menus.put("따뜻한", menus.get("따뜻한") + "#냉면");

        menus.put("야식 땡기는 날", "#치킨");
        menus.put("야식 땡기는 날", menus.get("야식 땡기는 날") + "#피자");
        menus.put("야식 땡기는 날", menus.get("야식 땡기는 날") + "#만두");

        menus.put("소화 안되는 날", "#죽");
        menus.put("소화 안되는 날", menus.get("소화 안되는 날") + "#숭늉");
        menus.put("소화 안되는 날", menus.get("소화 안되는 날") + "#수프");

        menus.put("데이트", "#초밥");
        menus.put("데이트", menus.get("데이트") + "#스테이크");
        menus.put("데이트", menus.get("데이트") + "#피자");

        ArrayList<String> menusList = new ArrayList<String>(Arrays.asList(menus.get("비오는날").split("#")));
        for(String menu : menusList) {
            System.out.println(menu);
        }
        menusList.add("파프리카");

        System.out.println(String.join("#", menusList));

//        System.out.println(menus);
    }

}