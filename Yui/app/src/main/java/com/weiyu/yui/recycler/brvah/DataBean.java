package com.weiyu.yui.recycler.brvah;

import java.util.ArrayList;
import java.util.List;

public class DataBean {
    private List<String> strings = new ArrayList<>();
    private List<String> chars = new ArrayList<>();

    public DataBean(){
        initStrings();initChars();
    }
    private void initStrings(){
        strings.add("待我荣华富贵，许你十里桃花。");
        strings.add("待我名满华夏，许你当歌纵马。");
        strings.add("待我高头大马，许你嫁衣红霞。");
        strings.add("待我功成名达，许你花前月下。");
        strings.add("待我半生戎马，许你共话桑麻。");
        strings.add("待我君临天下，许你四海为家。");
        strings.add("待我了无牵挂，许你浪迹天涯。");
        strings.add("晓看天色暮看云，行也思君，坐也思君。");
        strings.add("春赏百花冬观雪，醒亦念卿，梦亦念卿。");
        strings.add("I like you, but I just like you!");
        strings.add("纵然万劫不复，纵然相思入骨，我也待你，眉眼如初，岁月如故！");
        strings.add("吾闻此间山水奇，钟灵毓秀似仙居。意气风发神往矣，君愿伴余共赴之。");
        strings.add("我倚窗前思红颜，喜雨漫洒串珠帘。欢舞翩翩飘倩影，你笑嫣然似花仙。");
        strings.add("嫁与春风不用媒，我倚窗前思故人。可知明月伴我心，好山长在水长流。");
        strings.add("你欲情丝断红颜，想入莺飞可奈何。得意皓月怎当空，美忆情兮醉今生。");
        strings.add("I love three things in the world, sun moon and you, sun for morning, moon for night, and you forever!");
        strings.add("浮世三千，吾爱有三：日月与卿，日为朝，月为暮，卿为朝朝暮暮。");
        strings.add("何为江湖？剑未佩妥，出门已是江湖，酒尙余温，入口不识乾坤。");
        strings.add("何为英雄？愿你长枪穿云，一人可破山河。");
        strings.add("何为孤独？人生天地间，忽如远行客。");
        strings.add("为何无人懂我？苍天不懂人间暖，冷眼看花尽是悲。");
        strings.add("余晖晚霞，生如夏花！我曾纵马向天涯，");
        strings.add("只影如枫叶飘零，要落谁家？你如酒，醉我年华！");
        strings.add("嫁衣锦绣，龙吟凤啸。给你八荒四海，");
        strings.add("我沙场，逞英豪。可愿随我，征战天下，好人相伴，风尘笑傲。");
    }
    public List<String> getStrings(){
        return strings;
    }
    private void initChars(){
        chars.add("推荐");chars.add("喜欢");chars.add("短视屏");chars.add("音乐");
        chars.add("直播");chars.add("游戏");chars.add("电影");chars.add("电视剧");
    }
    public List<String> getChars(){
        return chars;
    }
}
