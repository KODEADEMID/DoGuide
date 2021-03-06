package kodeA.doguide.UhodInfo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kodeA.doguide.R

class Plus : AppCompatActivity() {

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
        setContentView(R.layout.activity_plus)

        val intent = getIntent()
        var Breed = intent.getStringExtra("Breed")

        var sharedPrefs = getSharedPreferences("kodeA.doguide", Context.MODE_PRIVATE)
        Breed = sharedPrefs.getString("Breed", Breed)

        val editor = sharedPrefs.edit()
        editor.apply{
            putString("Breed", Breed)
        }.apply()

        dogname=Breed.toString()
        textv2 = findViewById(R.id.textView2) as TextView
        textv2.setText(dogname)
        ph=findViewById(R.id.imageView) as ImageView
        dog1 ="⦁\tВ качестве первого плюса собак этой породы стоит отметить компактные размеры животного. Завести маленького питомца могут позволить себе даже владельцы малогабаритных квартир. Для ⦁\tсодержания французского бульдога будет достаточно выделить небольшой уголок.\n" +

                "⦁\tПредставители этой породы прекрасно поместятся на коленках у хозяина и с удовольствием поваляются рядом на кресле. Они смогут приспособиться к любым условиям содержания.\n" +

                "⦁\tНо небольшой размер собаки отнюдь не говорить об ограниченных способностях. Скорее наоборот – французский бульдог станет отличным охранником, лаем сообщая о подозрительных шумах или приходе чужих людей.\n" +

                "⦁\tДа и защитник из него выйдет неплохой. Серьезное выражение морды, мускулистое тело и хриплый лай питомца смогут отпугнуть всех, кто осмелится угрожать спокойствию его хозяина. В бою он тоже может себя проявить.\n" +

                "⦁\tЕсли приложить некоторые усилия при воспитании и дрессировке собаки, то со временем она станет проявлять агрессию только в экстренном случае. В остальное время французский бульдог будет равнодушно относиться к другим животным во время прогулки.\n" +

                "⦁\tВообще собаки этой породы не лают по пустякам, находясь дома. Это также является большим достоинством, особенно для хозяев, проживающих в квартире — не будет лишних ссор с соседями по поводу очередной бессонной ночи из-за шумного питомца.\n" +

                "⦁\tУ французского бульдога среди всех его характеристик есть такая интересная особенность, как сломанный от природы хвост. Поэтому, отпадает необходимость специально его купировать (отрезать часть).\n" +

                "⦁\tТак как представители этой породы обладают коротким шерстяным покровом, то и ухаживать за ним будет легко. Шерсть расчесывается быстро и просто, без использования специальных приспособлений. Вдобавок ко всему этих собак еще и не надо часто купать – их шерсть особо не пачкается, да и специфического собачьего запаха не имеет. Поэтому от услуг груминг-салонов можно будет отказаться.\n" +

                "⦁\tФранцузский бульдог легко находит общий язык с детьми, любит играть с ними, но в пределах разумного. За такими играми лучше следить, чтобы никто никого не покалечил.\n" +

                "⦁\tПрирода наградила собак этой породы умом, любознательностью и смекалкой. Это, в сочетании со спокойным характером, делает их сообразительными друзьями, верными и послушными. Конечно, если в характере животного не возьмут верх лень и упрямство. Но это решается с помощью своевременного воспитания и дрессировки с обязательным элементом поощрения в виде лакомства.\n" +

