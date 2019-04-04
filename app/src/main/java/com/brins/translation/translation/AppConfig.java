package com.brins.translation.translation;

import java.util.HashMap;
import java.util.Map;

public class AppConfig {

    public static final String BASEURL = "https://translate.google.cn/";
    public static final String DAILY = "http://open.iciba.com/";
    public static final String IMAGE = "http://cdn.iciba.com/";
    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";
    public static final Map<String ,String > languageSelect = languageSelected();

    private static Map<String,String> languageSelected() {

        Map<String, String> m = new HashMap<>();
        m.put("Automatic","auto");
        m.put("自动","auto");

        m.put("Afrikaans","af");
        m.put("南非荷兰语","af");

        m.put("Albanian","sq");
        m.put("阿尔巴尼亚语","sq");

        m.put("Arabic","ar");
        m.put("阿拉伯语","ar");

        m.put("Armenian","hy");
        m.put("亚美尼亚语","hy");

        m.put("Azerbaijani","az");
        m.put("阿塞拜疆语","az");

        m.put("Basque","eu");
        m.put("巴斯克语","eu");

        m.put("Belarusian","be");
        m.put("白俄罗斯语","be");

        m.put("Bengali","bn");
        m.put("孟加拉语","bn");

        m.put("Bosnian","bs");
        m.put("波斯尼亚语","bs");

        m.put("Bulgarian","bg");
        m.put("保加利亚语","bg");

        m.put("Catalan","ca");
        m.put("加泰罗尼亚语","ca");

        m.put("Cebuano","ceb");
        m.put("宿务语","ceb");

        m.put("Chichewa","ny");
        m.put("奇切瓦语","ny");

        m.put("Chinese Simplified","zh-CN");
        m.put("简体中文","zh-CN");

        m.put("Chinese Traditional","zh-TW");
        m.put("繁体中文","zh-TW");

        m.put("科西嘉语","co");
        m.put("克罗地亚语","hr");
        m.put("捷克语","cs");
        m.put("丹麦语","da");
        m.put("荷兰语","nl");
        m.put("英语","en");
        m.put("世界语","eo");
        m.put("爱沙尼亚语","et");
        m.put("菲律宾语","tl");
        m.put("芬兰语","fi");
        m.put("法语","fr");

        m.put("弗里斯兰语","fy");
        m.put("加利西亚语","gl");
        m.put("格鲁吉亚语","ka");
        m.put("德语","de");
        m.put("希腊语","el");
        m.put("古吉拉特语","gu");
        m.put("克里奥尔语","ht");
        m.put("豪萨语","ha");
        m.put("夏威夷语","haw");
        m.put("希伯来语","iw");
        m.put("印地语","hi");
        m.put("苗语","hmn");
        m.put("匈牙利语","hu");
        m.put("冰岛语","is");
        m.put("伊博语","ig");
        m.put("印度尼西亚语","id");
        m.put("爱尔兰的语","ga");
        m.put("意大利语","it");
        m.put("日语","ja");
        m.put("爪哇语","jw");
        m.put("卡纳达语","kn");
        m.put("哈萨克语","kk");
        m.put("高棉语","km");

        m.put("韩语","ko");
        m.put("库尔德语","ku");
        m.put("吉尔吉斯语","ky");
        m.put("老挝语","lo");
        m.put("拉丁语","la");
        m.put("拉脱维亚语","lv");
        m.put("立陶宛语","lt");
        m.put("卢森堡语","lb");
        m.put("马其顿语","mk");
        m.put("马尔加什语","mg");
        m.put("马来语","ms");
        m.put("马拉雅拉姆语","ml");
        m.put("马耳他语","mt");
        m.put("毛利语","mi");
        m.put("马拉语","mr");
        m.put("蒙语","mn");
        m.put("缅甸语","my");
        m.put("尼泊尔语","ne");
        m.put("挪威语","no");
        m.put("普什图语","ps");
        m.put("波斯语","fa");
        m.put("波兰语","pl");
        m.put("葡萄牙语","pt");
        //
        m.put("旁遮普语","ma");
        m.put("罗马尼亚语","ro");
        m.put("俄语","ru");
        m.put("萨摩亚语","sm");
        m.put("苏格兰盖尔语","gd");
        m.put("塞尔维亚语","sr");
        m.put("塞索托语","st");

        m.put("绍纳语","sn");
        m.put("信德语","sd");
        m.put("僧伽罗语","si");
        m.put("斯洛伐克语","sk");
        m.put("斯洛文尼亚语","sl");
        m.put("索马里语","so");
        m.put("西班牙语","es");
        m.put("苏丹语","su");
        m.put("斯瓦希里语","sw");
        m.put("瑞典语","sv");
        m.put("塔吉克语","tg");
        m.put("泰米尔语","ta");
        m.put("泰卢固语","te");
        m.put("泰语","th");
        m.put("土耳其语","tr");
        m.put("乌克兰语","uk");
        m.put("乌尔都语","ur");
        m.put("乌兹别克语","uz");
        m.put("越南语","vi");
        m.put("威尔士语","cy");
        m.put("科萨语","xh");
        m.put("意第绪语","yi");
        m.put("约鲁巴语","yo");
        m.put("祖鲁语","zu");

        m.put("Corsican","co");
        m.put("Croatian","hr");
        m.put("Czech","cs");
        m.put("Danish","da");
        m.put("Dutch","nl");
        m.put("English","en");
        m.put("Esperanto","eo");
        m.put("Estonian","et");
        m.put("Filipino","tl");
        m.put("Finnish","fi");
        m.put("French","fr");

        m.put("Frisian","fy");
        m.put("Galician","gl");
        m.put("Georgian","ka");
        m.put("German","de");
        m.put("Greek","el");
        m.put("Gujarati","gu");
        m.put("Haitian Creole","ht");
        m.put("Hausa","ha");
        m.put("Hawaiian","haw");
        m.put("Hebrew","iw");
        m.put("Hindi","hi");
        m.put("Hmong","hmn");
        m.put("Hungarian","hu");
        m.put("Icelandic","is");
        m.put("Igbo","ig");
        m.put("Indonesian","id");
        m.put("Irish","ga");
        m.put("Italian","it");
        m.put("Japanese","ja");
        m.put("Javanese","jw");
        m.put("Kannada","kn");
        m.put("Kazakh","kk");
        m.put("Khmer","km");

        m.put("Korean","ko");
        m.put("Kurdish (Kurmanji)","ku");
        m.put("Kyrgyz","ky");
        m.put("Lao","lo");
        m.put("Latin","la");
        m.put("Latvian","lv");
        m.put("Lithuanian","lt");
        m.put("Luxembourgish","lb");
        m.put("Macedonian","mk");
        m.put("Malagasy","mg");
        m.put("Malay","ms");
        m.put("Malayalam","ml");
        m.put("Maltese","mt");
        m.put("Maori","mi");
        m.put("Marathi","mr");
        m.put("Mongolian","mn");
        m.put("Myanmar (Burmese)","my");
        m.put("Nepali","ne");
        m.put("Norwegian","no");
        m.put("Pashto","ps");
        m.put("Persian","fa");
        m.put("Polish","pl");
        m.put("Portuguese","pt");
        //
        m.put("Punjabi","ma");
        m.put("Romanian","ro");
        m.put("Russian","ru");
        m.put("Samoan","sm");
        m.put("Scots Gaelic","gd");
        m.put("Serbian","sr");
        m.put("Sesotho","st");

        m.put("Shona","sn");
        m.put("Sindhi","sd");
        m.put("Sinhala","si");
        m.put("Slovak","sk");
        m.put("Slovenian","sl");
        m.put("Somali","so");
        m.put("Spanish","es");
        m.put("Sudanese","su");
        m.put("Swahili","sw");
        m.put("Swedish","sv");
        m.put("Tajik","tg");
        m.put("Tamil","ta");
        m.put("Telugu","te");
        m.put("Thai","th");
        m.put("Turkish","tr");
        m.put("Ukrainian","uk");
        m.put("Urdu","ur");
        m.put("Uzbek","uz");
        m.put("Vietnamese","vi");
        m.put("Welsh","cy");
        m.put("Xhosa","xh");
        m.put("Yiddish","yi");
        m.put("Yoruba","yo");
        m.put("Zulu","zu");
        return m;

    }
}
