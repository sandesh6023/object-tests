import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;

public class PersonTest {
    Person swamiji = new Person("Swamiji", 3);
    Person kunal = new Person("Kunal", 50);
    Person digvijay = new Person("Digvijay", 35);

    public static List addPeopleToList(Person... persons) {
        List<Person> people = new ArrayList<Person>();
        for (Person person : persons) {
            people.add(person);
        }
        return people;
    }

    //comparators
    @Test
    public void testSortPeopleByNameLength() throws Exception {
        List<Person> people = addPeopleToList(digvijay, kunal, swamiji);
        List<Person> expected = addPeopleToList(kunal, swamiji, digvijay);

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().length() - p2.getName().length();
            }
        });
        assertEquals(expected, people);

    }

    @Test
    public void testSortPeopleByAge() throws Exception {
        List<Person> people = addPeopleToList(digvijay, kunal, swamiji);
        List<Person> expected = addPeopleToList(swamiji, digvijay, kunal);

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getAge() - p2.getAge();
            }
        });
        assertEquals(expected, people);

    }

    @Test
    public void testSortPeopleByName() throws Exception {
        List<Person> expected = addPeopleToList(digvijay, kunal, swamiji);
        List<Person> people = addPeopleToList(swamiji, digvijay, kunal);

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                String name1 = p1.getName();
                String name2 = p2.getName();
                return name1.compareTo(name2);
            }
        });
        assertEquals(expected, people);

    }

    @Test
    public void testSortPeopleDescByName() throws Exception {
        List<Person> people = addPeopleToList(digvijay, kunal, swamiji);
        List<Person> expected = addPeopleToList(swamiji, kunal, digvijay);

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                String name1 = p1.getName();
                String name2 = p2.getName();
                return name2.compareTo(name1);
            }
        });
        assertEquals(expected, people);
    }

    // equals and hashcode
    @Test
    public void testEqualsOfPersonWithCorrectEqualsAndHashcode() throws Exception {
        Person vivek = new Person("Swamiji", 3);
        boolean result = swamiji.equals(vivek);
        assertEquals(true, result);
    }

    @Test
    public void testEqualsOfPersonWithIncorrectEqualsAndHashcode() throws Exception {
        Person vivek = new Person("Swamiji", 3) {
            @Override
            public int hashCode() {
                int result = age;
                return result;
            }

            @Override
            public boolean equals(Object o) {
                if (this.hashCode() == o.hashCode()) return true;
                return false;
            }
        };

        boolean result = vivek.equals(swamiji);
        assertEquals(false, result);
    }


    // inserting in different data structure
    @Test
    public void testInsertInHashMapShouldOverWriteForSameData() {
        Person vivek = new Person("Swamiji", 3);
        HashMap<Person, Person> peopleMap = new HashMap<Person, Person>();
        peopleMap.put(swamiji, swamiji);
        peopleMap.put(vivek, vivek);
        assertEquals(1, peopleMap.size());
    }

    @Test
    public void testInsertInHashMapShouldNotOverWriteIfNotEqual() {
        HashMap<Person, Person> peopleMap = new HashMap<Person, Person>();
        peopleMap.put(swamiji, swamiji);
        peopleMap.put(digvijay, digvijay);
        assertEquals(2, peopleMap.size());
    }

    @Test
    public void testInsertInSetShouldOverWrite() {
        Person vivek = new Person("Swamiji", 3);
        Set<Person> people = new HashSet<Person>();
        people.add(swamiji);
        people.add(vivek);
        assertEquals(1, people.size());
    }

    @Test
    public void testInsertInSetShouldNotOverWriteIfHashCodeNotImplemented() {
        Person vivek = new Person("Swamiji", 3) {
            @Override
            public int hashCode() {
                int result = age;
                return result;
            }

            @Override
            public boolean equals(Object o) {
                if (this.hashCode() == o.hashCode()) return true;
                return false;
            }
        };
        Set<Person> people = new HashSet<Person>();
        people.add(swamiji);
        people.add(vivek);
        assertEquals(2, people.size());
    }

    @Test
    public void testInsertInArrayList() {
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(kunal);
        people.add(digvijay);
        assertEquals(2, people.size());
    }
}