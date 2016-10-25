package com.hcrcms.core.web.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 汉字转为拼音
 * @author jingrun.zhang
 *
 */
public class PingyinUtil {

	// 将汉字转换为全拼  
    public static String getPingYin(String src) {  
  
        char[] t1 = null;  
        t1 = src.toCharArray();  
        String[] t2 = new String[t1.length];  
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();  
          
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);  
        String t4 = "";  
        int t0 = t1.length;  
        try {  
            for (int i = 0; i < t0; i++) {  
                // 判断是否为汉字字符  
                if (java.lang.Character.toString(t1[i]).matches(  
                        "[\\u4E00-\\u9FA5]+")) {  
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);  
                    t4 += t2[0];  
                } else  
                    t4 += java.lang.Character.toString(t1[i]);  
            }  
            // System.out.println(t4);  
            return t4;  
        } catch (BadHanyuPinyinOutputFormatCombination e1) {  
            e1.printStackTrace();  
        }  
        return t4;  
    }  
  
    // 返回中文的首字母  
    public static String getPinYinHeadChar(String str) {  
  
        String convert = "";  
        for (int j = 0; j < str.length(); j++) {  
            char word = str.charAt(j);  
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);  
            if (pinyinArray != null) {  
                convert += pinyinArray[0].charAt(0);  
            } else {  
                convert += word;  
            }  
        }  
        return convert;  
    }  
  
    // 将字符串转移为ASCII码  
    public static String getCnASCII(String cnStr) {  
        StringBuffer strBuf = new StringBuffer();  
        byte[] bGBK = cnStr.getBytes();  
        for (int i = 0; i < bGBK.length; i++) {  
            strBuf.append(Integer.toHexString(bGBK[i] & 0xff));  
        }  
        return strBuf.toString();  
    }  
  
    public static void main(String[] args) {  
        /*System.out.println(getPingYin("綦江qq县"));  
        System.out.println(getPinYinHeadChar("綦江县"));  
        System.out.println(getCnASCII("綦江县"));  
        System.out.println("-------------------------------------------------------------");
        System.out.println(getPingYin("中华人民共和国"));*/
    	
    	try {
    		/*File file = new File("d:/authorResult.txt");
			FileWriter fw = null;
			fw = new FileWriter(file, true);
			PrintWriter pw = new PrintWriter(fw);
			String str = " 21世纪经济报, 36氪, Bernard Marr   , CCTIME飞象网, CIO时代网, cnbeta网站, FellowData, i199it, it168网站, ITBear	, ITBEAR, Millie Liu, TECH2IPO创见, 丁雪娇, 三版富 , 中关村在线, 中华网投资, 中国农业科学院茶学社, 中国大数据, 中国惠农网 , 中国日报网, 中国网, 中国证券报, 中工网, 中文科技资讯, 中金网, 人民日报 , 刘勇, 刘彦, 刘磊, 刘辉, 华西都市报, 华龙网, 卓明地产, 叶丹, 吴明辉, 多彩贵州网, 天津北方网综合, 孙艺新, 孙骋 , 宇廷, 宋洪涛, 弓凤飞, 张培明, 张旭阳, 张绪旺, 张莉, 张高, 徐晓风, 新华房产, 新华网, 新快报, 新浪体育, 朱明, 李华芳, 李呈祥, 李梦倩, 李瑜, 李碧云, 杜梦雅, 杨旺的家, 杨菁, 杨静, 林漳希, 梅花网 , 汪源, 浙江日报, 潘晓亮, 澎湃新闻网, 牛肉圆粉不加葱, 物联中国, 王丽颖, 田溯宁, 白昕, 第一财经日报, 网易教育频道综合, 罗超, 美国加州资深房地产投资专家, 蒋志予, 谢振亮, 财经领袖, 车品觉, 邬贺铨, 邱燕娜, 郑俊芳, 郭炜, 郭跃军, 郭迅华, 金毛毛, 钱冰冰, 锋芒, 阿尔法公社, 陈刚, 陈婕, 陈雪柠, 陶春, 隆望金融资讯, 高剑松, 黄蓉,1,1905电影网,199IT,199IT网,2026互联网温控器,21CN科技,21世纪经济报道,21世纪经济研究院,360,360企业安全,360搜索,36k,36kr,36大数据,36氪,36氪的朋友们,36氪研究院,36氪译,3W互联网深度精选,50KM,510CTO,51Callcenter,51CTO,51CTO系统频道,99艺术网,:微信公众号大数据杂谈,@人月神话 ,a1,a2,a3,a4,A5站长网,aaaa,Abby,AC汽车,Adam,Adweek,aiko,AItists,Alan,Albert,alexy,Aliyun,Amber,Andrew Oliver,Areg Alimian,Bank资管,BBC英伦网,bcbc,BDT,BDT大数据,Bernard Marr,Bill Maris,Bill?Franks,bioger_hit,bjemay,BLUES,BONC一路有你,BOSS直聘,boxi ,Brian Fung,Bruce,Bruce Lee,BuzzFeed,c114中国通信网,Cashcow,Cat,CBSi中国·PChome ,CCTIME飞象网,CDA数据分析师 ,Charlotte77,Christine,CIO时代网,Cloudera,cnBeta,CPDA数据分析天地,CSDN,D1net,Damian Radcliffe,Dan Hill,DANIEL SMYTH ,datacamp,DataCastle,Dataconomy,DataEye,DataHub,David,David A. Teich  ,David Loshin ,DavidZh,dd ,Desmond Yao,DMRC,DOIT,Dominic Frisby,DoNews,DT财经,e-works    ,Eastland,Ed Jones ,Edvaldo Acir,eMarketer,EMC易安信中国技术社区,EmmaCare,eNet&Ciweek,eNet硅谷动力,Engadget中国版,Ethinkbi,Evaad_PMG,Evangelos Simoudis,Excel数据分析,e成行业透视,e行网,Federico Pascual,fefe,FellowData,fff,FinPlus,Fison ,Freebuf,FreeS Fund,Galen Gruman,GeekCar,GJSAY光晶说,Grace,GrowingIO ,Harris,Harris编译,Harry Zhu,Heather Clancy,hello大数据,Hero,HPE,ibfiner,IBM大数据与分析,IDC,IDC中国,IMYG,InfoQ ,InfoQ中文站,ING,IT168,it168网站,ITBear	,ITbear,ITValue,IT专家网,IT世界经理网,IT之家,IT商业新闻网,IT数码科技,IT时代周刊,IT时报,IT经理世界,IT经理世界网,i天下网商,i黑马,Jack Vaughan,James Smith,JasonDing1354,javaniuniu,Jean,Jeo Gershenson,Jeremy Stanley,JESSE DUNIETZ,jiago王,Jiezhong Qiu, Yixuan Li,jinyounan,JL206,Joyce,Justin,JustMiest ,Kat McGowan,Kate,Kathleen Chaykowski,Kathy,Kathy D. Miller,KDNuggets,Keith Collins,Kenneth Cukier ,Kesci数据实践,KEVIN SAFFORD,kinderman,kwekwe,Kyligence,LEOMASTER,Linux,Lucien,Manu Jeevan,Mark van Rijmenam,Matt Asay,Matt Mi,MBA智库,mcvoodoo,Megan Scudellari,mifeng,mifeng jinyounan,MooTtaro,Mr张,Mtime时光网 ,nana,Nate Silver,NATHAN YAU ,Neo,NERD微刊 ,NewSeed,Newshoo,Nick Ilyadis,Nirmal Govind,Not_GOD,O2O商学院,O2O风云,Ofri Cohen,OFweek 工控网,OFweek 智能家居网,ofweeks智能电网,OFweek光电新闻网,OFweek工控网,OFweek物联网,Optimus Prime,OurJS社区,Pamela Pavliscak,Patrick Clar,PCHOME,PConline,pengruiqiang,pengyao ,Peter Diamandis,PingWest,pinjue,PPV课,Rain Embuscado,Raj Sabhlok,Rebecca Lemov,Ritesh Gupta,Robert Chang,Roger Dooley,Russ Juskalian,Russell Chun,Ryan Francis,Ryan Kh,SankeiBiz,Sapphire,SAS中文论坛,Seth Archer,Shan Yang Matt Mi,Shant Hovsepian,shanyang,sherry,Shraddha Tewari,shuju.net,shuqi,Shuyue Xiao,Siva Kumar ,Sophia,sports观察,Stanfordlawreview,Stephen Brobst,Stephen Nichols,Stuart Franke,sunshine,sykee,TalkingData,TC野兽,Technews科技新报,TechTarget商务智能,TechWeb,TechWeb.com.cn,Teradata,Terry Meng,Thomas Yap,TMT资本论,TOMsInsight ,TOM新闻,TopMarketing,TOPYS网站,TT中国,uedc,UI中国,UPS应用,Viktor,viviennetsi,wang,wbrecom,William Alden,William Arkin ,Xiaoyu Ma ,Xtecher,Yanir Seroussi,yaphet,Yesky天极新闻,yilia,ym,YOTOVR,yuanye,Yuki,ZDNet,ZD至顶网,zhang,Zoe,|刘季辰,?吕波,《中国连锁》杂志,《朝向白皮书》,一勺言,一哥论股,一本,一笑,一财,一财网,一起大数据,一鸣网,丁俊发,丁壮,丁常彦,丁昕昕,丁磊,丁道师,丁雪,万维家电网,万维钢,万联网,万里,万钧,三千客智能餐饮,上方网,上海汽车报,上海法治报 ,上海海事局,上海热线,上海证券报,与数据同行,丑灿,东东,东东侠,东北新闻网,东北网,东南网,东方亦落,东方早报,东方网,东湖大数据,东湖大数据交易中心,东莞平安产险,东莞日报,个,个推,中保协培训中心博客,中保网,中关村在线,中关村大数据联盟,中关村老李,中华地板网 ,中华橱柜网,中华网,中华网投资,中原网,中原网资讯频道,中商情报网,中国IDC圈,中国LED在线,中国交通新闻网  ,中国产业信息网,中国产业发展研究网,中国企业家杂志,中国企业家网,中国企业报,中国企业新闻网,中国保险报,中国信息产业网,中国信息化百人会,中国信息安全,中国信息报,中国军网-中国国防报,中国台州网,中国商业电讯,中国商网综合,中国大数据 ,中国天气网,中国娱乐网,中国安防展览网,中国家电网,中国广播网,中国技术市场报,中国投资咨询网,中国报告大厅,中国政府网,中国教育信息化在线,中国教育信息化网,中国教育报,中国教育网络,中国数据架构师联盟,中国文明网,中国新闻网,中国旅游信息网,中国旅游新闻网,中国日报中文网 ,中国日报网,中国智能制造网,中国服饰,中国机床商务网,中国江苏网,中国汽车消费网,中国消费者报,中国消防在线,中国物流技术协会,中国物联网,中国环保在线,中国环境报,中国电子报,中国电子银行网 ,中国百科网,中国硅藻泥网,中国社会科学网,中国科技网,中国经济周刊,中国经济新闻网,中国经济网,中国统计网,中国网,中国网　,中国航空新闻网,中国节能服务网,中国警察网,中国证券报,中国证券网,中国质量万里行,中国资本证券网,中国软件网 ,中国软件资讯网,中国重阳网,中国金融信息网,中国青年报	,中国青年报,中国青年新闻网,中国青年网,中国食品报,中央纪委监察部网站,中安在线,中山商报,中山日报,中工网,中文科技资讯,中新网,中江网,中科曙光,中证网,中评信用,中金在线,中金网,中青在线,临空都市报,乐思舆情,乐智网,九枝兰,九次方大数据,九正建材网,书聿,二水水,二牛网,于丁一,于丁一  林仁翔,于军,于哲,于德良,于揚,于斌,于施洋,于江艳,于波,于泳,于洋,于秋涛,于达维,于雪,云何数据,云南信息报,云南网,云头条,云山,云栖团队博客,云栖社区,云科技时代,云篆,互动未来,互联天地,互联快谈,互联网,互联网分析师,互联网分析沙龙,互联网数据中心,互联网金融,井江南,井贤栋,亘古,亚信大数据,亚太日报,交通广告观察,交通运输科技网,产品中国,亨利,京华时报,人人在线,人人征信,人人都是产品经理,人工智能学家,人工智能实验室,人工智能家,人民出版社,人民政协报,人民日报,人民日报海外版,人民法院报,人民网,人民邮电报,人称T客,亿欧传媒,亿欧网,亿邦动力网,仇飞,今传媒,今日头条,今日早报,今日热点,付宇骄,付秋实,仙伟,以太创业专栏,任大刚,任天,任新勃,任栋霓,任栋霓/何明科,任翀,任翔,任芬,任道远,任鑫琦,企业新榜 ,企业网,企业网D1Net,企鹅智库,企鹅智酷,伊万,伊晓霞,伍伟烨,优步,传媒中国,佐罗的马,体坛网,何双宇,何强,何明科,何春梅,何欣荣,何氏佬,何生水,何秀超,何艳,何霞,何鸿凌,佘振芳 杨正东,余代军,余俊越,余凯,余山,余文,余晓洁,余涌,余然,余胜良,佚名,佳辉,依马狮视听传媒,侠天,侯宏,俊世太保 ,俞士纶,俞熔,俞胜法,信娜,信息时报,信海光,信雪蕊,候知健,倪凯,倪雨晴,傅一平,傅志华,傅海波,傅盛,储芸,元略,光明日报,光明网 ,克里斯唐,全媒派,全景网,全浩,全球深度报道网,全球移动搜索,公子义,兰媒,关健,关杰,关欣 ,兴手付,内蒙古旅游网,冬冬,冯一村,冯仕政,冯伟,冯健蓉,冯可,冯是聪,冯永昌 石岩,冯贞远,冯辰,冯颖,冷翠华,凌雯佳,凤凰天津,凤凰娱乐,凤凰房产,凤凰文娱,凤凰汽车,凤凰科技,凤凰网,凤凰资讯,凤凰青岛 ,凯文·凯利,凯蒂阿,刁兴玲,刁明康,刘世平,刘东庚,刘东畅,刘丽,刘义杰,刘书成,刘云,刘亚力,刘亚澜,刘佳,刘俊彦,刘占亮,刘奇,刘子阳,刘季辰,刘宇,刘定洲,刘宝兴,刘尚君,刘建伟,刘建坤,刘建秋 黄佳,刘彦  ,刘德寰,刘德明,刘志军,刘志刚,刘志强,刘志浩,刘怡,刘成,刘文静,刘新,刘旭坤,刘旷,刘昌,刘晓,刘晓璐,刘晓葵 ,刘晶晶,刘松,刘海新,刘涌,刘炀,刘然,刘玉先 ,刘瑶,刘璨,刘疆,刘睿民,刘磊,刘祎,刘禹,刘策,刘维 ,刘羽 赵丹 付雨涵,刘羽飞,刘育英,刘芸,刘英涛,刘译璟,刘赞,刘辉,刘远举 ,刘金洋,刘金玲,刘锋,刘锡芸,刘阳,刘雅菲,刘飞,刘鹏,刘黎春,刚子,创世纪,创业网,创业邦,创业邦杂志,创头条,创客,创投时报,创见,初夏,利求同,前瞻网,动脉网,劳动报,勤智大数据,勤智数码,包雨朦,化学数据联盟,北京保险行业协会,北京商报,北京日报,北京晚报,北京晨报,北京热线 ,北京青年报,北冥乘海生,北国骑士,北青网,北风网,医信天下,医药经济报,医谷网,千家智客,千家网,千里码在线,千龙网,半岛网,华侨金融,华凌科技,华商报,华商网 ,华坤道威,华夏经纬网,华安证券,华尔街见闻,华炜,华西都市报,华通社,华鹏飞,华龙网,卓泳,单凯,南京日报,南充日报,南国都市报,南希,南方企业新闻网,南方周末,南方日报,南方网　,南淄博,南都周刊,博客,博客园精华区 ,博客虫,博鳌E聚焦,卜晓军,卞小燕,卢云龙,卢亿雷,卢佳静,卢吉平,卢哲群,卢扬 ,卢晓明,卢杉,卢杰,卢松松博客,卢永春,卢真伟,卢萌卿,卢谊,卢迪,厉苒苒,原野 ,厦门地产资讯mp,厦门网,去哪儿网,友盟+,友盟数据运营舍,变革家,史中·方枪枪,史建伟,史建华,史琳,叶俊杰,叶健,叶凝碧,叶晨,叶欣,叶永茵,叶谦,合肥在线,吉永宏,吉燕勇,同花顺,同花顺爱基金,向密,向雨航,吕佳辉	,吕佳辉,吕晖,君小田,吴仲毓,吴兰岸,吴军 ,吴凯,吴刚,吴劲珉,吴喜之,吴大迪,吴宁川,吴干沙,吴志强,吴恩达,吴文雄,吴斌,吴明辉,吴晓军,吴晓灵,吴智军,吴柳锋,吴海飞 ,吴炯,吴玉征,吴琳,吴甘沙,吴秋余,吴立,吴绵强,吴萌,吴雨欣,周 樑,周丽君,周丽梅,周亮,周健工,周像金,周冰,周发玲,周呈思,周均,周天,周奕  ,周学春,周密,周建丁,周建明,周强,周彦伟,周慧,周文吉,周旭妍,周晋,周民,周涛,周润健,周灏,周琳,周程程,周航,周芳明,周铭,周锐,周麟,和晋予,和讯,和讯网,品觉,哈佛商业评论,哈昊天,唐军,唐岳岚,唐德权,唐心萌,唐悦芝,唐棣,唐沰,唐福勇,唐福林,唐蒂姆,唐逸如,商业价值杂志,商业伙伴,商业智能在线,商业智能行业资讯,商业电讯,商企网,商灏 ,商登 ,商都网,喻华锋,喻思娈,嘉兴在线新闻网,嘎嘣脆脆 ,四川CDA数据分析师,四川在线-华西都市报,四海网,国统大数据,国脉研究院,国际出版周刊,国际品牌网,地产中国网,均昱,埃里克·施密特,城市战争,城市数据团,士小文,壹科技,夏丹,夏丽莎,夏健钊,夏勇,夏嘉雯,夏妍,夏妍娜,夏平,夏文祥,夏旭田,夏良炜,外汇网,外芯房,多商网,多渠道零售商杂志,多玩,大卫?沙曼 ,大圣众包,大愚若智,大数据,大数据mp,大数据头条号,大数据徽察,大数据文摘,大数据杂谈,大数据联,大数据观察,大数据邦,大数据风控圈,大数网,大智慧财经,大比特,大比特资讯,大河报,大河网,大洋网,大海洋数据,大神出没,大禹,大讲台科技,天下数据IDC,天下金融网,天会智数,天会智数施晟 ,天善智能社区用户xjh_buaa,天小妹,天津日报,天涯,太傻留学,太平洋汽车网,太平洋电脑网,央广网,央视新闻 ,央视网,央视财经,奕纯,奥一网,奥玛,好奇心日报,姚传富,姚军,姚海棠,姚煦,姚玉洁,姜伯静,姜姝艺,姜晓萌,姜永靖,娄底新闻网,媒介之变,子月,孔令晖,孔淼,孔飞,存储在线,孙中杰,孙冰,孙园,孙媛 ,孙宇熙,孙宏超,孙建军,孙惠楠,孙明玉,孙杰,孙毅,孙炎,孙玉亮,孙琳,孙瑞,孙英兰,孙镜涛,孙骋,孙鲲鹏,孙鸥梦,孟凡明,孟凡霞,孟凯俊,孟德说,孟政权,孟环,孟良,宁川,宁飞虹,宇多田,安东尼,安妮,安安,安宏,安忍,安然,安防展览网,安防知识网,安雅·兰博瑞,安鹏旭,宋斐,宋星,宋杰,宋洪涛,宋炜,宋王群,宋雅娟,宗弘,实验帮,宣晓华,家电圈,家电联盟网站,宿思,宿痕,察网,对的,封雷,小刘说汽车,小峰,小强,小湿妹,小白鹿@aliued,小石头,小石头 · 石亚琼,小码哥,小胖,小菜 ,小趣说,小金,小饭桌,小鱼,尚吉刚,尚超,尹博,尹子璇,尹相志,尹辅华,尼尔森,尼尔森大学,屈丽丽,屏芯科技,属于,山世光,山东广播电视台农科频道,山西农民报,山西新闻网,山西晚报,岳家琛 ,岳红梅,崔国强,崔宝秋,崔晓波,崔月,崔江见,崔秋,嵇石,工控中国,左永刚,左磊,巨灵信息 ,巫天华,巴曙松,巴比特,布加迪,布加迪编译,布拉德皮蛋,常先生不靠谱,常孟天,常言,广告主杂志,广告主网,广告门,庄传礼,康文,康迪,廉昕朦,廖志慧 吴睿 张照龙,廖秉宜,开运联合,异步社区,张CC,张一然,张丹峰,张丽华,张亚勤,张京,张从艳,张伟,张佳昺,张侠,张俊,张健,张军杰,张凤,张利荣,张勇,张华强,张可,张叶,张圣,张妮娜 ,张宁,张宇婷,张宇鑫,张守营,张家伟,张小彦,张小沛 ,张岚,张峩宁,张峰,张帆,张帜,张建新,张建锋,张弓,张弦,张志强,张怡辰 ,张恒,张悠,张悦,张惊,张成锁,张旭阳,张春元,张晓军,张晖明,张晨,张晶,张曼,张林成,张桔,张楠 PT012,张榕博,张歌,张毅,张淇,张清俐,张溪梦,张灏,张牧扬,张猛猛,张玉宏,张玮,张珊珊,张琪,张琳,张璐瑶,张田勘,张申竣,张相於,张磊,张礼立,张秀云,张立,张立静 ,张素,张翼轸,张聪,张良贵,张艳飞,张艳飞 yilia,张艳飞 张叶,张艳飞 春夏,张芷然,张苗苗,张茉楠,张莉,张蕾,张辉,张适时,张邦鑫,张钟文,张钦,张锐,张阔,张青松,张韵,张骏,张高,张高峰,张鸿文,张鹏 ,强说,彭婷,彭小萍 实习生 朱庆凡 柳王敏,彭承天,彭旭蕾,彭智宇,彭科峰,彭雅惠,彭飞,徐丽莉,徐丽莉 刘晶,徐倩影,徐宁,徐宗本,徐征,徐徐,徐恒,徐昊,徐晓风,徐晶卉,徐晶慧,徐杰,徐海涛,徐炜,徐瑞哲,徐璐,徐若凡,徐若瀛,微头条,微山信息港,快科技,怀进鹏,思达派,思雨,思高人才管理,慕容随风,慧聪安防网,慧聪汽车电子网,慧聪网,戈登·里奥斯,戎飞腾,成功营销,成都商报,我是二姐夫,戴一鸣,戴文渊,戴春晨,戴琨,戴金权,房树新,房观察,房讯网,手机中国,托马斯 ,扬子晚报,扬子晚报网,扬州晚报,承哲,承德日报,投资中国,投资快报,投资潮,投资界,拙牧,招商证券,拯迪,挖贝网,掌柜攻略  ,探索与争鸣杂志,推酷,提琴没有弦 ,搜狐,搜狐IT,搜狐体育,搜狐娱乐 ,搜狐教育,搜狐时尚 ,搜狐汽车,搜狐理财,搜狐科技,搜狐网,搜狗,携程,数太奇,数娱梦工厂,数学中国,数局,数据分析,数据分析与数据可视化,数据分析侠,数据分析精选,数据分析网,数据吧,数据域,数据客,数据挖掘DW,数据挖掘与可视化,数据派,数据海洋 ,数据猿,数据猿数据猿,数据科学自媒体,数据观,数据观综合,数据观综合　,数梦工场,数盟,数盟社区,数英网,数说故事,数邦客,文汇报,文辉,文都教育,斑马传媒,斑马网,新三板在线,新东方在线,新京报,新北青网,新华报业网 ,新华每日电讯,新华社,新华社　,新华网,新华网事,新媒体指数,新快报,新智元,新民周刊,新浪,新浪体育,新浪博客,新浪娱乐,新浪家居,新浪广东,新浪教育,新浪时尚,新浪汽车,新浪科技,新浪网,新浪财经,新科技,新蓝网综合,新闻晨报,方发和,方毅,方滨兴,施志军,施捷,施水才,旅游商业观察,旅游圈,无我莽莽,无锡日报,日本爱好者社区,日经中文网,时代周报,时光收割者 ,时尚大编辑,时趣数据,旷世之美,明略数据,易宝,易水寒风 ,易观国际,易观智库 ,易车,易车自媒体,易达大数据,易鑫资本汽车观察,星座密语宝典,星环科技,映象网,春夏,春晚官网,是,晋江经济报,晓星,晓桦,晓迪,晗冰,晨曦,智勇,智汇互联,智能互联,曹乘瑜,曹增光,曹素妨 ,曾凤,曾嘉,曾小苏,曾杨希,曾毅,曾洁 罗文,曾福斌,曾良,曾艳,最高人民法院,有数,朋新宇,朝阳35处,木千之,木淼鑫,本城,朱东华,朱丽娜,朱俏俏,朱劲松,朱坤怡,朱思远,朱扬勇,朱晓磊,朱晓露,朱景士,朱朋博 ,朱桂林linn ,朱正元,朱玲巧,朱珠,朱筱珊,朱萍,朱赟,朱雪娜,朱青山 ,朱顺炎,朱鸿菊,机器之心,机房360,杂字思维 ,李中迪,李丰,李丹妮,李丽花,李从武,李代丽 ,李伟,李佳师,李倩薇,李光斗,李兮言,李力,李劼,李勤,李北辰,李华东,李华芳,李博源     ,李向东,李呈祥,李嘉薇,李国庆,李国杰,李圆园,李大光,李大副,李天伦 ,李娟,李婷婷,李宝民,李峥巍,李峥巍 阳娜,李崇纲,李师荀  王帝,李庆实 ,李廷威,李建发,李建红,李建荣,李开复,李强,李彦宏,李德毅,李思,李思萌,李想,李慧敏,李扬,李振军,李政,李文哲,李文杰,李斌,李新玲,李旭阳,李昕彧,李春惠,李显红,李晓萍,李晨 ,李智,李杨慈 ,李杰,李柏杉,李根,李楠  ,李正海,李正茂,李永辉,李洋,李洪涛,李海花,李淼,李然,李燕,李玉,李玥,李琪,李致,李致鸿,李芳,李英楠,李英睿,李荣敏,李萌,李蓉敏,李贝,李超,李钊,李铁,李铎,李长春,李闻,李鹃,李鹏涛,李麒,杏仁,村夫日记,杜 芳,杜仲,杜吉成,杜小芳,杜昌营,杜晓,杜晓梦,杜暮雨,杜梦雅,杜王丹,杨丰源,杨佳峰,杨冰之,杨凯生,杨剑勇,杨君,杨学山,杨小小,杨帆,杨强,杨志芳,杨斌,杨斯阳,杨昀,杨昊东,杨昌鼎,杨映南,杨林国,杨海艳,杨溢,杨溢欣,杨现民 ,杨皓钧,杨盈丰,杨禹璋,杨茜,杨菲菲,杨频萍,杨鲲鹏,杭州大家在线,杭州网,杰西卡·格拉夫,极光数据研究院容子,极客,极客头条,极客网,构筑空间文化传媒,林云箫编译,林仁翔 ,林克艾普大数据,林坦,林奇,林子人,林广,林念修,林成栋,林永华,林永颂,林洪演,林灿辉,林萍,林西,林领,林龙勇,果壳网,查翌,柳超,柳青,柴华,柴可,柴宗盛,栗中西 ,校长派,核子可乐,核子可乐译,栾静 张守帅,桑文锋,梁堰波,梁婧,梁杰民,梁梦晚,梁波,梁爽,梁释贤,梁铭图,梅宏,梅花网,梅菀,检察日报,检验医学网,楚飞,樊华,樊建勋,樊明太,檀润洋,欢迎辞,欧电云,欧界传媒,欧界科技,欧阳潇,欧阳澄,欧阳辰,欧鲁男,正保IT教育网,武汉东湖大数据,武汉链家网,段云峰,段培力,段威,段婷婷,段小缨,段筠,段续,段续 刘怀丕,段莹,殷佩琴,殷呈悦,殷建,殷旻哲,殷聪,殷雨婷,每日经济新闻,比特网,毕淑敏,毕然,毛一竹,毛丽娟,毛俊,毛大庆,毛小北,毛渝南,民政微语,民航数据控,民航资源网,水命,水晶球财经网,水母网  ,水水,水滴,永洪BI,汇海电商淘宝托管代运营,汇通网,江南子,江天,江少华,江旋,江晓东,江永青,江瀚,江秀臣,江苏科技报,江青,江颖,汤人杰,汤兴,汤垒,汤开智,汤晓鸥,汪勇专,汪德嘉,汪志球,汪晓宇,汪榕,汪超,汽扯扒谈,汽车产经网,汽车作业精选,汽车头条APP,汽车服务世界,沃保网,沃普惠,沈丽琼,沈劲,沈华林,沈南鹏,沈大雷,沈小根,沈小雪,沈建缘,沈文敏,沈昌祥,沈烁,沈璐佳,沈立勤,沈艳,沈钊伟,沈阳,沙志友,沙璐,河北分站,河北广播网,河南日报,河沟边 ,法信,法制晚报,法制网,法治周末,泡沫,泡泡网,泾渭科技,洁颖,洛阳旅游网,洪偌馨,洪延青 何延哲,洪涛,济南时报,浙商传媒,浙江在线,浙江晚报,浙江省商务厅,浙江质监微信,浮生,海中天,海云数据,海云数据可视化,海南日报,海外网,海量大数据实践,海量数读,涂子沛,涂子沛频道,消费日报,消费日报网,涵云,淘宝网,淘店家网店交易平台,深几度,深圳新闻网,深圳特区报,深度学习世界,淼淼Lana,清科私募通 ,温州都市报,温泉,温静,游天龙,游戏行业观察,湖北省审计厅,源乐财经,滴滴,滴答网,漆远,潘争,潘启铜,潘婷婷,潘少颖,潘永花,潘璠,潘英丽,澎湃新闻,澎湃新闻网,火少书生 ,灯塔大数据,烁航,热巢网,热情的沙漠,烽火普天,焦点成都站,煎蛋,熊丙奇,熊大梦,熊浩然,爱奇艺,爱范儿,牛建平,牛悦,牛福莲,牛肉圆粉不加葱,牛金霞,牧晨 ,物流技术与应用,物流沙龙,物联中国,物联商业网,物联网,物联网智库,特大号,犀小牛公会,猎云网,猎头老王,猎聘网,猫大叔,玄隐,王 怡,王一,王一栋,王乐乐 ,王云辉,王亮,王付娇,王伟,王伟玲,王传涛,王冠,王冠雄,王卉,王华,王卡卡,王叁寿,王吉伟,王喜文,王嘉,王国信,王圣捷,王坚,王域西,王培,王如晨,王姝睿,王威,王婧,王婷,王婷婷,王学良,王宇鹏,王小嫱,王小宁,王平,王彦博,王念兹,王思洋,王恩东,王恩国,王成,王成军,王振辉,王攀,王文京,王新喜,王新明,王旭,王昊男,王春晖,王昭懿,王昱祺,王晓峰,王晓易,王晓洁,王晓然,王林,王桐,王楠,王楷,王欢,王永利,王汉生,王沛栋,王洪添,王洪艳,王浩 ,王海婷,王涛,王满凤,王满华,王烨,王牧青 ,王玉,王玉珏,王珂,王琛,王琪,王琼,王瑞,王璐瑶,王皇,王真震,王磊,王红,王纳,王绪刚,王聃,王聪彬,王艺多,王艺琳,王艺锭,王芳,王英,王荣,王莹,王萌,王蔚,王蕾,王融,王詠,王诗侠,王轩,王辉,王迅,王通讯,王金宝,王钦,王铭,王锋,王长田,王长胜,王雨思,王雪燕,王雪红,王静宇,王鹏,王鹏宇,环保产业网,环球人力资源智库,环球旅讯,环球标识网,环球科技,环球网,现代快报,珍岛,珍岛集团,生物探索网,生物谷,田丰,田小雪,田忠,田文杰,田日辉,田晓旭,田溯宁,田牧,田英雷,申卉,申波,申翔宇,申耀的科技观察,电商卖家公众号,电商在线,电子产品世界,界网,界面,界面新闻,界面网,留学微报,瘦弱的小瑞,白丽媛,白冬立,白剑波,白明,白杨树,白硕,百分点,百年英才高考志愿管家,百度乐居,百度大数据,百度新闻实验室,百度百家,百度知道日报,百晓僧,百融金服,百顺,皓岳,皓慧,皮擦擦,盖瑞,盛利,相欣,睿商在线 ,瞿淼,知乎,知乎日报,知识产权顾问,石一瑛,石慧,石现升,石章强,石贝贝,研客A股,硅星闻,硅谷 ,磐石之心,社会创业家,祁豆豆,祝伟,祝威廉,祝少卿,福小伟,福布斯,福布斯中文网,福建日报,福建法治报,禹唐体育,种昂,种骥科,科再奇,科多大数据,科技传媒网,科技大力哥,科技情报堂,科技日报,科技蟹,科技讯,科技部官网,秦致,秦陇纪DataSimp,秦雯,秦风,移动互联网,程学旗,程拓,程杰,程端前,程维,程荣,穆胜,窦勇,站长之家,章丰,章婧,章宁旦,章胜,童俊,笑死个喵,笑死个猫,第一财经,第一财经周刊,第一财经商业数据中心,第一财经日报,第一财经理财,第一财经网站,第五春秋,简书,简工博,管伟,米律,精益创业分析,紫数网,紫萧,红达,纪俨玲,纪平,纪秉盟,纪缘圆,纷纷,纽带线CRM,经济参考报,经济参考网,经济日报,经济观察报,经理人分享,经纬中国,结实,维克托迈尔·舍恩伯格,维金,编译张迪,缪定纯,网易,网易体育,网易娱乐,网易教育频道综合,网易新闻学院,网易汽车,网易科技,网易科技报道,网易网站,网易考拉海淘,网易财经,网络大数据,网贷之家,网通社,罗争光,罗云霄,罗伯特,罗克佳华,罗勇,罗文,罗曼罗,罗超,羊城晚报,美团技术博客,美团点评技术团队,美通社,翁志 ,翔snowman,翟建华,翟慎良,老凉,老扎,老聃,老胡说科技,老蒋书房,老读悟,老铁,考拉,耿如依,聂乃知,聂华,联动i访谈,联商网,联商资讯,肖倩,肖悠頔,肖文峰,肖明超趋势观察,肖楹楹,肖锋 ,肖阳,肖雪,育灵童,肽度时界,胡亚平,胡佩霞,胡俭美,胡凌,胡勇,胡嘉琪,胡娅囡,胡彦殊,胡敏,胡春艳,胡晓明,胡浩,胡璇子,胡糊,胡菁菁,胡虹,胡诗怡,胡郁,胡锐,胶东在线,能源大咖,能源大咖微信公众号,腓特烈评论,腾讯体育,腾讯儿童,腾讯太空,腾讯数码,腾讯新闻,腾讯游戏,腾讯科技,腾讯网,自主汽车,至顶网 ,舍恩伯格,舒圣祥,舒鹏,艺恩咨询,艺龙网,艾媒咨询,艾媒网,艾小缤,艾樊,艾瑞咨询,艾瑞网,艾肯家电网,芝诺数据分析,芥末堆 ,芥末堆网,花满楼,苏令,苏俊杰,苏向杲,苏国穗 邵生余,苏墨,苏娅,苏季,苏宁云商商业评论,苏州日报,苏忆,苏慧婷,苏永刚,苏江元,苏萌,苗圩,苟蛟龙,苹果官网,范为,范兴龙,范承工,范文艳_NQ5148,范晓,范晓忻,范晶,范济安,范芊芸,范蓉,范长煜,茅明睿,荆楚网,莫天全,莱芜新闻网,菇凉,菜鸟不菜,葛利鹏,葛育民,葡萄酒第一媒体 ,董兴生,董晓静,董晨,董玲,董老师,董莉,董雨晴,董飞,蒋佩芳,蒋勇,蒋卫东,蒋波,蒋涛,蒋烁淼,蒋琪,蓝鲸TMT,蓝鲸TMT网,蔡妙娴,蔡弘,蔡怡然,蔡明 张欣亮,蔡明 袁凯,蔡跃洲,薛又轩 ,薛家明,薛帅,薛洪言,薛皎,薛菲,藏瑾,虎嗅,虎嗅网,虞伟,虫二,融360,融创智酷,融都科技,袁云儿,袁仁国,袁先智,袁园,袁浔杰,袁璐,袁纯子,袁蓉君,袁道唯,西奥马尔,西奥马尔编辑,西恩·卡拉格,覃超,观察界,观察者,观察者网,解放日报　,言灵均,詹丽华 ,詹志明,许凌,许志松,许磊,许阳,证券之星,证券日报,证券时报,证券时报网,试试,诚琛移民,诸葛io,调研宝,谈书,谈谈科技TanTan,谢丽,谢军,谢劼,谢希语,谢欣,谢江林,谢然,谢玲,谢磊,谢秉强,谢辉,谭书婧,谭浩俊,谭燃,谭程,谷熠,豆瓣,财富中文网,财界网,财经国家新闻网 ,财经故事会,财经时报,财经网,财视传媒,贱小花,贵州人才信息网,贵州日报,贵州都市报,贵阳大数据交易所,贵阳日报,贵阳网,费天元,费颖,贺涛,贺骏,贾兴鹏,贾凤军,贾凯强,贾欣,赖正 ,赛迪智库,赛迪研究院,赛迪网,赛迪顾问,赢商网,赵一鸣,赵一鸿,赵东山,赵丹,赵光,赵军,赵国栋,赵娜,赵小燕,赵岗,赵广立,赵建良,赵张冬,赵强,赵征南,赵心源,赵恩泽,赵慧玲,赵新乐,赵晓辉,赵柯,赵武,赵泽红,赵琳,赵福君,赵艳秋　,赵邑新,赵长林,赵鹤 ,赵龙,趣味科技,路人甲,路北,车业杂谈,车丽,车云网,车品觉,车品觉编译,车秘,车质网,转化医学网,软件定义世界,软王科技,软通动力,辰智大数据,辽一网,达观数据 ,达达,迈克尔·费蒂克,运营喵是怎样炼成的,连玉明,通信世界网,通信信息报,通信大数据分析及应用,速途网,道普网,邓丽婧,邓力,邓宇,邓庆旭,邓晖,邓松武 ,邓锋,邓雪媛,邓雪嫒,邢婷婷,邢志峰,邬煜,邬贺铨,邱伟,邱坤东,邱寒,邱志勇,邱智丽,邵俊明,邵宇豪,邵海鹏,邵鲁文,邹东生,邹宗根,邹晶,邹晶 赵张冬,郄勇志,郄小虎,郎清平,郑伊琛,郑军,郑凯,郑南宁,郑宇,郑峻,郑州日报,郑文丰,郑洁,郑砚农,郑雨林,郝多,郝孟佳,郝少颖,郝欣诚,郭乃网,郭光东,郭全中,郭冬冬,郭华东,郭娟,郭宇靖,郭少雅,郭敬丹,郭文亮,郭新志,郭晓昊,郭炜,郭璐庆,郭立伟,郭继军,郭菲,郭雨萌,郭静,鄂尔多斯日报,鄂维南,鄢光哲,酒窝angel,酥酥,里瑟琦智库,重庆晚报,野马财经,金十数据 ,金又南,金易子,金棕榈咨询,金榕,金毛毛,金永辉,金电智诚,金电联行,金羊网,金色人生财经频道,金融投资智库,金融时报,金融界,金融界网站,金言,金评媒,金豆子,金鑫,金错刀,金陵晚报,钛媒体,钟云岚,钟云飞,钟华,钟超 ,钢钢,钱卓群,钱报网,钱江晚报,钱皓,钱皓-互联网分析师,钱粮胡同,银昕,链家网,销售与市场,锤哥,镡立勇,长江网,长益科技,闫志坤,闫昊,闫浩,闫瑾,闫盖,闲看云起,闵万里,闹客邦,闻澜,阑夕,阮嘉俊,阿博,阿尔法汪,阿拉丁新闻中心 ,阿童木,阿里数据,阿里研究院,陆一夫,陆志霖,陆文斌,陈丹奕,陈从容,陈佐一,陈刚,陈利,陈劲,陈华,陈圆圆,陈天弋,陈媛媛,陈宝亮,陈庆翔 ,陈应勇 ,陈志刚,陈思颖,陈新河,陈新涛,陈明,陈晨,陈晶晶,陈根,陈梦凡,陈梦姣,陈永东,陈洁,陈洪钰,陈润生,陈烨,陈玲波,陈琦,陈瑶,陈璐,陈生强,陈磊,陈第,陈肇雄,陈航,陈苏,陈莹莹,陈薇,陈言,陈超,陈运文,陈键 易潇,陈阳,陈静,陈鲸,陈鹏飞,陈龙,陶力,陶然,陶黎纳,隗建华,雁行,雅虎体育,集奥聚合GEO,雨果网,雪晴数据网,雪樱,零壹财经,雷建平,雷志斌,雷锋网,雷锋网 　,霍文静,青报网综合,青砚,韦屈,韦陀一杵,韦青,韦骅,韩义雷,韩亚栋,韩亦舜,韩依民,韩元佳,韩向明,韩小伟,韩永刚,韩洁 ,韩湘子,项峥,顾一琼,顾嘉,顾晨炜,顾涯文,顾鸣,领航----资讯平台,颜强 ,风帆,飞哥,飞扬,飞象网  	,飞象网,饭团君,饶少阳 ,饶章涛,饼干君,首席媒体官,马云,马亮,马化腾,马千里,马建堂,马旗戟,马晓晴 ,马民虎,马继华,马薪婷,马超,马越,马雪健,马骏驱,驱动之家,驱动创业创新,高卫星,高同庆,高娟,高宏亮,高寒凝,高少华,高扬,高敬,高洁,高洪浩,高翔,高铎,高长宽,高颖楠,高鹏,魏凯,魏斌,魏海政,魏谦屹,魏进武,鲁四海,鲁春丛,鲁楠,鲁畅,鲍忠铁,鲜祖德,鸟哥笔记,鸢玮,鸵鸟电台,鸿智,鹿崇  ,鹿鸣,麦可思研究,麦吉尔大学,麦星,麻策,黄东旭,黄云灵,黄佳佳,黄光红,黄军,黄墩良 王荣灿,黄娴,黄婧,黄宇,黄成明,黄振杰,黄文宇,黄晓南,黄晓庆,黄欢,黄欢_NN1650,黄殿中,黄河燕,黄海英,黄涛,黄申,黄秋月,黄罡 ,黄金萍,黄锴,黄颖,黄鱼,黄鸣,黎振宇,黎斌,黎晋,黑侠,黑马良驹,齐中熙,齐丰润,齐向东,齐鲁晚报,齐鲁网,龙凯,龙娱平,龙讯财经,龚丹韵,龚才春,龚洁芸,龚进辉";
			String[] strs = str.split(",");
			int count = 1;
			for (String tr : strs) {
				//System.out.println(tr + " ------ " + getPingYin(tr));
				//System.out.println("jedis.set(\"" + getPingYin(tr) + "\",\""+ tr + "\");");
				//System.out.println(getPingYin(tr));
				pw.println("jedis.set(\"" + getPingYin(tr) + "\",\""+ tr + "\");");
				if (count % 100 == 0){
					pw.flush();
				}else{
					count++;
				}
			}
			try {
				pw.flush();
				fw.flush();
				pw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}*/
    	
    		String str = "互娱";
			String[] strs = str.split(",");
			for (String tr : strs) {
				//System.out.println(tr + " ------ " + getPingYin(tr));
				System.out.println("jedis.set(\"" + getPingYin(tr) + "\",\""+ tr + "\");");
				//System.out.println(getPingYin(tr));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    } 
	
}