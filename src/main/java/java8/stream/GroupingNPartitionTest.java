package java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @author : flutterdash@qq.com
 * @date : 2020年09月04日 22:33
 */
public class GroupingNPartitionTest {

    public static void main(String[] args) {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        // 按照国家分组
        Map<String, List<Locale>> countryToLocales = locales.collect(
                Collectors.groupingBy(Locale::getCountry));

        // 使用Set做为集合
        Map<String, Set<Locale>> countryToLocalesSet = locales.collect(
                Collectors.groupingBy(Locale::getCountry, toSet()));

        // 统计每个国家的Locale个数
        Map<String, Long> countryToLocalCounts = locales.collect(
                groupingBy(Locale::getCountry, counting()));

        Map<Boolean, List<Locale>> englishAndOtherLocals = locales.collect(
                /**
                 * Map<K:Boolean, V:List>
                 * 这个方法产生一个值为布尔的结果，并将这个数据项做为Value放入List中
                 */
                Collectors.partitioningBy(l -> l.getLanguage().equals("en")));
        List<Locale> englishLocales = englishAndOtherLocals.get(true);


    }

}
