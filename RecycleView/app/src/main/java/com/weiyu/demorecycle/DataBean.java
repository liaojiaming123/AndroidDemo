package com.weiyu.demorecycle;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataBean {
    public DataBean(){initList();initMap();
    }

    private List<String> list = new ArrayList<>();
    private String[] strings;
    private HashMap<String,String> map = new HashMap<>();
    private String area;
    private String team;
    public List<String> getTitle() {
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            list.add(entry.getKey());
        }
        return list;
    }
    public List<String> getContent(){
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }
    public void setTitle(String area) {

        this.area = area;
    }
    public void setContent(String team) {
        this.team = team;
    }

    private void initList(){
        list.add("与其安慰自己平凡可贵，不如拼尽全力活得漂亮。");
        list.add("这世界总有人在笨拙地爱着你，想把全部的温柔都给你。");
        list.add("陪伴本来就是这世界上最了不起的安慰。");
        list.add("长不过执念，短不过善变。");
        list.add("无论多么艰难的现在，终会翻篇。朝未来大步向前吧，别丧，别止步。");
        list.add("希望下一次，能喜欢上一个也喜欢自己的人。");
        list.add("这个世界上，有些人有多冷漠，有些人就有多温暖，希望你总会遇到那些温暖对你的人。");
        list.add("以前对你的喜欢，是见你，念你，陪伴你。现在对你的喜欢，是不问，不看，不叨扰。");
        list.add("只要结局是喜剧，过程你要我怎么哭都行，幸福可以来的慢一些，只要它是真的，如果最后能在一起，晚点我真的无所谓的。");
        list.add("若不是情深似海，思念又怎会泛滥成灾。");
        list.add("爱一个人最好的方式， 是经营好自己； 爱人要有度，留一点自我， 才会有自尊，你的付出才会有人重视。");
        list.add("执子之手，共你一世风霜。 吻子之眸，赠你一世深情。");
        list.add("你是我的乍见之欢，你是我的眼神所向 你是我的温柔的归宿 你是我的嘴角扬起的理由。");
        list.add("只有你想见我的时候，我们的相遇才有意义。");
        list.add("看不清的人，时间会让他现原形。 猜不透的心，生活会给你个答案。");
        list.add("我们活在世上能感受到的最美好之事： 向所爱之人倾诉爱意， 以及对感激之人道谢。");
        list.add("再等一下，上帝肯定会把最特别的你，送给一个最爱你且最特别的人。");
        list.add("别人的目光一点都不重要 你只管按照自己的喜好 去决定你的人生 愿你能过的简单 从容");
        list.add("以前总以为，人生最美好的是相遇。 后来才明白，其实难得的是重逢。 如果说相遇是久别重逢，希望我们别来无恙。");
        list.add("当你越来越优秀的时候，就会遇见越来越好的人。");
    }
    private void initMap(){
        map.put("逆流成河","斑驳的夜色在说什么，谁能告诉我如何选择。");
        map.put("遇到","我们绕了这么一圈才遇到，我比谁都更明白你的重要。");
        map.put("多年以后","多年以后我还能不能活着，会不会有人为我唱首歌，多年以后会不会有人还记得我，记得这个世界我来过");
        map.put("无期","前路漫漫雨纷纷，谁在痴痴等，任其心头千般恨，不做负心人。");
        map.put("我这一生","我曾大雨之中挽起袖子迎风而行，害怕停下脚步整个世界突然落空。");
        map.put("小幸运","原来你是我最想留住的幸运，原来我们曾经和爱情靠得那么近。");
        map.put("勇气","我爱你，无畏人海的拥挤，用尽余生的勇气，只为能靠近你，哪怕一厘米。");
        map.put("大鱼","看你飞远去看你离我而去，原来你生来就属于天际。");
        map.put("醉千年","就只看了你一眼，就已确定了永远，那时候车马慢，一生只够爱一人。");
        map.put("只要平凡","放过对错才知答案，活着的勇敢，没有神的光环，你我生而平凡。");
        map.put("回忆总想哭","千辛万苦的付出，早已放弃了归路，爱到深处却只剩下无助。");
        map.put("一个人挺好","这么些年，我习惯了安稳，没有了冲动，没有了憎恨。");
        map.put("少年","我还是从前那个少年，没有一丝丝改变，时间只不过是考验，种在心中信念丝毫未减。");
        map.put("往后余生","往后余生，风雪是你，平淡是你，清贫也是你。");
        map.put("退","往事今非昔比，回忆如一摊泥。");
        map.put("过客","你只是一个过客，从我的世界路过，我不敢太多不舍，怕你看出我难过。");
        map.put("凉凉","凉凉三生三世恍然如梦，须臾的年风干泪痕，若是回忆不能再相认，就让情分落九尘。");
        map.put("一曲相思","浊酒一杯余生不悲不喜，何惧爱恨别离，一路纵马去斟酌，一曲相思入江水与山河，在油伞下走过，悠然入梦却恍若昨。");
        map.put("伤离别","用一生痴情换一幕悲剧伤离别，我执子之手竟无语凝噎。");
        map.put("世界这么大还是遇见你","世界这么大还是遇见你，多少次疯狂多少天真，一起做过梦，有一天我们会重逢故里。");

    }
    public void initStrings(){
        String string = "Hello";

    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public String[] getStrings() {
        return strings;
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }

}
