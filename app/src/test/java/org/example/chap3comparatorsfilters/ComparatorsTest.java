package org.example.chap3comparatorsfilters;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class ComparatorsTest {
    private static final String TIM = "Tim";
    private static final String TOM = "Tom";
    private static final String ALF = "Alf";
    private static final Person TIM_55 = new Person(TIM, 55);
    private static final Person TOM_25 = new Person(TOM, 25);
    private static final String ALICE = "Alice";
    private static final Person ALICE_30 = new Person(ALICE, 30);
    private static final Person ALF_31 = new Person(ALF, 31);
    private static final String BOB = "Bob";
    private static final Person BOB_31 = new Person(BOB, 31);
    private static final String CATH = "Cath";
    private static final Person CATH_45 = new Person(CATH, 45);
    private static final String DAVE = "Dave";
    private static final Person DAVE_45 = new Person(DAVE, 45);
    private static final List<Person> PERSONS = List.of(
            TIM_55, ALICE_30, BOB_31, CATH_45
    );
    private static final List<Person> PERSONS_WITH_SAME_AGE = List.of(
            TIM_55, ALICE_30, BOB_31, CATH_45, DAVE_45
    );
    private static final List<Person> PERSONS_WITH_SAME_INITIAL = List.of(
            TIM_55, TOM_25, ALICE_30, ALF_31
    );
    private final ComparatorExample uut = new ComparatorExample();

    @Test
    void testAscendingAge() {
        List<Person> persons = List.of(
                TIM_55, ALICE_30, BOB_31, CATH_45
        );

        List<Person> byAge = uut.sortAscendingAge(persons);

        assertThat(byAge).isEqualTo(List.of(
                ALICE_30, BOB_31, CATH_45, TIM_55
        ));
    }

    @Test
    void testAscendingAgeMethodRef() {
        List<Person> byAge = uut.sortAscendingAgeMethodRef(PERSONS);

        assertThat(byAge).isEqualTo(List.of(
                ALICE_30, BOB_31, CATH_45, TIM_55
        ));
    }

    @Test
    void testDescendingAgeMethodRef() {
        List<Person> byAge = uut.sortDescendingAge(PERSONS);

        assertThat(byAge).isEqualTo(List.of(
                TIM_55, CATH_45, BOB_31, ALICE_30
        ));
    }

    @Test
    void testOldest() {
        Optional<Person> oldest = uut.findOldest(PERSONS);

        assertThat(oldest.get()).isEqualTo(TIM_55);
    }

    @Test
    void testByName() {
        List<Person> byName = uut.sortAscendingName(PERSONS);

        assertThat(byName).isEqualTo(List.of(
                ALICE_30, BOB_31, CATH_45, TIM_55
        ));
    }

    @Test
    void testByAgeThenName() {
        List<Person> byName = uut.sortAscendingAgeThenName(PERSONS_WITH_SAME_AGE);

        assertThat(byName).isEqualTo(List.of(
                ALICE_30, BOB_31, CATH_45, DAVE_45, TIM_55
        ));
    }

    @Test
    void testGroupingByAge() {
        Map<Integer, List<Person>> grouped = uut.groupByAge(PERSONS_WITH_SAME_AGE);

        assertThat(grouped).isEqualTo(
                Map.of(30, List.of(ALICE_30),
                        31, List.of(BOB_31),
                        45, List.of(CATH_45, DAVE_45),
                        55, List.of(TIM_55)
        ));
    }

    @Test
    void testGroupingNameByAge() {
        Map<Integer, List<String>> grouped = uut.namesGroupByAge(PERSONS_WITH_SAME_AGE);

        assertThat(grouped).isEqualTo(
                Map.of(30, List.of(ALICE),
                        31, List.of(BOB),
                        45, List.of(CATH, DAVE),
                        55, List.of(TIM)
        ));
    }

    @Test
    void testOldestByInitial() {
        Map<Character, Optional<Person>> grouped = uut.oldestByInitial(PERSONS_WITH_SAME_INITIAL);

        assertThat(grouped).isEqualTo(
                Map.of('T', Optional.of(TIM_55),
                        'A', Optional.of(ALF_31))
        );
    }
}
