# Lab Report 3 - Researching `grep`

Grep is a utility that lets you search for a pattern in a file. In the following lab report, I will go through four different command line option for grep and detail their use. All commands were found using in the manual for grep.

## `-i`
This option has grep ignore the case of the pattern, making ur input query not case-sensitive. It's useful when you're searching for patters that are both upper and lower case.

Examples:
```bash
$ find . -name "*.txt" | grep -i athens
./travel_guides/berlitz2/Athens-History.txt
./travel_guides/berlitz2/Athens-WhereToGo.txt
./travel_guides/berlitz2/Athens-Intro.txt
./travel_guides/berlitz2/Athens-WhatToDo.txt
```

```bash
$ find . -name "*.txt" | grep -i bahamas
./travel_guides/berlitz2/Bahamas-WhatToDo.txt
./travel_guides/berlitz2/Bahamas-History.txt
./travel_guides/berlitz2/Bahamas-WhereToGo.txt
./travel_guides/berlitz2/Bahamas-Intro.txt
```

## `-w`
This option has grep only match the pattern to whole words. It won't match to any substrings of words. This is useful if you want to find a word, and not the words that it's a part of.

Examples:
```bash
$ find . -name "*.txt" | grep -iw athens
./travel_guides/berlitz2/Athens-History.txt
./travel_guides/berlitz2/Athens-WhereToGo.txt
./travel_guides/berlitz2/Athens-Intro.txt
./travel_guides/berlitz2/Athens-WhatToDo.txt
$ find . -name "*.txt" | grep -iw athen
```

```bash
$ grep -iw hindu HistoryIndia.txt
        crossed the Hindu Kush mountains into the Indus valley in 530 b.c.
        musicians, and also dancers who were the precursors of the Hindu
        state at Ghazni and began raids across the border to plunder Hindu
        a modified form of the Hindu caste system. Highest were those of
        south remained dominated by the Hindu kingdom of Vijayanagar for the
        the Hindu empire of Vijayanagar by means of slaughter, but they were
        manners, and morals, enriched by the Hindu culture of the Rajputs in
        Hindu temples in both Varanasi and Mathura were destroyed, and the
        brought back; Hindu merchants were forced to pay double duties on their
        authentic Hindu folk hero.
        group of liberal Hindu and Parsi intellectuals, supported by a few
        Muslims tried to purify the Islamic practice of the Hindu rituals which
        Nehru’s Congress Party, largely Hindu with a socialist
        Hindu fanatic, enraged by what he felt was an excessively fervent
        Hindu, as was the maharaja. Backed by Pakistan, Pathan tribesmen
        child-marriage, and the treatment of women in Hindu households, but
        parties including the Hindu nationalist Bharatiya Janata Party (BJP).
```

## `-A`, `-B`, `-C`
These control how much context is shown before and after the match, in lines. `A` controls after the match, `B` controls before the match, and `C` controls both before and after. This can be very useful when grepping files like xml files, where you want to find the tag and also the content inside the tag.

Examples:
```bash
$ grep -A 1 -iw hindu HistoryIndia.txt
        crossed the Hindu Kush mountains into the Indus valley in 530 b.c.
        While Brahman and Persian scholars exchanged ideas, the Indians copied
--
        musicians, and also dancers who were the precursors of the Hindu
        devadasi temple prostitutes.
--
        state at Ghazni and began raids across the border to plunder Hindu
        temples.
--
        a modified form of the Hindu caste system. Highest were those of
        foreign extraction such as Turks, Arabs, Afghans, and Persians, known
--
        south remained dominated by the Hindu kingdom of Vijayanagar for the
        next 250 years.
--
        the Hindu empire of Vijayanagar by means of slaughter, but they were
        not going to hand it all to Akbar.
--
        manners, and morals, enriched by the Hindu culture of the Rajputs in
        literature, cuisine, and sexuality. If the peasants were squeezed by
--
        Hindu temples in both Varanasi and Mathura were destroyed, and the
        building of new temples was forbidden. Taxes on non-Muslims were
        brought back; Hindu merchants were forced to pay double duties on their
        goods.
--
        authentic Hindu folk hero.
        Starting out from Pune, Shivaji’s Marathas fought off the
--
        group of liberal Hindu and Parsi intellectuals, supported by a few
        progressive British, it was more national in purpose than in its
--
        Muslims tried to purify the Islamic practice of the Hindu rituals which
        had accrued over the years.
--
        Nehru’s Congress Party, largely Hindu with a socialist
        leadership, wanted a parliamentary democracy. As counterweight, British
--
        Hindu fanatic, enraged by what he felt was an excessively fervent
        defense of the Muslim interests, assassinated Gandhi in a prayer
--
        Hindu, as was the maharaja. Backed by Pakistan, Pathan tribesmen
        invaded Kashmir in 1947 to force the issue, but were soon repulsed by
--
        child-marriage, and the treatment of women in Hindu households, but
        century-old customs die hard: before his death in 1964, he asked that
--
        parties including the Hindu nationalist Bharatiya Janata Party (BJP).
        The National Front attempted to set up a new government first with V.
```

```bash
$ grep -C 1 -iw finger IntroGreek.txt
        world.
        The Aegean is a small sea, a finger of water 640 km (397
        miles) long, and 320 km (198 miles) wide, pointing up out of the
--
        car-rental agencies, ticket offices, and studio apartments to manage.
        He needs to keep his finger on the pulse to succeed during the short
        tourist season.
```

## `-c`
Not to be confused with `-C`, this lowercase `c` counts the number of matches. So instead of doing something like `grep -c -iw hindu HistoryIndia.txt | wc` like we did in class, we can directly do `grep -c -iw hindu HistoryIndia.txt`.

Examples:
```bash
$ grep -c -iw hindu HistoryIndia.txt
17
```

```bash
$ grep -c -iw hello HistoryIndia.txt
0
```