                "⦁\tСреди положительных характеристик французского бульдога стоит отметить, что у него есть чувство юмора. Если хозяину будет грустно, питомец сумеет это почувствовать и постарается поднять ему настроение.\n"
        dog2 ="⦁\tДружелюбие. Основной характеристикой таких псов является их приветливость со всеми. Хаски не подают признаков агрессии, а значит, и прогулки во дворах не будут приносить неудобство для соседей.\n" +
                "\n" +
                "⦁\tВыносливость и здоровье. Происхождение такой породы в условиях холода и ветра привело к стойкости и работоспособности собак.\n" +
                "\n" +
                "⦁\tВнешний вид собаки. Невозможно не влюбиться в хаски. Голубые или карие глаза, вытянутая морда, пропорциональное туловище и мягкая шерсть – все это идеально создает картинку красивого пса.\n" +
                "\n" +
                "⦁\tОтлично подойдет для семей с детьми. Как говорилось ранее, изначально хаски были выведены эскимосами, которые доверяли собакам свое потомство и не боялись взаимодействия между ними. Еще с тех времен у них сохранилось трепетное отношение и особая любовь к детям.\n" +
                "\n" +
                "⦁\tПрактически не лает. Если вы собираетесь завести пса такой породы в квартире, то это будет несомненным преимуществом. Нередко конфликты между соседями происходит по причине не прекращаемого лая весь день, в то время как с хаски такой проблемы не будет.\n" +
                "\n" +
                "⦁\tШерсть и кожа не имеют запаха. Псы такой породы довольно чистоплотны, а значит и купать их нужно не так часто. Двух раз в год будет вполне достаточно. Шерсть их непромокаемая.\n" +
                "\n" +
                "⦁\tНе требует особой еды. Кормить хаски можно, так же как и других собак. Они не едят исключительно мясо и другие продукты, стоимость которых будет сопоставима с едой, покупаемой для людей.\n" +
                "\n" +
                "⦁\tВысокий интеллект. Хаски отличаются отличным складом ума. Как минимум, это выражается в том, что они любят игры, в которых нужно что-то искать.\n"
        dog3 ="⦁\tРазмеры. В отличие от овчарок, своих предков, корги не занимают очень много места и подходят даже для содержания в городской квартире. Их перенос и перевозка не требуют излишних усилий, потому что найти переноску для такой маленькой собаки гораздо проще, чем для большого кобеля.\n" +
                "\n" +
                "⦁\tМиролюбивость. Предварительно корги не испытывают ровным счётом никакой ненависти ни к кому, кто их окружает, будь это люди или другие животные. Если, глядя на фотографии, вам кажется, что корги улыбается – скорее всего, так и есть, потому что это – одна из самых жизнерадостных собак. Разумеется, если она почувствует что-то неладное, она даст об этом знать, залаяв и напав на потенциального обидчика – с разной степенью успеха.\n" +
                "\n" +
                "⦁\tПреданность. Попадая в семью, корги, как и многие собаки, выбирает себе одного хозяина, к которому привязывается больше остальных. К прочим членам семьи собака будет относиться с не меньшей лаской, не проявляя к ним излишней ревности и положительно реагируя на попытки общения. Благодаря своему внешнему виду, корги становятся любимцами малышей и без возражений терпит попытки играться и обниматься.\n" +
                "\n" +
                "⦁\tАдаптируемость. Корги не относятся к привередливым собакам, впадающим в апатию при смене обстановки. При переезде или даже недлительной поездке у пса не возникнет никаких отрицательных ощущений – он быстро привыкнет к новой обстановке.\n" +
                "\n" +
                "⦁\tЖивой ум. Корги легко поддаются дрессировке и обладают высоким интеллектом – ровно как и все овчарки. Этот же интеллект позволяет им уловить слабые места хозяина, если тот начинает их показывать – и, потенциально, даёт им мотивацию возвыситься над хозяином и выстраивать отношения именно таким образом. Чтобы этого не допустить, корги нужно строго воспитывать, не позволяя природному обаянию пса затмить ваш рассудок.\n" +
                "\n" +
                "⦁\tНенавязчивость. Хотя пёс корги, не имеющий занятия, начинает откровенно скучать и может навредить имуществу хозяина, в целом, эта собака довольно тактична и ненавязчива. Если она почувствует, что хозяин не готов с ней играть, она не будет настаивать или обижаться – хотя не факт, что занятие, которое придётся ей по душе, понравится её хозяину.\n"
        dog4 ="⦁\tБигли веселые и добродушные собаки. Они без проблем ладят со взрослыми и детьми, а также спокойно уживаются с другими собаками и кошками. Агрессивными данные собаки бывают достаточно редко (например, по отношению к незнакомым людям).\n" +
                "\n" +
                "⦁\tЭти собаки очень подвижны и мобильны, благодаря чему они являются отличными компаньонами в охоте, в спорте и играх.\n" +
                "\n" +
                "⦁\tНесмотря на то, что бигли обожают своего хозяина, они достаточно легко переносят разлуку с ним, поэтому владелец бигля может спокойно отправляться в путешествие, доверив своего питомца надёжной передержке или ответственным знакомым.\n" +
                "\n" +
                "⦁\tБольшинство биглей могут работать в дрессировке при грамотном подходе к обучающему процессу.\n" +
                "\n" +
                "⦁\tБигли почти никогда не линяют, благодаря своей короткой шерсти. За шерстью собаки несложно ухаживать с помощью специальной перчатки или щетки.\n" +
                "\n" +
                "⦁\tКупание бигля не доставляет хозяевам особых проблем, поскольку собак настоящей породы следует мыть достаточно редко.\n" +
                "\n" +
                "⦁\tУход за зубами и глазами также не доставит хозяевам бигля особых хлопот. Зубы следует чистить раз в неделю, а глаза ежедневно протирать салфеткой, смоченной в чистой воде, ромашковом настое или специальном средстве для гигиены глаз.\n"
        dog5 ="⦁\tУниверсальная охотничья собака, работающая как по птице, так и по зверю, в том числе, по крупным копытным. Многофункциональность – всегда хорошо!\n" +
                "\n" +
                "⦁\tМожет охотиться в любое время года и в самых различных условиях — в лесу, поле, в заболоченной местности, в горах. \n" +
                "\n" +
                "⦁\tСобачка легко учится работать по новому виду дичи, например, в США и Канаде Вахтельхундов используют для охоты на медведей-барибалов. Смелы, отважны и злобны по отношению к потенциальной добыче во время охоты. \n" +
                "\n" +
                "⦁\tДоброжелательное и спокойное отношение к людям присущи данной породе.\n" +
                "\n" +
                "⦁\tОбщительны и ладят со всеми членами семьи, в том числе и с маленькими детьми. \n" +
                "\n" +
                "⦁\tУмны и хорошо обучаемы, не поддаются агрессии во время тренировок.\n" +
                "\n" +
                "⦁\tСобаки данной породы умеют приспосабливаться к любым условиям и достаточно неприхотливы. \n" +
                "\n" +
                "⦁\tНенавязчивы: не любят путаться у хозяев под ногами, не будут назойливы. \n"
        dog6 ="⦁\tВысокий интеллект. Так как изначально вывод овчарки затачивался под выполнение любого рода задач, это положительно сказалось на уровне их интеллекта. Помимо того, что овчарки легко поддаются дрессировке, они способны выполнять задачи, непосильные другим породам. Именно по этой причине немецкие овчарки часто находятся на службе в армии и полиции.\n" +
                "\n" +
                "⦁\tЭмоциональная уравновешенность. При правильном воспитании, овчарка никогда не будет создавать конфликт на пустом месте. У неё не будет проблем ни с представителями своего вида, ни с другими – даже с кошками. То же касается и человеческих детёнышей, с которыми овчарки прекрасно ладят и с которыми могут даже поиграть. В особенности это касается собак женского пола – вне зависимости от того, что ребёнок будет с ними делать, они не станут проявлять агрессию. Тем не менее, оставлять собаку наедине с детьми не рекомендуется.\n" +
                "\n" +
                "⦁\tПриятный характер. Поладить с немецкой овчаркой совсем не сложно. Есть собаки, избалованные от природы, очень своенравные – но не эта порода. Их поведение и действия можно всегда объяснить, и даже если хозяин сделал что-то не так, чем-то обидев своего питомца, овчарка никогда не станет мстить. Про таких собак говорят, что они чётко знают своё место и понимают, что собака не может быть главнее человека.\n" +
                "\n" +
                "⦁\tНеприхотливость. Неважно, в каких условиях вы будете содержать немецкую овчарку – чтобы оставаться счастливой, ей достаточно еды и питья. В противном случае она будет существовать даже в полевых условиях и никогда не возненавидит за это своего хозяина. Если же условия её содержания изменились по какой-то причине, питомец очень быстро к ним адаптируется.\n" +
                "\n" +
                "⦁\tХрабрость. Размер и характер немецкой овчарки подразумевают преданную службу семье своих хозяев. Если собака живёт в пригородном доме, она всегда почует опасность от недоброжелателя и будет до последнего защищать то, что ей доверили. Они бесстрашно набросятся на обидчика, не пожалев на него, если потребуется, своих клыков – хотя собака не бойцовская, это ей удаётся ничуть не хуже.\n" +
                "\n" +
                "⦁\tПреданность. Правильно воспитанная собака готова служить своему хозяину до гроба и будет защищать его до последнего вздоха, при этом не игнорируя членов его семьи. Она будет относиться к ним ласково и будет готова защитить каждого, не подчёркивая, что хозяин принадлежит только ей, как это делают некоторые ревнивые породы.\n"
        dog7 ="⦁\tТакса прекрасный товарищ, за которым не требуется специального ухода. В содержании они не прихотливы, главное любить своего питомца и уделять внимание.\n" +
                "\n" +
                "⦁\tОтносится к числу малогабаритных пород собак, что дает возможность завести такую породу, даже в маленькой квартире, не требуя особо многого пространства.\n" +
                "\n" +
                "⦁\tПотрясающие несоответствие маленькой коротконогой собаки и мощного интеллекта делает ее уникальной. Не зря она попадает в первую десятку умных собак. Таксы в повседневной жизни могут проявлять чрезмерную самостоятельность, изобретательность и хитрость, все это вследствие своего охотничьего нрава.\n" +
                "\n" +
                "⦁\tИспытывает по-настоящему большую привязанность к своему хозяину. Становится настоящим верным другом по жизни и любимцем семьи.\n" +
                "\n" +
                "⦁\tОтличный компаньон для игр и всегда с легкостью идет на контакт с детьми. Очень терпелива и может стать хорошей нянькой, а также защитницей для своих маленьких хозяев.\n" +
                "\n" +
                "⦁\tСобаки этой породы очень выносливы и энергичны. С легкостью подстраивается под ритм жизни своего хозяина. Для них в радость будет побегать с вами по утрам либо совершать долгие пешие прогулки по городу.\n" +
                "\n" +
                "⦁\tТакса прирожденный охотник и таковым должна оставаться. Необходимо найти компромиссные решения, почаще вывозить таксу на природу, давать ей побегать, найти след дичи, тогда вы не лишите ее охотничьей хватки и сохраните особенность породы.\n" +
                "\n" +
                "⦁\tНесмотря на свой миниатюрный вид, являются отличными охранниками. Всегда предупредят своим громким голосом и никого не подпустят близко к хозяину. В случае опасности смогут дать жесткий отпор, борясь до последнего.\n" +
                "\n" +
                "⦁\tОтличаются чистоплотностью и воспитанностью. Никогда не пойдет гулять в дождь и не будет валяться в куче мусора, как это любят делать многие собаки.\n" +
                "\n" +
                "⦁\tЛегкообучаемые и легко поддаются дрессировке. Понимают с полуслова, что от них хотят.\n" +
                "\n" +
                "⦁\tОтносятся к долгожителям среди пород других собак. При правильном уходе, заботе и любви продолжительность жизни может составить более 12 лет.\n" +
                "\n" +
                "⦁\tОтличаются артистичностью и эмоциональностью. С такой собакой владелец никогда не заскучает. Такса умеет читать по глазам в каком расположении духа находится ее хозяин, когда можно с ним поиграть, а когда следует его оставить наедине.\n"
        dog8 ="⦁\tОтличный сторож. Если уж и использовать фразу «Собака – друг человека», то именно в контексте этой породы. Всё потому, что доберманам свойственны все положительные качества, приписываемые этим животным: верность своему хозяину и его семьи, храбрость и самоотверженность при охране жилья. Поэтому доберманов так и любят – они красивы не только внешне, но и внутри.\n" +
                "\n" +
                "⦁\tВысокий интеллект. Если есть необходимость приучить добермана к чему угодно, огромных проблем это не вызовет. Конечно, придётся приложить некоторые усилия, но этой породе свойственен недюжинный ум, поэтому и времени на дрессировку уйдёт недолго. И даже если есть необходимость научить питомца специальным командам, питомец будет впитывать как губка.\n" +
                "\n" +
                "⦁\tЛюбопытство. Доберману можно предложить любое дело или любую забаву – ему всё будет интересно. На прогулках он не станет сразу же тянуть хозяина домой, потому что ему будет интересно всё разнюхать и познакомиться с новыми запахами. К тому же он довольно легко соглашается на игры – в том числе с детьми (хотя оставлять их без присмотра нельзя).\n" +
                "\n" +
                "⦁\tФизика. Хотя официально доберманы не считаются боевой породой, для драки они подходят идеально. В конце концов, именно ради этого их разводили – и, тем не менее, при должном воспитании, драчливость и агрессия отойдут на задний план, но вот сила и мощь останутся. Что с этими достоинствами делать, решает, конечно же, только сам хозяин. Конечно, для начала можно ими просто любоваться, но не стоит забывать, что гора мышц и мускулов требует, чтобы о них заботились.\n" +
                "\n" +
                "⦁\tПоддерживают активный образ жизни. Если хозяин сам не из тех, кто любит отсиживаться дома, то собака станет его верным спутником во всех жизненных начинаниях. Будь это внезапное решение научиться ездить на велосипеде, или сходить в поход, полный энергии доберман сможет всегда составить компанию. Поэтому если вы давно хотели начать жить здорово, собака может во многом помочь – хотя бы потому, что совесть заставит вас встать поутру и выгулять собаку, которая не против побегать лишние пару часиков. И даже плохая погода оправданием не станет.\n" +
                "\n" +
                "⦁\tПреданность хозяину и его семье. Существуют общительные собаки, для которых не имеет значения, с кем они будут дружить – с хозяевами, или с кем ещё. Это ничуть не их недостаток, но доберманы, тем не менее, от него избавлены – помимо хозяина и членов его семьи, для них не существует никого другого. Поэтому при любой опасности, когда есть риск жизни любимых людей, собака не пожалеет себя, разобравшись с обидчиком.\n" +
                "\n" +
                "⦁\tУниверсальность. В принципе, для чего бы вы ни искали себе собаку, доберман будет уместен везде – кроме, разве что, ленивого образа жизни. Они сильны, энергичны, легко поддаются дрессировке – изначально их разведением занимались с целью создать универсальную полицейскую собаку. И это им удалось!\n"
        dog9 ="⦁\tЕсли вам нужен идеальный компаньон, то лабрадор лучше всего для этого подходит. Еще щенком пес быстро привязывается к владельцу, радует хозяина преданностью на протяжении жизни.\n" +
                "\n" +
                "⦁\tЛабрадор – активная собака, которой требуются постоянные прогулки, вне зависимости от погодных условий. Если вы ведете правильный образ жизни, поддерживаете физическую форму, то домашний питомец с удовольствием разделит эти стремления, будучи надежным напарником на пробежках.\n" +
                "\n" +
                "⦁\tКак и все породы с прямым шерстным покровом средней длины, этой собаке не требуется груминг, что существенно облегчает уход за густой шерстью. Для поддержания блеска и красоты необходимо раз в 3 недели расчесывать питомца с помощью фурминатора. Устройство отлично убирает с поверхности отмершую шерсть, улучшая этим внешний вид покрова. После прогулок на природе шерсть нужно вычесывать металлической расческой, это поможет избавиться от колючек.\n" +
                "\n" +
                "⦁\tЖивотное неприхотливо в питании, так как имеет хороший аппетит. Давать питомцу можно домашнюю пищу или сухой корм.\n" +
                "\n" +
                "⦁\tЩенки быстро обучаются командам, но начинать дрессировку необходимо практически с нескольких недель жизни питомца.\n"
        dog10 ="⦁\tУм и дрессировка. Про умственные способности колли сказано достаточно. Из этого следует, что они легко поддаются дрессировке, быстро осваивают команды.\n" +
                "\n" +
                "⦁\tРабочие способности. Использовать бордер-колли можно не только как друзей, но и как коллег. Это актуально для служивых людей. Также интересный факт – собаку можно брать с собой на охоту и рыбалку.\n" +
                "\n" +
                "⦁\tВозможность домашнего содержания. Бывают породы, которые дома содержать не получается. К таким часто относят хаски и овчарок. Связана эта невозможность скорее с тем, что не все могут подстроить микроклимат дома под атмосферу пса. С колли не возникнет проблем! Они выведены для помощи человеку, и потому хорошо уживаются с людьми.\n" +
                "\n" +
                "⦁\tПодходящий характер питомца. Все хотят именно такую собачку – веселую, любящую побегать, поиграть. С бордер-колли можно уподобиться фильмам, поиграть с собакой в «апорт». Также выдрессированного питомца выставляют как преимущество перед друзьями и знакомыми – мол, смотрите, как мой Бобик может! И «ко мне», и «сидеть» знает!\n" +
                "\n" +
                "⦁\tСредний размер. Говоря честно, держать большую собаку в доме – нереально сложное занятие. А держать большую собаку в квартире – просто нереальное. Устроить комфорт и при этом проследить, чтобы питомец не разгромил все жилище, крайне сложно. В квартирах советуют держать мелких или средних собак. Бордер-колли подходит по данному критерию – порода относится к числу средних.\n"

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