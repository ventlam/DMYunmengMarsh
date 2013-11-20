package com.amap.dataplatform.bi.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PBID2MatrixIndex {

	/**
	 * @param args
	 */
	
	private static List<String> verl 	  =  new ArrayList<String>();
	private static Map<String,String[]> verm = new HashMap<String,String[]>();	
	
	public static void initMap()
	{
		String[] ios600Arr = {"000000","000001","000002","000003","000004","000005","000006","000007","000008","000009","000010","000011","000012","000013","000014","000015","000016","000017","000018","000019","000020","000021","000100","000101","000102","000200","000201","000202","000203","000204","000205","000206","000207","000208","000209","000210","000211","000212","000213","000214","000215","000216","000217","000300","000301","000303","000304","000305","000306","000307","000308","000309","000310","000400","000401","000500","000501","000503","000504","000505","000506","000507","000508","000509","000510","000600","000601","000700","000701","000703","000704","000705","000706","000707","000708","000709","000710","000800","000801","000802","000900","000901","000902","000903","000904","000905","000906","000907","000908","000909","000910","000911","000912","000913","000914","000915","000916","000917","001000","001001","001002","001003","001004","001005","001006","001007","001008","001009","001010","001011","001100","001101","001102","001103","001104","001105","001106","001107","001108","001109","001110","001111","001112","001113","001114","001115","001116","001117","001118","001119","001120","001121","001122","001123","001124","001125","001126","001127","001128","001200","001201","001300","001301","001302","001303","001304","001401","001402","001403","001404","001405","001406","001500","001511","001512","001513","001514","001515","001516","001517","001518","001519","001520","001521","001522","001523","001600","001601","001700","001701","001702","001703","001704","001705","001706","001707","001708","001709","001710","001711","001712","001713","001714","001715","001716","001718","001719","001720","001721","001722","001723","001724","001725","001726","001727","001728","001729","001730","001731","001732","001800","001801","001900","001901","001902","001903","002000","002001","002002","002003","002004","002005","002006","002007","002100","002101","002102","002103","002104","002105","002106","002107","002108","002109","002110","002200","002201","002202","002203","002204","002205","002206","002300","002301","002302","002303","002304","002305","002306","002307","002308","002309","002400","002401","002402","002403","002404","002405","002406","002407","002408","002409","002500","002501","002502","002503","002504","002505","002506","002507","002600","002601","002602","002603","002604","002605","002606","002607","002608","002609","002700","002701","002702","002703","002800","002801","002900","002901","003000","003001","003002","003003","003004","003005","003006","003007","003008","003009","003010","003011","003012","003013","003014","003015","003016","003017","003018","003100","003101","003102","003103","003104","003200","003201","003202","003203","003204","003205","003206","003207","003208","003209","003210","003300","003301","003400","003401","003402","003403","003404","003405","003406","003500","003501","003502","003503","003504","003505","003600","003601","003602","003603","003604","003605","003606","003700","003701","003702","003703","003704","003705","003706","003800","003801","003802","003900","003901","003902","003903","003904","003905","003906","003907","003908","003909","003910","003911","003912","004000","004001","004002","004003","004004","004100","004101","004102","004103","004200","004201","004202","004203","004204","004205","004206","004207","004208","004300","004301","004302","004400","004401","004402","004403","004404","004405","004500","004501","004502","004503","004504","004505","004506","004507","004600","004601","004602","004603","004604","004605","004606","004700","004701","004702","004801","004802","004803","004804","004805","004806","004900","004901","004902","005001","005002","005003","005004","005005","005006","005100","005101","005102","005200","005201","005202","005203","005204","005300","005301","005302","005303","005304","005305","005306","005307","005308","005309","005310","005400","005401","005402","005500","005501","005600","005601","005700","005701","005800","005801","005803","005807","005900","005901","005902","005903","005904","005905","005906","006001","006002","006003","006004","006005","006006","006100","006101","006102","006200","006201","007100","007101","007103","007104","007105","007106","007107","007108","007109","007200","007201","007202","007300","007301","007400","007401","007500","007501","007600","007601","007700","007701","007800","007801","007802","007803","007804","007805","007806","007807","007900","007901","007902","007903","008000","008001","008100","008101","008102","008103","008300","008301","008302","008303","008304","008305","008306","008307","008400","008401","008402","008403","008404","008500","008501","008502","008503","008504","008600","008601","008602","008603","008604","008605","008606","008607","008608","008609","008610","008611","008612","008613","008614","008615","008700","008701","008702","008703","008800","008801","008802","008803","008900","008901","008902","008903","008904","008905","008906","008907","009100","009101","009102","009103","009104","009105","009106","009107","009108","009200","009201","009202","009203","009204","009205","009206","009207","009208","009209","009210","009211","009212","009300","009301","009302","009303","009304","009400","009401","009402","009403","009404","009408","009409","009410","009411","009412","009413","009414","009415","009416","009417","009418","009419","009420","009500","009501","009502","009503","009600","009601","009602","009603","009700","009701","009702","009800","009801","009900","009901","009902","009903","010000","010001","010002","010003","010004","010005","010006","010100","010101","010102","010103","010104","010200","010201","010202","010203","010204","010205","010206","010207","010208","010209","010300","010301","010302","010400","010401","010500","010501","010502","010503","010504","010505","010506","010507","010508","010509","010510","010511","010600","010601","010602","010603","010604","010605","010606","010607","010608","010609","010610","010611","010612","010613","010614","010615","010616","010617","010618","010619","010620","010621","010622","200000","200100","200101","200102","200103","200104","200105","200106","200107","200108","200200","200201","200202","310100","310101","310102","310103","310104","310105","310106","310107","310200","310201","310202","310203","310204","310205","310300","310301","310302","310303","310304","310305","310400","310401","310402","310403","310404","310405","310500","310501","310600","310601","310602","310603","310604","310700","310701","310702","310703","320100","320101","320102","320103","320104","320105","320106","320107","320108","320200","320201","320202","320203","320204","320205","320300","320301","320302","320303","320304","320305","320306","320307","320308","320400","320401","320402","320500","320501","320502","320503","320504","320505","320506","400100","400200","100000","200000"};
		String[] ios530Arr = {"000000","000001","000002","000003","000004","000005","000006","000007","000008","000100","000101","000102","000200","000201","000202","000203","000204","000205","000206","000207","000208","000209","000210","000211","000212","000213","000214","000215","000216","000217","000303","000304","000305","000306","000307","000308","000400","000401","000402","000500","000501","000502","000600","000601","000602","000603","000604","000605","000606","000607","000608","000609","000610","000611","000612","000613","000614","000615","000700","000701","000702","000703","000704","000705","000706","000800","000801","000802","000803","000804","000805","000806","000807","000808","000809","000810","000811","000812","000813","000814","000815","000816","000817","000818","000819","000820","000821","000822","000823","000824","000825","000900","000901","001000","001001","001002","001003","001101","001102","001103","001104","001105","001106","001200","001211","001212","001213","001214","001215","001216","001217","001218","001219","001220","001221","001222","001223","001300","001301","001400","001401","001402","001403","001404","001405","001406","001407","001408","001409","001410","001411","001412","001413","001414","001415","001416","001418","001419","001420","001421","001422","001423","001424","001425","001426","001427","001428","001500","001501","001600","001601","001602","001603","001604","001605","001606","001607","001608","001609","001610","001611","001700","001701","001702","001703","001704","001705","001706","001707","001708","001709","001710","001711","001800","001801","001802","001803","001900","001901","001902","001903","002000","002001","002100","002101","002200","002201","002202","002203","002204","002205","002206","002207","002208","002209","002210","002211","002212","002213","002214","002215","002216","002217","002218","002300","002301","002302","002303","002304","002400","002401","002402","002403","002404","002405","002406","002407","002408","002409","002410","002500","002501","002600","002601","002602","002603","002604","002605","002606","002700","002701","002702","002703","002704","002705","002800","002801","002802","002803","002804","002805","002806","002900","002901","002902","002903","002904","002905","002906","003000","003001","003002","003100","003101","003102","003103","003104","003105","003106","003107","003108","003109","003110","003111","003112","003200","003201","003202","003203","003204","003300","003301","003302","003303","003400","003401","003402","003403","003404","003405","003406","003407","003408","003500","003501","003502","003600","003601","003602","003603","003604","003605","003700","003701","003702","003703","003704","003705","003706","003707","003800","003801","003802","003803","003804","003805","003900","003901","003902","004001","004002","004003","004004","004005","004006","004100","004101","004102","004201","004202","004203","004204","004205","004206","004300","004301","004302","004400","004401","004402","004403","004404","004500","004501","004502","004503","004504","004505","004506","004507","004508","004509","004510","004600","004601","004602","004700","004701","004800","004801","004900","004901","005000","005001","005003","005007","005100","005101","005102","005103","005104","005105","005106","005201","005202","005203","005204","005205","005206","005300","005301","005302","005400","005401","006300","006301","006303","006304","006305","006306","006307","006308","006309","006400","006401","006402","006500","006501","006600","006601","006700","006701","006800","006801","006900","006901","007000","007001","007002","007003","007004","007005","007006","007007","007100","007101","007102","007103","007200","007201","007202","007203","007204","007205","007206","007300","007301","007302","007303","007500","007501","007502","007503","007504","007505","007506","007600","007601","007602","007603","007604","007700","007701","007702","007703","007704","007800","007801","007802","007803","007804","007805","007806","007807","007808","007809","007810","007811","007812","007813","007814","007815","007900","007901","007902","007903","008000","008001","008002","008003","008100","008101","008102","008103","008104","008105","008106","008107","008300","008301","008302","008303","008304","008305","008400","008401","008402","008403","008404","008405","008406","008407","008408","008500","008501","008502","008503","008504","008508","008509","008510","008511","008512","008513","008514","008515","008516","008517","008518","008519","008520","008600","008601","008602","008603","008700","008701","008702","008703","008800","008900","008901","008902","008903","009000","009001","009002","009003","009100","009101","009102","009103","009104","009105","009106","009200","009201","009202","009203","009204","009205","009300","009301","100000","200000"};
		String[] ios521Arr = {"000000","000001","000002","000003","000004","000005","000006","000007","000008","000100","000101","000102","000200","000201","000202","000203","000204","000205","000206","000207","000208","000209","000210","000211","000212","000213","000214","000215","000216","000217","000303","000304","000305","000306","000307","000308","000400","000401","000402","000500","000501","000502","000600","000601","000602","000603","000604","000605","000606","000607","000608","000609","000610","000611","000612","000613","000614","000615","000700","000701","000702","000703","000704","000705","000706","000800","000801","000802","000803","000804","000805","000806","000807","000808","000809","000810","000811","000812","000813","000814","000815","000816","000817","000818","000819","000820","000821","000822","000823","000824","000825","000900","000901","001000","001001","001002","001003","001101","001102","001103","001104","001105","001106","001200","001211","001212","001213","001214","001215","001216","001217","001218","001219","001220","001221","001222","001300","001301","001400","001401","001402","001403","001404","001405","001406","001407","001408","001409","001410","001411","001412","001413","001414","001415","001417","001418","001419","001420","001421","001422","001423","001424","001425","001426","001427","001500","001501","001600","001601","001602","001603","001604","001605","001606","001607","001608","001609","001610","001611","001700","001701","001702","001703","001704","001705","001706","001707","001708","001709","001710","001800","001801","001802","001803","001900","001901","001902","001903","002000","002001","002100","002101","002200","002201","002202","002203","002204","002205","002206","002207","002208","002209","002210","002211","002212","002213","002214","002215","002216","002217","002218","002300","002301","002302","002303","002304","002400","002401","002402","002403","002404","002405","002406","002407","002408","002409","002410","002500","002501","002600","002601","002602","002603","002604","002605","002606","002700","002701","002702","002703","002704","002705","002800","002801","002802","002803","002804","002805","002806","002900","002901","002902","002903","002904","002905","002906","003000","003001","003002","003100","003101","003102","003103","003104","003105","003106","003107","003108","003109","003110","003111","003112","003200","003201","003202","003203","003204","003300","003301","003302","003303","003400","003401","003402","003403","003404","003405","003406","003407","003408","003500","003501","003502","003600","003601","003602","003603","003604","003605","003700","003701","003702","003703","003704","003705","003706","003707","003800","003801","003802","003803","003804","003805","003900","003901","003902","004001","004002","004003","004004","004005","004006","004100","004101","004102","004201","004202","004203","004204","004205","004206","004300","004301","004302","004400","004401","004402","004403","004404","004500","004501","004502","004503","004504","004505","004506","004507","004508","004509","004510","004600","004601","004602","004700","004701","004800","004801","004900","004901","005000","005001","005003","005007","005100","005101","005102","005103","005104","005105","005106","005201","005202","005203","005204","005205","005206","005300","005301","005302","005400","005401","006300","006301","006303","006304","006305","006306","006307","006308","006309","006400","006401","006402","006500","006501","006600","006601","006700","006701","006800","006801","006900","006901","007000","007001","007002","007003","007004","007005","007006","007007","007100","007101","007102","007103","007200","007201","007202","007203","007204","007205","007206","007300","007301","007302","007303","007500","007501","007502","007503","007504","007505","007506","007600","007601","007602","007603","007604","007700","007701","007702","007703","007704","007800","007801","007802","007803","007804","007805","007806","007807","007808","007809","007810","007811","007812","007813","007814","007815","007900","007901","007902","007903","008000","008001","008002","008003","008100","008101","008102","008103","008104","008105","008106","008107","008300","008301","008302","008303","008304","008305","008400","008401","008402","008403","008404","008405","008406","008407","008408","008500","008501","008502","008503","008504","008508","008509","008510","008511","008512","008513","008514","008515","008516","008517","008518","008519","008520","008600","008601","008602","008603","008700","008701","008702","008703","008800","008900","008901","008902","008903","009000","009001","009002","009003","009100","009101","009102","009103","009104","009105","009106","009200","009201","009202","009203","009204","009205","009300","009301","100000","200000"};
		
		String[] and601Arr = {"000001","000002","000101","000102","000103","000104","000105","000106","000107","000108","000109","000110","000111","000112","000113","000114","000115","000116","000117","000118","000119","000120","000121","000122","000123","000124","000125","000126","000127","000128","000129","000130","000131","000150","000151","000152","000153","000154","000155","000156","000201","000202","000203","000204","000205","000206","000207","000230","000231","000232","000233","000234","000235","000236","000237","000301","000302","000303","000304","000305","000306","000307","000401","000402","000403","000404","000405","000406","000407","000408","000409","000410","000411","000412","000413","000414","000415","000416","000417","000418","000501","000502","000503","000504","000505","000506","000507","000508","000601","000602","000603","000604","000605","000606","000607","000608","000609","000610","000611","000612","000613","000614","000615","000616","000617","000618","000619","000620","000621","000622","000623","000624","000625","000626","000627","000628","000629","000630","000631","000632","000633","000634","000701","000702","000801","000802","000803","000804","000805","000806","000807","000808","000809","000810","000811","000812","000813","000814","000815","000816","000817","000818","000819","000820","000821","000822","000823","000824","000825","000826","000827","000828","000901","000902","000903","001001","001002","001003","001004","001005","001006","001007","001008","001009","001101","001102","001103","001104","001105","001106","001107","001108","001109","001110","001111","001112","001113","001114","001115","001116","001117","001118","001119","001120","001121","001122","001123","001201","001202","001203","001204","001205","001306","001207","001208","001209","001301","001302","001303","001304","001305","001306","001307","001330","001331","001401","001402","001403","001404","001405","001406","001407","001408","001409","001410","001411","001412","001501","001502","001503","001601","001602","001603","001604","001605","001606","001607","001608","001609","001610","001701","001702","001703","001704","001705","001706","001707","001708","001709","001710","001801","001802","001803","001804","001805","001806","001807","001808","001809","001810","001811","001812","001901","001902","002001","002002","002003","002004","002005","002006","002007","002008","002009","002010","002011","002012","002013","002014","002101","002102","002103","002201","002202","002203","002204","002205","002206","002301","002302","002303","002304","002305","002401","002402","002403","002404","002405","002501","002502","002503","002504","002505","002601","002602","002603","002604","002605","002606","002607","002608","002701","002702","002703","002704","002705","002706","002707","002801","002802","002803","002804","002805","002806","002901","002902","002903","003001","003002","003003","003004","003005","003006","003007","003008","003009","003010","003011","003012","003013","003014","003015","003016","003017","003018","003019","003101","003102","003103","003104","003201","003202","003203","003301","003302","003303","003304","003305","003306","003307","003308","003309","003310","003311","003401","003402","003403","003404","003405","003406","003407","003408","003409","003409","003410","003411","003412","003413","003414","003415","003416","003417","003418","003419","003420","003421","003422","003423","003424","003425","003426","003427","003428","003429","003430","003431","003432","003433","003434","003435","003436","003437","003438","003439","003440","003441","003442","003443","003444","003445","003446","003447","003448","003449","003450","003451","003452","003453","003454","003455","003456","003452","003453","003459","003460","003461","003462","003463","003501","003502","003503","003504","003505","003506","003507","003508","003509","003510","003511","003512","003513","003514","003515","003601","003602","003603","003604","003605","003701","003702","003703","003704","003705","003706","003707","003708","003709","003710","003711","003712","003713","003714","003715","003716","003717","003718","003719","004001","004002","004003","004004","004005","004006","004007","004008","004009","004010","004011","004012","004013","004014","004015","004016","004017","004018","004019","004020","004021","004022","003901","003902","003903","003904","003905","003906","003907","003908","003909","003910","003911","003912","004101","004102","004103","004104","004105","004106","004107","004108","004109","004110","004201","004202","004203","004204","004301","004302","004303","004304","004305","004306","004307","004401","004402","004403","004404","004405","004406","004407","004408","004409","004410","004411","004412","004413","004414","004415","004501","004502","004503","004504","004505","004506","004507","004508","004601","004602","004603","004604","004605","004606","004701","004702","004703","004704","004705","004706","004707","004708","004709","004710","004711","004712","004713","004714","004715","004716","004801","004901","004902","004904","004905","004906","004907","004936","000237","005001","005002","005003","005004","005005","005006","005101","005102","005103","005104","005105","005106","005107","005108","005109","005110","005201","005202","005203","005204","005205","005301","005302","005401","005402","005403","400100","400200","007001","007002","007004","007006","007007","007008","007009","007010","007011","007101","007102","007103","007201","007202","007203","007204","007206","007207","007208","007209","007210","007211","007301","007302","007303","007401","007402","007403","007404","007406","007407","007408","007409","007410","007411","007501","007513","007514","007516","007518","007601","007603","007604","007606","007607","007608","007609","007610","007611","007701","007702","007703","007704","007705","007706","007707","007708","008001","008002","008003","008004","008005","008006","008007","008008","008009","008010","008101","008102","008103","008104","008105","008106","008201","008202","008301","008302","008303","008304","008305","008306","008307","008308","008309","008310","008401","008402","008403","008404","008405","008406","008407","008501","008502","008502","008503","010001","010001","050001","050002","005501","005502","005503","005504","005505","005506","005507","005508","005509","005510","005511","005512","005513","005514","005515","005516","005517","005518","100000","200000"};
		String[] and600Arr = {"00001","00002","00011","00012","00013","00014","00015","00016","00017","00018","00019","000110","000111","000112","000113","000114","000115","000116","000117","000118","000119","000120","000121","000122","000123","000124","000125","000126","000127","000128","000129","000130","000131","000150","000151","000152","000153","000154","000155","000156","00021","00022","00023","00024","00025","00026","00027","000230","000231","000232","000233","000234","000235","000236","000237","00031","00032","00033","00034","00035","00036","00037","00041","00042","00043","00044","00045","00046","00047","00048","00049","000410","000411","000412","000413","000414","000415","000416","000417","000418","00051","00052","00053","00054","00055","00056","00057","00058","00061","00062","00063","00064","00065","00066","00067","00068","00069","000610","000611","000612","000613","000614","000615","000616","000617","000618","000619","000620","000621","000622","000623","000624","000625","000626","000627","000628","000629","000630","000631","000632","000633","000634","00071","00072","00081","00082","00083","00084","00085","00086","00087","00088","00089","000810","000811","000812","000813","000814","000815","000816","000817","000818","000819","000820","000821","000822","000823","000824","000825","000826","000827","000828","00091","00092","00093","00101","00102","00103","00104","00105","00106","00107","00108","00109","00111","00112","00113","00114","00115","00116","00117","00118","00119","001110","001111","001112","001113","001114","001115","001116","001117","001118","001119","001120","001121","001122","001123","00121","00122","00123","00124","00125","00136","00127","00128","00129","00131","00132","00133","00134","00135","00136","00137","001330","001331","00141","00142","00143","00144","00145","00146","00147","00148","00149","001410","001411","001412","00151","00152","00153","00161","00162","00163","00164","00165","00166","00167","00168","00169","001610","00171","00172","00173","00174","00175","00176","00177","00178","00179","001710","00181","00182","00183","00184","00185","00186","00187","00188","00189","001810","001811","001812","00191","00192","00201","00202","00203","00204","00205","00206","00207","00208","00209","002010","002011","002012","002013","002014","00211","00212","00213","00221","00222","00223","00224","00225","00226","00231","00232","00233","00234","00235","00241","00242","00243","00244","00245","00251","00252","00253","00254","00255","00261","00262","00263","00264","00265","00266","00267","00268","00271","00272","00273","00274","00275","00276","00277","00281","00282","00283","00284","00285","00286","00291","00292","00293","00301","00302","00303","00304","00305","00306","00307","00308","00309","003010","003011","003012","003013","003014","003015","003016","003017","003018","003019","00311","00312","00313","00314","00321","00322","00323","00331","00332","00333","00334","00335","00336","00337","00338","00339","003310","003311","00341","00342","00343","00344","00345","00346","00347","00348","00349","00349","003410","003411","003412","003413","003414","003415","003416","003417","003418","003419","003420","003421","003422","003423","003424","003425","003426","003427","003428","003429","003430","003431","003432","003433","003434","003435","003436","003437","003438","003439","003440","003441","003442","003443","003444","003445","003446","003447","003448","003449","003450","003451","003452","003453","003454","003455","003456","003452","003453","003459","003460","003461","003462","003463","00351","00352","00353","00354","00355","00356","00357","00358","00359","003510","003511","003512","003513","003514","003515","00361","00362","00363","00364","00365","00371","00372","00373","00374","00375","00376","00377","00378","00379","003710","003711","003712","003713","003714","003715","003716","003717","003718","003719","00401","00402","00403","00404","00405","00406","00407","00408","00409","004010","004011","004012","004013","004014","004015","004016","004017","004018","004019","004020","004021","004022","00391","00392","00393","00394","00395","00396","00397","00398","00399","003910","003911","003912","00411","00412","00413","00414","00415","00416","00417","00418","00419","004110","00421","00422","00423","00424","00431","00432","00433","00434","00435","00436","00437","00441","00442","00443","00444","00445","00446","00447","00448","00449","004410","004411","004412","004413","004414","004415","00451","00452","00453","00454","00455","00456","00457","00458","00461","00462","00463","00464","00465","00466","00471","00472","00473","00474","00475","00476","00477","00478","00479","004710","004711","004712","004713","004714","004715","004716","00481","00491","00492","00494","00495","00496","00497","004936","000237","00501","00502","00503","00504","00505","00506","00511","00512","00513","00514","00515","00516","00517","00518","00519","005110","00521","00522","00523","00524","00525","00531","00532","00541","00542","00543","40010","40020","00701","00702","00704","00706","00707","00708","00709","007010","007011","00711","00712","00713","00721","00722","00723","00724","00726","00727","00728","00729","007210","007211","00731","00732","00733","00741","00742","00743","00744","00746","00747","00748","00749","007410","007411","00751","007513","007514","007516","007518","00761","00763","00764","00766","00767","00768","00769","007610","007611","00771","00772","00773","00774","00775","00776","00777","00778","00801","00802","00803","00804","00805","00806","00807","00808","00809","008010","00811","00812","00813","00814","00815","00816","00821","00822","00831","00832","00833","00834","00835","00836","00837","00838","00839","008310","00841","00842","00843","00844","00845","00846","00847","00851","00852","00852","00853","01001","01001","05001","05002","00551","00552","00553","00554","00555","00556","00557","00558","00559","00559","00559","005511","005511","005513","005514","005516","005517","005518","100000","200000"};
		String[] and531Arr = {"000001","000002","000101","000102","000103","000104","000105","000106","000107","000108","000109","000110","000111","000112","000113","000114","000115","000116","000117","000118","000119","000120","000121","000122","000123","000124","000125","000126","000127","000128","000129","000130","000131","000150","000151","000152","000153","000154","000155","000156","000201","000202","000203","000204","000205","000206","000207","000230","000231","000232","000233","000234","000235","000301","000302","000303","000304","000305","000306","000307","000401","000402","000403","000404","000405","000406","000407","000408","000409","000410","000411","000412","000413","000414","000415","000416","000417","000418","000501","000502","000503","000504","000505","000506","000507","000601","000602","000603","000604","000605","000606","000607","000608","000609","000610","000611","000612","000613","000614","000615","000616","000617","000618","000619","000620","000621","000622","000623","000624","000625","000626","000627","000628","000629","000630","000631","000701","000702","000801","000802","000803","000804","000805","000806","000807","000808","000809","000810","000811","000812","000813","000814","000815","000816","000817","000818","000819","000820","000901","000902","000903","001001","001002","001003","001004","001005","001006","001007","001008","001009","001101","001102","001103","001104","001105","001106","001107","001108","001109","001110","001111","001112","001113","001114","001115","001116","001117","001118","001201","001202","001203","001204","001205","001306","001207","001208","001209","001301","001302","001303","001304","001305","001306","001307","001330","001331","001401","001402","001403","001404","001405","001406","001407","001408","001409","001410","001411","001412","001501","001502","001503","001601","001602","001603","001604","001605","001606","001607","001608","001609","001610","001701","001702","001703","001704","001705","001706","001707","001708","001709","001710","001801","001802","001803","001804","001805","001806","001807","001808","001809","001901","001902","002001","002002","002003","002004","002005","002006","002007","002008","002009","002010","002011","002012","002101","002102","002103","002201","002202","002203","002204","002205","002206","002301","002302","002303","002304","002305","002401","002402","002403","002404","002405","002501","002502","002503","002504","002505","002601","002602","002603","002604","002605","002606","002607","002608","002701","002702","002703","002704","002705","002801","002802","002803","002804","002805","002806","002901","002902","002903","003001","003002","003003","003004","003005","003006","003007","003008","003009","003010","003011","003012","003013","003014","003015","003016","003017","003018","003019","003101","003102","003103","003104","003201","003202","003203","003301","003302","003303","003304","003305","003306","003307","003308","003309","003310","003311","003401","003402","003403","003404","003405","003406","003407","003408","003409","003410","003411","003412","003413","003414","003415","003416","003417","003418","003419","003420","003421","003422","003423","003424","003425","003426","003427","003428","003429","003430","003431","003432","003433","003434","003435","003436","003437","003438","003439","003440","003441","003442","003443","003444","003445","003446","003447","003448","003449","003450","003451","003452","003453","003454","003455","003456","003452","003453","003459","003460","003461","003462","003463","003501","003502","003503","003504","003505","003506","003507","003508","003509","003510","003511","003512","003513","003601","003602","003603","003604","003605","003701","003702","003703","003704","003705","003706","003707","003708","003709","003710","003711","003712","003713","003714","003715","003716","003717","003718","003719","004001","004002","004003","004004","004005","004006","004007","004008","004009","004010","004011","004012","004013","004014","004015","004016","004017","003901","003902","003903","003904","003905","003906","003907","003908","003909","003910","003911","003912","004101","004102","004103","004104","004105","004106","004201","004202","004203","004204","004301","004302","004303","004304","004305","004306","004307","004401","004402","004403","004404","004405","004406","004407","004408","004409","004410","004411","004412","004413","004414","004415","004501","004502","004503","004504","004505","004506","004507","004508","100000","200000"};
		String[] and521Arr = {"000001","000002","000101","000102","000103","000104","000105","000106","000107","000108","000109","000110","000111","000112","000113","000114","000115","000116","000117","000118","000119","000120","000121","000122","000123","000124","000125","000126","000127","000128","000129","000130","000150","000151","000152","000153","000154","000155","000156","000201","000202","000203","000204","000205","000206","000207","000230","000231","000232","000233","000234","000301","000302","000303","000304","000305","000306","000307","000401","000402","000403","000404","000405","000406","000407","000408","000409","000410","000411","000412","000413","000414","000415","000416","000417","000501","000502","000503","000504","000505","000601","000602","000603","000604","000605","000606","000607","000608","000609","000610","000611","000612","000613","000614","000615","000616","000617","000618","000619","000620","000621","000622","000623","000701","000702","000801","000802","000803","000804","000805","000806","000807","000808","000809","000810","000811","000812","000813","000814","000815","000901","000902","000903","001001","001002","001003","001004","001005","001006","001007","001008","001009","001101","001102","001103","001104","001105","001106","001107","001108","001109","001110","001111","001112","001113","001114","001201","001202","001203","001204","001205","001306","001207","001208","001209","001301","001302","001303","001304","001305","001306","001307","001330","001331","001401","001402","001403","001404","001405","001406","001407","001408","001409","001410","001411","001412","001501","001502","001503","001601","001602","001603","001604","001605","001606","001607","001608","001609","001610","001701","001702","001703","001704","001705","001706","001707","001708","001709","001710","001801","001802","001803","001804","001805","001806","001807","001808","001809","001901","001902","002001","002002","002003","002004","002005","002006","002007","002008","002101","002102","002103","002201","002202","002203","002204","002205","002206","002301","002302","002303","002304","002305","002401","002402","002403","002404","002405","002501","002502","002503","002504","002505","002601","002602","002603","002604","002605","002606","002607","002608","002701","002702","002703","002704","002705","002801","002802","002803","002804","002805","002806","002901","002902","002903","003001","003002","003003","003004","003005","003006","003007","003008","003009","003010","003011","003012","003013","003014","003015","003016","003017","003018","003019","003101","003102","003103","003104","003201","003202","003203","003301","003302","003303","003304","003305","003306","003307","003308","003309","003310","003311","003401","003402","003403","003404","003405","003406","003407","003408","003409","003410","003411","003412","003413","003414","003415","003416","003417","003418","003419","003420","003421","003422","003423","003424","003425","003426","003427","003428","003429","003430","003431","003432","003433","003434","003435","003436","003437","003438","003439","003440","003441","003442","003443","003444","003445","003446","003447","003448","003449","003450","003451","003452","003453","003454","003455","003456","003452","003453","003459","003460","003461","003462","003463","003501","003502","003503","003504","003505","003506","003507","003508","003509","003510","003511","003512","003513","003601","003602","003603","003604","003605","003701","003702","003703","003704","003705","003706","003707","003708","003709","003710","003711","003712","003713","003714","003715","003716","003717","003718","003719","004001","004002","004003","004004","004005","004006","004007","004008","004009","004010","004011","004012","004013","004014","004015","004016","004017","003901","003902","003903","003904","003905","003906","003907","003908","003909","003910","003911","003912","004101","004102","004103","004104","004105","004106","004201","004202","004203","004204","004301","004302","004303","004304","004305","004306","004401","004402","004403","004404","004405","004406","004407","004408","004408","004410","004411","004412","100000","200000"};
		
		verl.add("IOSH050300");
		verl.add("IOSH050201");
		verl.add("ANDH050301");
		verl.add("ANDH050201");
		verl.add("IOSH060000");
		verl.add("ANDH060000");
		verl.add("ANDH060001");
		
		verm.put(verl.get(0), ios530Arr);
		verm.put(verl.get(1), ios521Arr);
		verm.put(verl.get(2), and531Arr);
		verm.put(verl.get(3), and521Arr);
		verm.put(verl.get(4), ios600Arr);
		verm.put(verl.get(5), and600Arr);
		verm.put(verl.get(5), and601Arr);
	}
	//private static String[] verarr = { };
	//private static String[] otherArr = {"0000"};
	public static int verChange(String div,String pbid)
	{
		
		initMap();
		int index = -1;
		
		if(verl.contains(div))
		{
			String[] pgarr = (String[]) verm.get(div);
			index = calIndex(pgarr,pbid);
		}
		return index;
		
	}
	public static String indexChage(String ver,int index)
	{
		initMap();
		String pgid = "10248964";		
		 if(verm.get(ver)==null) 
		 {
			 pgid = "bad version";
		 }
		 else
		 {
			 String[] pgidArr = verm.get(ver);
			 if(pgidArr.length < index)
			 {
				 pgid = "bad length";
			 }
			 else
			 {
				 pgid = verm.get(ver)[index];
			 }
		 }
		
		return pgid;
	}
	public static int calIndex(String[] pgArr,String pdid)
	{
		String id = pdid;
		int index = -1 ;
		List<String> pgidList = Arrays.asList(pgArr);
		if(!pgidList.contains(id)) index = -1 ;
			index = pgidList.indexOf(id);
		return index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println(PBID2MatrixIndex.verChange("IOSH050201","100000"));
		System.out.println(PBID2MatrixIndex.indexChage("IOSH050201",150));
	}

}