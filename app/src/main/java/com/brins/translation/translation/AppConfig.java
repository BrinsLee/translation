package com.brins.translation.translation;

import java.util.HashMap;
import java.util.Map;

public class AppConfig {

    public static final String BASEURL = "https://translate.google.cn/";
    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36";
    public static final Map<String ,String > languageSelect = languageSelected();

    private static Map<String,String> languageSelected() {

        Map<String, String> m = new HashMap<>();
        m.put("Automatic","auto");
        m.put("Afrikaans","af");
        m.put("Albanian","sq");
        m.put("Arabic","ar");
        m.put("Armenian","hy");
        m.put("Azerbaijani","az");
        m.put("Basque","eu");
        m.put("Belarusian","be");
        m.put("Bengali","bn");
        m.put("Bosnian","bs");
        m.put("Bulgarian","bg");
        m.put("Catalan","ca");
        m.put("Cebuano","ceb");
        m.put("Chichewa","ny");
        m.put("Chinese Simplified","zh-cn");
        m.put("Chinese Traditional","zh-tw");
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
        m.put("Geek","el");
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
