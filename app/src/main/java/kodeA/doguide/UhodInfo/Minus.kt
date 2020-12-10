package kodeA.doguide.UhodInfo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kodeA.doguide.R

class Minus : AppCompatActivity() {

    lateinit var textv: TextView
    lateinit var textv2: TextView
    lateinit var ph: ImageView
    lateinit var dog1: String //Французский бульдог
    lateinit var dog2: String //Хаски
    lateinit var dog3: String //Корги
    lateinit var dog4: String //Бигль
    lateinit var dog5: String //Немецкий спаниель
    lateinit var dog6: String //Немецкая овчарка
    lateinit var dog7: String //Такса
    lateinit var dog8: String //Доберман
    lateinit var dog9: String //Лабрадор
    lateinit var dog10: String //Колли
    lateinit var dogname: String//порода пользователя, приравнять
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minus)

        val intent = getIntent()
        var Breed = intent.getStringExtra("Breed")

        var sharedPrefs = getSharedPreferences("kodeA.doguide", Context.MODE_PRIVATE)
        Breed = sharedPrefs.getString("Breed", Breed)

        val editor = sharedPrefs.edit()
        editor.apply{
            putString("Breed", Breed)
        }.apply()

        dogname= Breed.toString()
        textv2 = findViewById(R.id.textView2) as TextView
        ph=findViewById(R.id.imageView) as ImageView
        textv2.setText(dogname)
        dog1 ="⦁\tМаленький размер и короткая шерсть собаки в определенный момент превращаются в большой минус. Ведь представители этой породы не выдерживают слишком высоких и слишком низких температур. Из-за прямых солнечных лучей в жаркое время года французские бульдоги могут легко получить солнечный удар, а малейший сквозняк может привести к простуде у животного.\n" +
                "\n" +
                "⦁\tПоэтому хозяину придется одевать питомца в холодное время года в теплые ⦁\tкомбинезоны, не выходить на улицу в жаркий пик лета. Во время водных процедур придется заранее хорошо подготавливать помещение для купания, а после укутывать собаку в большое полотенце. Дождь и снег могут стать препятствием для прогулки без предварительной подготовки.\n" +
                "\n" +
                "⦁\tИз-за этих проблем желательно отказаться от купания в водоемах. Мало того, что собака может простудиться, французскому бульдогу еще и очень тяжело дается плавание из-за большой головы и мощно развитой мускулатуры.\n" +
                "\n" +
                "⦁\tУ французских бульдогов есть своеобразные складки на морде, а у некоторых представителей породы хвост очень плотно прилегает к туловищу. В этих местах может завестись грибок, поэтому придется периодически осматривать собаку для предотвращения воспаления или образования гнойников, а также протирать проблемные участки как минимум влажной тряпочкой.\n" +
                "\n" +
                "⦁\tМногим хозяевам придется столкнуться с проблемами во время чистки ушей своему питомцу. Это обязательное дело, так как у французских бульдогов довольно большие и открытые уши. Но эти собаки не очень-то любят эту процедуру и могут сопротивляться.\n" +
                "\n" +
                "⦁\tСобаки этой породы имеют в своей характеристике такую особенность, как храп и испускание газов во время сна. Всему виной своеобразное анатомическое строение морды и дыхательных путей, а также проблемы с пищеварительной системой – некоторые продукты животное плохо усваивает. Например, молоко.\n" +
                "\n" +
                "⦁\tОтсюда появляется еще один минус – у французских бульдогов чаще, чем у других пород, проявляется аллергическая реакция на внешние раздражители и некоторые продукты.\n" +
                "\n" +
                "⦁\tУ некоторых собак можно периодически наблюдать обильное слюноотделение. Для многих хозяев это может стать большим минусом, особенно для тех, кто имеет чистоплотный характер или беспокоится за своих маленьких детей.\n" +
                "\n" +
                "⦁\tФранцузские бульдоги, несмотря на свой спокойный и уравновешенный характер, могут порой повести себя в семейном кругу неожиданно: могут перевернуть дом верх дном во время очередной вспышки активности; могут обидеться, и надолго; могут укусить, если что-то не понравилось.\n" +
                "\n" +
                "⦁\tЕще один минус, который нужно обязательно отметить у представителей этой породы – упрямый и ленивый темперамент. Без своевременного обучения хорошим манерам и уроков послушания, французские бульдоги могут увиливать от выполнения команд. Если хозяин будет лениться, то и питомец недалеко пойдет. Без постоянных повторов пройденного материала собака просто откажется подчиняться командам.\n" +
                "\n" +
                "⦁\tФранцузские бульдоги не переносят одиночества и обожают внимание. Поэтому для занятых людей такие питомцы просто не подойдут. Конечно, воспитанная собака подождет, когда хозяин освободится и начнет с ней играть, но не целый же день.\n" +
                "\n" +
                "⦁\tМужественный французский бульдог не знает страха. Это, конечно, хорошо, но если в качестве соперника выступает большой пес, тогда это минус. Из-за внезапной агрессии маленький питомец может получить серьезные травмы.\n"
        dog2 ="⦁\tЗа притягательной внешностью скрывается упрямый характер.\n" +
                "\n" +
                "⦁\tПитомец своенравен и хитер. С воспитанием могут возникнуть сложности.\n" +
                "\n" +
                "⦁\tХаски учились самостоятельно добывать себе пищу из поколения в поколение, поэтому на прогулках собаки считают, что все условно съедобное – их законная добыча.\n" +
                "\n" +
                "⦁\tЭто охотник, готовый в любую минуту продемонстрировать все свои умения на дворовых кошках, белках и другой живности. Но охотится он сам для себя. Не ждите, что пес принесет вам добычу.\n" +
                "\n" +
                "⦁\tСклонность к побегам довольно высокая. Владельцу нужно всегда держать в поле зрения своего питомца.\n" +
                "\n" +
                "⦁\tСкучающий хася станет разрушителем в доме. Чаще это случается при квартирном содержании. Пес может изрядно подпортить интерьер.\n" +
                "\n" +
                "⦁\tУ породы исторически не выработался набор ферментов для питания кашами. В рационе должны преобладать белки животного происхождения. Такое меню обходится недешево.\n" +
                "\n" +
                "⦁\tНе подходит слабым и мягким людям, не обладающим должным терпением.\n"
        dog3 ="⦁\tКусаются за пятки. Изначально корги помогали пастухам – и, гоняясь за овцами, собирая их в стадо, покусывали им лапы. Эта привычка заложена на генном уровне: они и сейчас кусают людей за пятки, пытаясь собрать их в одну кучу. Сами зубы ног не касаются – это скорее похоже на неприятный щипок. В особенности это проявляется среди юных щенков, которых ещё не воспитывали – но от этой привычки собаку при желании можно отучить.\n" +
                "\n" +
                "⦁\tОчень активны. Пастушье прошлое даёт о себе знать и в энергии, способной скопиться в этих маленьких собачках – её может быть очень много, и если вовремя её не выплёскивать, это может привести к некоторого рода неприятностям. Если не гулять с собакой по три раза в день, она может начать крушить мебель в квартире – так что если у вас нет на это времени, лучше даже не задумываться над покупкой щенка корги.\n" +
                "\n" +
                "⦁\tВесьма прожорливы. Особи корги весьма крупные сами по себе, поэтому, если начать откармливать их, словно на убой, они могут запросто ожиреть. С ожирением связаны сопутствующие заболевания, поэтому отбирать рацион для собаки нужно очень тщательно.\n" +
                "\n" +
                "⦁\tТребуют тщательного ухода за шерстью. Густая шерсть корги – не только их достоинство, но и минус, в особенности для ленивого владельца. Собаку нужно регулярно расчёсывать, чтобы шерсть не путалась, а когда она начнёт линять – тем более.\n" +
                "\n" +
                "⦁\tНе умеют охранять территорию. Существуют бойцовые собаки, существуют те, кто настолько предан хозяевам, что грозятся атаковать, только заслышав опасность – а есть корги, которые любят всех, без разбору. Оставлять эту породу охранять дом очень не рекомендуется, так как излишняя ласка не только не спугнёт грабителя, но и подвергнет самого корги опасности.\n" +
                "\n" +
                "⦁\tБесстрашны. Удивительно, но их абсолютная дееспособность к сторожевой деятельности спокойно уживается с безумным бесстрашием, когда дело доходит до общения с другими собаками – в особенности, с теми, кто в несколько раз превосходит корги по размерам. Завидев пса, даже если тот не настроен агрессивно, корги может броситься на него с лаем – поэтому спускать его с поводка не рекомендуется.\n" +
                "\n" +
                "⦁\tПронзительный голос. Если корги начнёт лаять, никто и не подумает, что это – голос настолько маленькой собаки. Кому-то это покажется достоинством, но в том случае, если вы предпочитаете тишину, а от громкого лая у вас начинает звенеть в ушах, можно постараться отучить пса от этой привычки – или не заводить корги вовсе.\n" +
                "\n" +
                "⦁\tВысокая стоимость. Так как корги – породистые собаки, найти представителя породы даже в приюте очень тяжело. Высокая популярность заставляет заводчиков повышать цены на ещё не рождённых щенков – цена за такую радость может подниматься до 60,000 рублей. Конечно, останавливает это не всех, но если вы стиснуты в бюджете, возможно, лучше поискать породу дешевле.\n"
        dog4 ="⦁\tК недостаткам характера и темперамента данной породы, можно отнести ту же излишнюю подвижность. Такая собака не сможет ужиться с постоянно занятыми людьми, а также с теми, кто любит проводить свой досуг, нежась в постели или сидя перед телевизором. Сложно будет поладить с биглем и большинству пожилых людей, которые физически не смогут угнаться за слишком активным животным.\n" +
                "\n" +
                "⦁\tОднозначно, такая порода, как бигль, не подойдёт интровертам. Ведь когда хозяева находятся дома, неутомимый и общительный бигль ходит за ними буквально по пятам.\n" +
                "\n" +
                "⦁\tИногда бигли могут упрямиться и требовать от хозяев немало терпения. Многие сталкиваются с такими проблемами, как сложный процесс приручения молодых биглей к туалету, порча животным мебели и отделки дома. Рекомендуется приобрести вольер для бигля и оставлять собаку там. Но долго сидеть там активный питомец не сможет. Вольер для бигля следует хорошо укрепить, иначе он не спасёт жилище, обувь и предметы интерьера от возможных повреждений.\n" +
                "\n" +
                "⦁\tБигли очень любят лаять и делают это даже во сне, что может существенно осложнить отношения хозяев собаки с соседями при проживании в многоквартирном доме.\n" +
                "\n" +
                "⦁\tПроведение регулярной гигиены ушных раковин, к которой бигля придётся упорно приучать с ранних лет. Уши бигля имеют не простое строение, и за ними следует регулярно и правильно ухаживать, применяя специальные средства.\n" +
                "\n" +
                "⦁\tСвоевременная и правильная подстрижка когтей, их регулярный осмотр, профилактика и устранение повреждений. Достаточно уязвимым местом являются когти собаки. В связи с её излишней активностью, на когтях могут образовываться расслоения и трещины. Здесь также помогут специальные защитные средства.\n"
        dog5 ="⦁\tНе подходят в качестве обычных компаньонов, так как не могут обходиться без охоты. \n" +
                "\n" +
                "⦁\tНуждаются в довольно больших физических нагрузках и длительных прогулках, так как созданы для охоты.\n" +
                "\n" +
                "⦁\tЛучше всего себя чувствуют в условиях сельской местности, в городе скучают.\n" +
                "\n" +
                "⦁\tМогут проявлять агрессию к некрупным животным, так как являются прирожденными охотниками. \n" +
                "\n" +
                "⦁\tНе терпит грубого обращения и незаслуженных обид. \n" +
                "\n" +
                "⦁\tРедкая порода, из-за чего не всегда легко бывает найти подходящего щенка.\n"
        dog6 ="⦁\tТребуют много воспитательной работы. Действительно, немецкая овчарка, в которую хозяин вложил много усилий и ресурсов, может стать не только верным другом, но и защитником. Но что, если на это просто не хватает времени или умений? К примеру, для того чтобы овчарка охраняла дом, нужно пройти специальные курсы – если со стандартной дрессировкой хозяин ещё справится, то для этого нужны отдельные специалисты. Даже элементарные правила воспитания, не привитые вовремя, могут сказаться на отношениях собаки и её хозяина – вплоть до того, что овчарка возомнит, что именно она – главная, а не хозяин.\n" +
                "\n" +
                "⦁\tОстрые клыки. То, что является преимуществом в охране дома, может также стать и минусом в том случае, если этот момент был упущен в процессе воспитания. Другими словами, если собаке не объяснить вовремя, что кусаться нельзя (она может делать это ненамеренно, просто играя и не понимая, какую боль способна причинить), её укусы могут быть опасны для человека.\n" +
                "\n" +
                "⦁\tВозможная агрессивность. Недостача воспитания может также сказаться на поведении собаки вплоть до неконтролируемых приступов агрессии. Бороться с этим можно, например, прикупив намордник, но проблему это не решит.\n" +
                "\n" +
                "⦁\tНеобходимость регулярно заниматься и гулять на свежем воздухе. Немецкие овчарки очень энергичны, а тратить энергию, сидя на месте, невозможно. Поэтому, заводя питомца, нужно быть готовым к тому, что он будет тянуть вас на прогулку, вне зависимости от того, насколько уставшим вы себя чувствуете, и какая на улице погода. Конечно, для тех, кто регулярно встаёт по утрам и отправляется на пробежку, это не проблема, но если это не про вас, к чему издеваться над собой и над животным? Даром что если овчарку подолгу не выводить на улице, она может стать агрессивной и может не слушаться своего хозяина.\n" +
                "\n" +
                "⦁\tТребуют много свободного места. Немецкая овчарка идеально подходит для загородного дома, в котором есть место для игр и прогулок, но в городской квартире собаке будет ужасно скучно, не говоря уже о том, что иногда даже размер квартиры не подразумевает нахождение в ней такого большого существа. Конечно, если вы готовы посвящать собаке несколько часов в день, тратя на каждую прогулку по часу и больше три раза в день, проблем не возникнет – но если нет, у вас могут быть трудности.\n" +
                "\n" +
                "⦁\tНеобходимость регулярно убираться. Когда овчарка начинает линять, об этом тут же узнают все, кто живёт в квартире, потому что шерсть появляется повсюду в изобильных количествах. Убираться нужно постоянно. Более того: чистюли могут начать возмущаться специфическим запахом собаки, который требует постоянных проветриваний или, если есть такая возможность, будку на улице.\n"
        dog7 ="⦁\tНужно следить за рационом и весом питомца, так как чрезмерное потребление пищи может привести к ожирению и проблемам со здоровьем.\n" +
                "\n" +
                "⦁\tМалоподвижный образ жизни, отсутствие физических упражнений делают таксу злой и истеричной. Накопленная энергия оборачивается стрессом. Собака из-за этого может лаять и выть в отсутствие своего хозяина, сводя с ума соседей.\n" +
                "\n" +
                "⦁\tСамое распространенное заболевание, выявленное у этой породы — это генетический дефект позвоночника. Им нужно избегать прыжков по креслам, диванам и долгой беготни по лестницам. Все эти движения могут повлечь за собой травму.\n" +
                "\n" +
                "⦁\tНе идет на контакт с другими животными. Ревностно относится к ним. Сложно уживается с другими питомцами дома, показывая сразу кто является главным. Возможна дружба только со своими собратьями таксами, либо с собаками других пород, если знает их с детства или росла вместе с ними. В противном случае будет считаться виновником ссоры.\n" +
                "\n" +
                "⦁\tТаксы отличаются боевым характером. Никогда не пойдет на уступки. Если ей что-то не нравится, то покажет сопротивление и агрессию в полной мере. И наоборот, если ей что-либо захотелось она приложит все усилия чтоб заполучить желаемое. Вход может пустить свое обаяние, стоит только им посмотреть своими вымаливающими глазками, как хозяин раздобрится.\n" +
                "\n" +
                "⦁\tСледует привыкнуть к тому, что таксы постоянно, что-то роют и закапывают. Нет ничего удивительного, если такса вам перероет все на земельном участке или закапает свою любимую игрушку в вашей пастели. С помощью крепких когтей такса быстро расчищает себе дорогу от препятствий. Она может прорыть яму в 45 см за минуту.\n" +
                "\n" +
                "⦁\tСложно приучить ходить на поводке. На это может уйти достаточно время и усилий, но все же со временем и возрастом начнет прислушиваться своего хозяина.\n" +
                "\n" +
                "⦁\tОни очень упрямые, обидчивые и даже злопамятны. Всегда хотят поступать по–своему.\n" +
                "\n" +
                "⦁\tЧасто от переизбытка радости может происходить непроизвольное мочеиспускание. Эта проблема исчезнет только уже во взрослом возрасте.\n"
        dog8 ="⦁\tСклонность к доминированию. Доберманы – благородная порода, и, по мере взросления, они могут начать чувствовать своё превосходство над другими – в том числе над человеком. В этом нет ничего страшного, если вовремя показать щенку, где его место, и кто «в доме хозяин». Тем не менее, доберманы требуют большего воспитания, чем крохотные собаки, чем отпугивают потенциальных владельцев – и не зря. Если питомец не увидит в хозяине лидера, равного себе, отношения испортятся, что навредит и собаке, и хозяину.\n" +
                "\n" +
                "⦁\tУпрямство. Хотя со временем собаку можно приучить к тому, «кто в доме хозяин», поначалу это может вызывать сильный дискомфорт. Хозяева чаще всего покупают собаку, когда та ещё совсем маленькая – и по мере того, как щенок растёт, отрицательные качества породы начинают проявляться всё заметнее. Это и упрямство, и неприятие чужой точки зрения, и многое другое, что требует пристального надзора и воспитания… если вы к этому готовы, тогда можете смело заводить питомца этой породы.\n" +
                "\n" +
                "⦁\tТребуют много внимания. Даже смирившись с тем, что власть в доме принадлежит не им, доберманы будут требовать, чтобы на них обращали внимание. Играли с ними, гуляли – энергии в таком теле очень много, и если вовремя её не расходовать, она может дать обратный эффект и превратить собаку в крайне агрессивное животное.\n" +
                "\n" +
                "⦁\tКороткая шерсть. Короткая шерсть определённо не доставит неудобств в период линьки, но во все остальные времена года, особенно в зиму, она может неплохо ударить по кошельку. Чтобы питомец не мёрз, ему придётся покупать согревающую одежду, в которой не нуждаются, например, овчарки. Мало того, что это дополнительные затраты – на самом деле, даже одеть питомца в такую попону может быть сложно, а уж подобрать – тем более.\n" +
                "\n" +
                "⦁\tПолное неприятие кошек. Существуют дружелюбные породы, которые уживаются с любым животным, будь то крысы, попугаи, хомяки, даже кошки – но не доберманы. Кошек они на дух не переносят, и уж точно не согласятся жить с кошкой в одном доме. Так что, если кошку вы уже завели, а теперь раздумываете над поиском «компаньона» для игр, лучше рассмотреть собаку другой породы.\n" +
                "\n" +
                "⦁\tФинансовые затраты. Как и собаки любой другой породы, чистокровные доберманы очень дорого стоят. Конечно, зачастую в стоимость входят сделанные прививки, родословная и иногда даже отсутствие генетических заболеваний, но крупная сумма на завод собаки найдётся не у каждого. Да и после этого потребуются немалые расходы – на корм, на игрушки, на одежду… одним словом, если денег и так не очень много, доберман может сильно ударить по бюджету.\n"
        dog9 ="⦁\tЕсли решили завести лабрадора, то нужно знать, что эта порода имеет определенные недостатки. Людям, которые привыкли вести неактивный образ жизни, эта собака не подходит, так как жизнь лабрадора без достаточных физических нагрузок и регулярных прогулок просто нельзя представить.\n" +
                "\n" +
                "⦁\tСчитается, что эта порода имеет отменное здоровье, однако это не исключает большого списка болезней. \n" +
                "\n" +
                "⦁\tТакже эти собаки имеют склонность к ожирению, что приводит к развитию патологий суставов.\n" +
                "\n" +
                "⦁\tЛабрадору требуется качественное питание, при этом ежедневно он может съесть около 500 г корма. То есть, для людей с ограниченными финансовыми возможностями лабрадор вряд ли подойдет, так как содержание довольно дорогостоящее.\n" +
                "\n" +
                "⦁\tЛинька – еще одна особенность породы. Взрослый пес линяет 2-3 раза за год. Причем это начинает сопровождаться значительным выпадением шерстного покрова. Шерсть может оставаться на полу, на кровати, мебели.\n" +
                "\n" +
                "⦁\tТак как лабрадоры очень социальные животные, людям, которые часто отсутствуют дома, эта порода не подходит.\n"
        dog10 ="⦁\tНеобходимость обучения. Если у хозяина нет желания вместо друга получить гиперактивную заводную игрушку, которая абсолютно не слушает команд и не понимает приказов, то придется обязательно выдрессировать питомца.\n" +
                "\n" +
                "⦁\tМного времени на уход. Дрессировка, ежедневные процедуры по сохранности внешнего вида – требующие времени события. Помимо этого, понадобится продолжительный выгул.\n" +
                "\n" +
                "⦁\tТребовательная шерсть. Колли бывают длинношерстные и гладкошерстные. И те, и другие требуют ежедневного вычесывания шерстяного покрова.\n" +
                "\n" +
                "⦁\tЗатраты на питание и ветеринарные процедуры. Столь умный питомец требует недюжинных трат на покупку кормов. Кушать колли изволят лишь корм премиум-класса. Точнее, съедят они все что угодно, но здоровыми останутся лишь при правильной закупке. Дешевые корма навредят организму.\n" +
                "\n" +
                "⦁\tИзлишняя самостоятельность. Даже послушному и обученному псу сложно внушить необходимость измерения границ возможной для пробежки территории. Поэтому часты случаи, когда представители данной породы убегают. В лучшем случае побег будет непродолжительным и пес вернется в скором времени. В худшем собаку можно потерять навсегда. Исходя из этого, следует выводить питомца на прогулку на поводке, что вызовет дополнительные проблемы (выбор изделия, подгонка).\n"

        textv = findViewById(R.id.textView) as TextView
        if(dogname=="Французский бульдог") {
            textv.setText(dog1)
            ph.setImageResource(R.drawable.viewdog1)
        }
        else if(dogname=="Хаски") {
            textv.setText(dog2)
            ph.setImageResource(R.drawable.viewdog2)
        }
        else if(dogname=="Корги") {
            textv.setText(dog3)
            ph.setImageResource(R.drawable.viewdog3)
        }
        else if(dogname=="Бигль") {
            textv.setText(dog4)
            ph.setImageResource(R.drawable.viewdog4)
        }
        else if(dogname=="Немецкий спаниель") {
            textv.setText(dog5)
            ph.setImageResource(R.drawable.viewdog5)
        }
        else if(dogname=="Немецкая овчарка") {
            textv.setText(dog6)
            ph.setImageResource(R.drawable.viewdog6)
        }
        else if(dogname=="Такса") {
            textv.setText(dog7)
            ph.setImageResource(R.drawable.viewdog7)
        }
        else if(dogname=="Доберман") {
            textv.setText(dog8)
            ph.setImageResource(R.drawable.viewdog8)
        }
        else if(dogname=="Лабрадор") {
            textv.setText(dog9)
            ph.setImageResource(R.drawable.viewdog9)
        }
        else if(dogname=="Колли") {
            textv.setText(dog10)
            ph.setImageResource(R.drawable.viewdog10)
        }
    }
}